package mediator.main;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends Frame implements ActionListener, Mediator {

	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOK;
	private ColleagueButton buttonCancel;

	public LoginFrame(String title) {
		super(title);
		this.setBackground(Color.lightGray);
		this.setLayout(new GridLayout(4, 2));
		this.createColleagues();
		this.add(checkGuest);
		this.add(checkLogin);
		this.add(new Label("Username: "));
		this.add(textUser);
		this.add(new Label("Password: "));
		this.add(textPass);
		this.add(buttonOK);
		this.add(buttonCancel);
		colleagueChanged();
		pack();
		setVisible(true);
	}

	@Override
	public void createColleagues() {

		CheckboxGroup group = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", group, true);
		checkLogin = new ColleagueCheckbox("Login", group, false);
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		buttonOK = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");

		checkGuest.setMediator(this); // set This To checkGuest As Mediator
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOK.setMediator(this);
		buttonCancel.setMediator(this);

		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOK.addActionListener(this);
		buttonCancel.addActionListener(this);

	}

	/**
	 * 状態の組み合わせを集中管理することで変更箇所をここだけに絞ることが出来る
	 */
	@Override
	public void colleagueChanged() {

		if (isChecked(checkGuest) == true) {
			setEnableTo(textUser, false);
			setEnableTo(textPass, false);
			setEnableTo(buttonOK, true);
			return;}

		if (isChecked(checkLogin) == true) {
			setEnableTo(textUser, true);
			setEnableTo(textPass, true);

			if (isBlank(textUser) == true)
				setEnableTo(textPass, false);

			if (isBlank(textUser) == true
			 || isBlank(textPass) == true) {
					setEnableTo(buttonOK, false);
					return;}

			if (isBlank(textUser) == false
			 && isBlank(textPass) == false) {
					setEnableTo(buttonOK, true);
					return;}}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.toString());
		System.exit(0);

	}

	// 以下読み替えヘルパ

	private boolean isBlank(ColleagueTextField text) {
		return text.getText().trim().length() == 0;
	}

	private void setEnableTo(Colleague col, boolean b) {
		col.setColleagueEnabled(b);
	}

	private boolean isChecked(ColleagueCheckbox checkbox) {
		return checkbox.getState();
	}

}
