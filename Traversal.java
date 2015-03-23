import java.util.LinkedList;
import java.util.ListIterator;


public class Traversal {

	static final Ocean ocean = new Ocean(0);
	static final int pathColor = 200;
	static final int deadEndColor = 100;
	
	static void slow(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
	}
	

    ///////////// Metodos a serem completados ///////////// 
	
		
	static void q21() {
		
		boolean foundNemo = false;

		//list of all elements that we have cross
		LinkedList<Cell> l = new LinkedList<Cell>();
		
		//list of elements to process
		LinkedList<Cell> q = new LinkedList<Cell>();
		
		//fish that walks around
		Cell fish = new Cell(-1, -1);
		
		//cell to process
		LinkedList<Cell> neighbors = new LinkedList<Cell>();
		
		//initial position
		Cell s = new Cell(ocean.marlin.x, ocean.marlin.y);
		
		//add first element
		l.add(s);
		q.add(s);
		
		//west,south,east,north

		while(!foundNemo) {
			fish = q.pop();
			
			neighbors = fish.neighbors();
			
			for(int i = 0; i < 4 && !foundNemo; i++) {
				Cell water = neighbors.get(i);
				
				if(ocean.isNemo(water)) {
					foundNemo = true;
					fish = water;
					System.out.println("Nemo is at: " + fish.toString());
				}
				else if((!ocean.isWall(water) && !contains(l, water))) {
					q.add(water);
					l.add(water);
				}
			}
		}		
	}

	static void q22() {
		
		boolean foundNemo = false;

		//list of all elements that we have cross
		LinkedList<Cell> l = new LinkedList<Cell>();
		
		//list of elements to process
		LinkedList<Cell> q = new LinkedList<Cell>();
		
		//fish that walks around
		Cell fish = new Cell(-1, -1);
		
		//cell to process
		LinkedList<Cell> neighbors = new LinkedList<Cell>();
		
		//initial position
		Cell s = new Cell(ocean.marlin.x, ocean.marlin.y);
		
		//add first element
		l.add(s);
		q.add(s);
		
		//west,south,east,north

		while(!foundNemo) {
			fish = q.pop();
			
			neighbors = fish.neighbors();
			
			for(int i = 0; i < 4 && !foundNemo; i++) {
				Cell water = neighbors.get(i);
				
				if(ocean.isNemo(water)) {
					foundNemo = true;
					fish = water;
					System.out.println("Nemo is at: " + fish.toString());
				}
				else if((!ocean.isWall(water) && !contains(l, water))) {
					q.add(water);
					l.add(water);
				}
			}
		}
	}

	// convenções de marca: 1 (WEST), 2(SOUTH), 3(EAST), 4(NORTH)
	static final int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;
	
	
	static void q23() {
	}


	static void backTrack() {
	}
	
	static void print(Cell c) {
		System.out.print("(" + c.x + "," + c.y + ")");
	}
	
	static boolean contains(LinkedList<Cell> l, Cell c) {
		boolean b = false;
		ListIterator<Cell> iterator = l.listIterator();
		while(iterator.hasNext() && !b) {
			if(iterator.next().equals(c))
				b = true;
		}
		return b;
	}
	public static void main(String[] args) {
	    q22();
	}

}	