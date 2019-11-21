import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class RandomWalk implements RandomWalkInterface{
	private int size;
	private Random rand;
	private boolean isDone;
	private ArrayList<Point> path = new ArrayList<Point>();
	private Point start;
	private Point end;
	private Point current;
	
	
	public RandomWalk(int gridSize) {
		this.size = gridSize;
		this.rand = new Random();
		this.start = new Point(0, gridSize-1);
		this.end = new Point(gridSize-1, 0);
		path.add(start);
		current = path.get(path.size()-1);
	}
	
	public RandomWalk(int gridSize, long seed) {
		this.size = gridSize;
		this.rand = new Random(seed);
		this.start = new Point(0, gridSize-1);
		this.end = new Point(gridSize-1, 0);
		path.add(start);
		current = path.get(path.size()-1);
	}
	
	@Override
	public void step() {
		// TODO Auto-generated method stub
		int rand1 = rand.nextInt(2)+1;
		current = path.get(path.size()-1);
		if(!isDone()) {
			if(rand1 == 1 && current.x < end.x) {
				//gets the x value of the last point added to the array list, and subtracts from that (moves north one place)
				path.add(new Point(current.x+1, current.y));
			}
			else if(rand1 == 2 && current.y > end.y) {
				//gets the y value of the last point added to the array list, and adds to that (moves east)
				path.add(new Point(current.x, current.y-1));
			}
			else {
				isDone = true;
			}
		}
	}
	
	@Override
	public void createWalk() {
		// TODO Auto-generated method stub
		while(current.x != end.x || current.y != end.y) {
			step();
		}
	}
	
	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		if(current.x == end.x && current.y == end.y) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int getGridSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public Point getStartPoint() {
		// TODO Auto-generated method stub
		return start;
	}

	@Override
	public Point getEndPoint() {
		// TODO Auto-generated method stub
		return end;
	}

	@Override
	public Point getCurrentPoint() {
		// TODO Auto-generated method stub
		return current;
	}

	@Override
	public ArrayList<Point> getPath() {
		// TODO Auto-generated method stub
		return path;
	}
	public String toString() {
		String string;
		string = "";
		for( int i = 0; i<=path.size()-1; i++) {
			string = string + "[" + path.get(i).x + ", " + path.get(i).y + "] ";
		}
		return string;
	}

	@Override
	public void stepEC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createWalkEC() {
		// TODO Auto-generated method stub
		
	}
}