import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class MineWalkerPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MineFieldPanel panel;
	private UserButtonPanel panel2;
	
	MineWalkerPanel(int width, int height){
		//sets the MineWalkerPanel to a MineFieldPanel with the button listener and dimensions as parameters
		panel = new MineFieldPanel(new MineButtonListener(), width, height);
		panel2 = new UserButtonPanel(new ResetButtonListener(), new ShowPathListener(), new ShowMinesListener());
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		add(panel);
		add(panel2);
	}
	
	
	private class ResetButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			panel.reset();
			System.out.println("reset button pressed!");
		}
	}
	
	private class MineButtonListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e)
		{
			//HERE call the method that changes the color of the space to match how many mines are around.
			System.out.println("mine button pressed!");
		}
	}
	
	private class ShowMinesListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{
			panel.showMines();
			//HERE call the method that changes the color of the mines to black.
			System.out.println("showMines button pressed!");
		}
	}
	
	private class ShowPathListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e) 
		{
			panel.showPath();
			//HERE call the method that changes the color of the path to blue.
			System.out.println("showPath button pressed!");
		}
	}
}



