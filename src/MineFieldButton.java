import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.Color;
public class MineFieldButton extends JButton{
	private Boolean isPath;
	private Boolean isMine;
	
	MineFieldButton(ActionListener listener){
		addActionListener(listener);
		setPreferredSize(new Dimension(50, 50));
		isMine = false;
		isPath = false;
		setBackground(Color.white);
	}
	
	public void makeMine() {
		isMine = true;
	}
	public void makePath() {
		isPath = true;
	}
	
	
	public void notMine() {
		isMine = false;
	}
	public void notPath() {
		isPath = false;
	}
	
	
	public Boolean isMine() {
		return isMine;
	}
	public Boolean isPath() {
		return isPath;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}