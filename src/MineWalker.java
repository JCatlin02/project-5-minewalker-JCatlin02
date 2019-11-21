import javax.swing.JFrame;

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
		frame.getContentPane().add(new MineWalkerPanel(8, 8));
		frame.pack();
		frame.setVisible(true);
	}
}