import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.*;

@SuppressWarnings("serial")
public class UserButtonPanel extends JPanel {
	JButton reset;
	JButton showMines;
	JButton showPath;
	
	UserButtonPanel(ActionListener listener1, ActionListener listener2, ActionListener listener3){
		//adds a reset button (that will appear outside the MineFieldPanel) and adds an actionListener for it
			reset = new JButton("reset");
			reset.addActionListener(listener1);
			reset.setAlignmentX(Component.CENTER_ALIGNMENT);
			//adds showMines button, aligns it, and adds listener for it.
			showMines = new JButton("Show Mines");
			showMines.addActionListener(listener3);
			showMines.setAlignmentX(Component.CENTER_ALIGNMENT);
			//adds showPath button, aligns it, and adds listener for it.
			showPath = new JButton("Show Path");
			showPath.addActionListener(listener2);
			showPath.setAlignmentX(Component.CENTER_ALIGNMENT);
			//adds panel and reset button to MineWalkerPanel.
			add(reset);
			add(showMines);
			add(showPath);
	}
}
