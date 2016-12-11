package state.main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * サンプルコードから引いてきた、ダサい
 * @author ict816
 *
 */
public class SafeFrame extends Frame implements ActionListener, Context {
    private TextField textClock = new TextField(60);        // 現在時刻表示
    private TextArea textScreen = new TextArea(10, 60);     // 警備センター出力
    private Button buttonUse = new Button("金庫使用");      // 金庫使用ボタン
    private Button buttonAlarm = new Button("非常ベル");    // 非常ベルボタン
    private Button buttonPhone = new Button("通常通話");    // 通常通話ボタン
    private Button buttonExit = new Button("終了");         // 終了ボタン

    private HourOperation operation = DayOperation.getInstance();           // 現在の状態

    // コンストラクタ
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClockを配置
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreenを配置
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // パネルにボタンを格納
        Panel panel = new Panel();
        panel.add(buttonUse);
        panel.add(buttonAlarm);
        panel.add(buttonPhone);
        panel.add(buttonExit);
        // そのパネルを配置
        add(panel, BorderLayout.SOUTH);
        // 表示
        pack();
        setVisible(true);
        // リスナーの設定
        buttonUse.addActionListener(this);
        buttonAlarm.addActionListener(this);
        buttonPhone.addActionListener(this);
        buttonExit.addActionListener(this);
    }

    // ボタンが押されたらここに来る
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == buttonUse) {           // 金庫使用ボタン
            operation.doWhenUsingSafe(this);
        } else if (e.getSource() == buttonAlarm) {  // 非常ベルボタン
            operation.doWhenUsingAlarm(this);
        } else if (e.getSource() == buttonPhone) {  // 通常通話ボタン
            operation.doWhenUsingPhone(this);
        } else if (e.getSource() == buttonExit) {   // 終了ボタン
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }

    @Override
    public void setClock(int hour) {
        String clockstring = "現在時刻は";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        operation.doWhenSettingClock(this, hour);
    }

    @Override
    public void changeOperation(HourOperation operation) {
        System.out.println(this.operation + "から" + operation + "へ状態が変化しました。");
        this.operation = operation;
    }

    @Override
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }

    @Override
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
