import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
public class MineFieldPanel extends JPanel{
	public RandomWalk minePath;
	//ArrayList used for creating the walk
	public ArrayList<Point> actualPath = new ArrayList<Point>();
	Random rand = new Random();
	//creates 2D array of spaces
	JButton[][] spaces;
	//keeps track of how many mines there are.
	int mines = 0;
	/**
	 * Constructor for the MineField.
	 * @param listener
	 * @param width
	 * @param height
	 */
	MineFieldPanel(ActionListener listener, int width, int height) {
		
		//creates a RandomWalk
		minePath = new RandomWalk(width);
		minePath.createWalk();
		//puts the randomWalks arrayList into actualPath so we can use the ArrayList methods.
		actualPath = minePath.getPath();
		//instantiates the spaces and sets the grid layout
		spaces = new JButton[width][height];
		setLayout(new GridLayout(width, height));
		/**
		 * creates the mine field. adds button to spaces, then spaces to field and sets the background to white.
		 * then, it adds each space to the spaces ArrayList so that we can use it to see the RandomWalk.
		 */
		for(int i = 0; i < spaces.length; i++) {
			for(int j = 0; j<spaces[i].length; j++) {
				spaces[i][j] = new MineFieldButton(listener);
				add(spaces[i][j]);
				spaces[i][j].setBackground(Color.white);
			}
		}
		
		
		//Uses the RandomWalk path to call spaces and make them blue.
		for (int i = 0; i < actualPath.size(); i++) {
			spaces[(int)actualPath.get(i).getX()][(int)actualPath.get(i).getY()].setBackground(Color.blue);
		}
		
		//only 25% of the remaining mines should be black. there are 15 spaces in the actualPath, so (64-15)/4 = mines. also = 13(rounded up.)
		//places mines outside actualPath.
		while (mines < 13) {
			for(int i = 0; i < spaces.length; i++) {
				for(int k = 0; k < spaces[i].length; k++) {
					if(spaces[i][k].getBackground() != Color.blue && spaces[i][k].getBackground() != Color.black) {
						int rand1 = rand.nextInt(13);
						if (rand1 == 1 && mines < 13) {
							spaces[i][k].setBackground(Color.black);
							mines++;
						}
					}
				}
			}
		}
	}
	
	public void showPath() {
		
	}
	
	public void showMines() {
		
	}
	void reset() {
	//clears mineWalker	
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}