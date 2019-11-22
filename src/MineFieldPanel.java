import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
@SuppressWarnings("serial")
public class MineFieldPanel extends JPanel{
	public RandomWalk minePath;
	//ArrayList used for creating the walk
	public ArrayList<Point> actualPath = new ArrayList<Point>();
	Random rand = new Random();
	//creates 2D array of spaces
	JButton[][] spaces;
	//keeps track of how many mines there are.
	int mines = 0;
	//width
	int width;
	/**
	 * Constructor for the MineField.
	 * @param listener
	 * @param width
	 * @param height
	 */
	MineFieldPanel(ActionListener listener, int width, int height) {
		this.width = width;
		
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
			for(int j = 0; j< spaces[i].length; j++) {
				spaces[i][j] = new MineFieldButton(listener);
				add(spaces[i][j]);
			}
		}
		
		// makes the entire path (does not show them)
		for (int i = 0; i < actualPath.size(); i++) {
			((MineFieldButton) spaces[(int)actualPath.get(i).getX()][(int)actualPath.get(i).getY()]).makePath();
		}
		
		//only 25% of the remaining mines should be black. there are 15 spaces in the actualPath, so (64-15)/4 = mines. also = 13(rounded up.)
		//places mines outside actualPath, does not show them.
		while (mines < 13) {
			for(int i = 0; i < spaces.length; i++) {
				for(int k = 0; k < spaces[i].length; k++) {
					if(!((MineFieldButton) spaces[i][k]).isPath() && !((MineFieldButton) spaces[i][k]).isMine()) {
						int rand1 = rand.nextInt(13);
						if (rand1 == 1 && mines < 13) {
							((MineFieldButton) spaces[i][k]).makeMine();
							mines++;
						}
					}
				}
			}
		}
	}
	/*
	 * colors all the mines blue
	 */
	public void showPath() {
		for (int i = 0; i < actualPath.size(); i++) {
			spaces[(int)actualPath.get(i).getX()][(int)actualPath.get(i).getY()].setBackground(Color.blue);
		}
	}
	/*
	 * colors all the mines black
	 */
	public void showMines() {
		for(int i = 0; i < spaces.length; i++) {
			for(int k = 0; k < spaces[i].length; k++) {
				if(((MineFieldButton) spaces[i][k]).isMine()) {
				
						spaces[i][k].setBackground(Color.black);
				}
			}
		}
	}
	
	void reset() {
		/*
		 * actual resetting
		 */
		mines = 0;
		for(int i = 0; i < spaces.length; i++) {
			for(int k = 0; k < spaces[i].length; k++) {
				((MineFieldButton)spaces[i][k]).setBackground(Color.white);
				((MineFieldButton)spaces[i][k]).notMine();
				((MineFieldButton)spaces[i][k]).notPath();
			}
		}
		/*
		 * makes new randomWalk
		 */
		minePath = new RandomWalk(width);
		minePath.createWalk();
		//puts the randomWalks arrayList into actualPath so we can use the ArrayList methods.
		actualPath = minePath.getPath();
		/*
		 * makes new path
		 */
		for (int i = 0; i < actualPath.size(); i++) {
			((MineFieldButton)spaces[(int)actualPath.get(i).getX()][(int)actualPath.get(i).getY()]).makePath();
		}
		/*
		 * makes new mines
		 */
		while (mines < 13) {
			for(int i = 0; i < spaces.length; i++) {
				for(int k = 0; k < spaces[i].length; k++) {
					if(!((MineFieldButton) spaces[i][k]).isPath() && !((MineFieldButton) spaces[i][k]).isMine()) {
						int rand1 = rand.nextInt(13);
						if (rand1 == 1 && mines < 13) {
							((MineFieldButton) spaces[i][k]).makeMine();
							mines++;
						}
					}
				}
			}
		}
	}
}