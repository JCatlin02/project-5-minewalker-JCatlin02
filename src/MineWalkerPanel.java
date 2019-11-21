import javax.swing.JPanel;
import javax.swing.JButton;
public class MineWalkerPanel extends JPanel{
	private JButton reset;
	private MineFieldPanel panel;
	
	MineWalkerPanel(){
		panel = new MineFieldPanel();
		reset = new JButton("reset");
		add(panel);
		add(reset);
	}
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}