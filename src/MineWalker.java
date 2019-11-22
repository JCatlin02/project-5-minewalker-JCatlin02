import javax.swing.*;

/*
 * 
 * 
 * Creates and represents a MineWalker GUI.
 */
public class MineWalker {
	
	/*
	 * creates frame, sets it to exit on close, then adds a MineWalkerPanel and sets the frame to visible.
	 * @param args(unused)
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Mine Walker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		MineWalkerPanel minePanel = new MineWalkerPanel(10, 10);
		minePanel.setLayout(new BoxLayout(minePanel, BoxLayout.X_AXIS));
		frame.getContentPane().add(minePanel);
		frame.pack();
		frame.setVisible(true);
	}
}