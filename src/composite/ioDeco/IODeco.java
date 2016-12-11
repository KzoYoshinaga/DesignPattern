package composite.ioDeco;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.net.Socket;

/**
 * Java.ioパッケージでデコレーションパターンが使われている
 * @author ict816
 *
 */
public class IODeco {
	@SuppressWarnings({ "unused", "resource" })
	public static void main(String[] args) throws IOException {

		/**
		 * Class Reader
		 *
		 * java.lang.Object
		 *     java.io.Reader
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable, Readable
		 *
		 * Direct Known Subclasses:
		 *     BufferedReader, CharArrayReader, FilterReader, InputStreamReader, PipedReader, StringReader
		 *
		 * Constractor:
		 *     protected  Reader()
		 *         Creates a new character-stream reader whose critical sections will synchronize on the reader itself.
		 *     protected  Reader(Object lock)
		 *         Creates a new character-stream reader whose critical sections will synchronize on the given object.
		 */

		/**
		 * Class FileReader
		 * java.lang.Object
		 *    java.io.Reader
		 *        java.io.InputStreamReader
		 *            java.io.FileReader
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable, Readable
		 *
		 * Constractor:
		 *     FileReader(File file)
		 *         Creates a new FileReader, given the File to read from.
		 *     FileReader(FileDescriptor fd)
		 *         Creates a new FileReader, given the FileDescriptor to read from.
		 *     FileReader(String fileName)
		 *         Creates a new FileReader, given the name of the file to read from.
		 *
		 * 全てのコンストラクタで FileInputStream を生成し
		 * スーパクラスである InputStreamReader のコンストラクタに渡している
		 */

		/**
		 * Class FileInputStream
		 *     java.lang.Object
		 *         java.io.InputStream
		 *             java.io.FileInputStream
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable
		 *
		 * Constractor:
		 *     FileInputStream(File file)
		 *         Creates a FileInputStream by opening a connection to an actual file, the file named by the File object file in the file system.
		 *     FileInputStream(FileDescriptor fdObj)
		 *         Creates a FileInputStream by using the file descriptor fdObj, which represents an existing connection to an actual file in the file system.
		 *     FileInputStream(String name)
		 *         Creates a FileInputStream by opening a connection to an actual file, the file named by the path name name in the file system.
		 */

		// ファイルからデータを読み込むインスタンス
		Reader fileReader = new FileReader("Foo.txt");

		/**
		 * Class InputStreamReader
		 *
		 * java.lang.Object
		 *     java.io.Reader
		 *         java.io.InputStreamReader
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable, ReadableDirect
		 *
		 * Known Subclasses:
		 *     FileReader
		 *
		 * Constractor:
		 *     InputStreamReader(InputStream in)
		 *         Creates an InputStreamReader that uses the default charset.
		 *     InputStreamReader(InputStream in, Charset cs)
		 *         Creates an InputStreamReader that uses the given charset.
		 *     InputStreamReader(InputStream in, CharsetDecoder dec)
		 *         Creates an InputStreamReader that uses the given charset decoder.
		 *     InputStreamReader(InputStream in, String charsetName)
		 *         Creates an InputStreamReader that uses the named charset.
		 */

		/**
		 * Class InputStream
		 * java.lang.Object
		 *     java.io.InputStream
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseableDirect
		 *
		 * Known Subclasses:
		 *     AudioInputStream, ByteArrayInputStream, FileInputStream, FilterInputStream, InputStream, ObjectInputStream, PipedInputStream, SequenceInputStream, StringBufferInputStream
		 *
		 * Constractor:
		 *     InputStream()
		 *
		 * This abstract class is the superclass of all classes representing
		 * an input stream of bytes.
		 *
		 * Applications that need to define a subclass of InputStream
		 * must always provide a method that returns the next byte of input.
		 */

		// 等価なインスタンス生成
		Reader fileReader2 = new InputStreamReader(new FileInputStream("Foo.txt"));

		/**
		 * Class BufferedReader
		 *
		 * java.lang.Object
		 *     java.io.Reader
		 *         java.io.BufferedReader
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable, Readable
		 *
		 * Direct Known Subclasses:
		 *     LineNumberReader
		 *
		 * Constractor:
		 *     BufferedReader(Reader in)
		 *         Creates a buffering character-input stream that uses a default-sized input buffer.
		 *     BufferedReader(Reader in, int sz)
		 *         Creates a buffering character-input stream that uses an input buffer of the specified size.
		 */

		// ファイルからデータを読み込む際にバッファリングするインスタンス
		Reader bufferedReader = new BufferedReader(new FileReader("Foo.txt"));

		/**
		 * Class LineNumberReader
		 *
		 * java.lang.Object
		 *     java.io.Reader
		 *         java.io.BufferedReader
		 *             java.io.LineNumberReader
		 *
		 * All Implemented Interfaces:
		 *     Closeable, AutoCloseable, Readable
		 *
		 * Constractor:
		 *     LineNumberReader(Reader in)
		 *         Create a new line-numbering reader, using the default input-buffer size.
		 *     LineNumberReader(Reader in, int sz)
		 *         Create a new line-numbering reader, reading characters into a buffer of the given size.
		 */

		// ファイルからデータを読み込む際にバッファリングし行番号を管理するインスタンス、無駄なバッファリング
		Reader lineNumberBufferedReader = new LineNumberReader(new BufferedReader(new FileReader("Foo.txt")));

		// LineNumberReader は BufferedReader のサブクラス・・・
		Reader lineNumberReader = new LineNumberReader(new FileReader("Foo.txt"));

		// ソケット通信によりネットワークから読み込む
		Reader networkLineNumberReader = new LineNumberReader(new InputStreamReader(new Socket().getInputStream()));

	}


}
