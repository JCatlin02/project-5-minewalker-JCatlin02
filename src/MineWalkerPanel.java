import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;

public class MineWalkerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton reset;
	private JButton showMines;
	private JButton showPath;
	private MineFieldPanel panel;
	
	MineWalkerPanel(int width, int height){
		//sets the MineWalkerPanel to a MineFieldPanel with the button listener and dimensions as parameters
		panel = new MineFieldPanel(new MineButtonListener(), width, height);
		//adds a reset button (that will appear outside the MineFieldPanel) and adds an actionListener for it
		reset = new JButton("reset");
		reset.addActionListener(new ResetButtonListener());
		showMines = new JButton("Show Mines");
		showMines.addActionListener(new ShowMinesListener());
		showPath = new JButton("Show Path");
		showPath.addActionListener(new ShowPathListener());
		//adds panel and reset button to MineWalkerPanel.
		add(panel);
		add(reset);
		add(showMines);
		add(showPath);
	}
	
	
	private class ResetButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			panel.reset();
		}
	}
	
	private class MineButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			//HERE call the method that changes the color of the space to match how many mines are around.
		}
	}
	
	private class ShowMinesListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{
			//HERE call the method that changes the color of the mines to black.
		}
	}
	
	private class ShowPathListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{
			//HERE call the method that changes the color of the path to blue.
		}
	}
}



