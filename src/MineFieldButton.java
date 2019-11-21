import javax.swing.JButton;

import java.awt.Dimension;
import java.awt.event.ActionListener;
public class MineFieldButton extends JButton{

	MineFieldButton(ActionListener listener){
		addActionListener(listener);
		setPreferredSize(new Dimension(50, 50));
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}