import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
public class MineFieldPanel extends JPanel{

	MineFieldPanel(ActionListener listener, int width, int height) {
		JButton[][] spaces;
		spaces = new JButton[width][height];
		setLayout(new GridLayout(width, height));
		for(int i = 0; i < spaces.length; i++) {
			for(int j = 0; j<spaces[i].length; j++) {
			spaces[i][j] = new MineFieldButton(listener);
			add(spaces[i][j]);
			}
		}
	}
	
	
	
	void reset() {
	//clears mineWalker	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}