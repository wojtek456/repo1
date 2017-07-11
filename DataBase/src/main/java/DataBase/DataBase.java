package DataBase;
import javax.swing.JFrame;
import javax.swing.JMenuBar;

public final class DataBase {
	/**
	 * @wbp.factory
	 * @wbp.factory.parameter.source JMenuBar menuBar
	 */
	public static JFrame createJFrame(JMenuBar JMenuBar) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(JMenuBar);
		return frame;
	}
}