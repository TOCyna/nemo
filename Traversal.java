import java.util.LinkedList;
import java.util.ListIterator;


public class Traversal {

	static final Ocean ocean = new Ocean(0);
	static final int pathColor = 200;
	static final int deadEndColor = 100;
	
	static Cell fish;
	
	
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
			slow();
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
			slow();
			
			for(int i = 0; i < 4 && !foundNemo; i++) {
				Cell water = neighbors.get(i);
				
				if(ocean.isNemo(water)) {
					foundNemo = true;
					ocean.setMark(water, ocean.getMark(fish) + 1);
					fish = water;
					System.out.println("Nemo is at: " + fish.toString());
					System.out.println("It took us: " + ocean.getMark(fish) + " steps");
				}
				else if((!ocean.isWall(water) && !contains(l, water))) {
					q.add(water);
					l.add(water);
					ocean.setMark(water, ocean.getMark(fish) + 1);
				}
			}
		}
	}

	// convenções de marca: 1 (WEST), 2(SOUTH), 3(EAST), 4(NORTH)
	static final int WEST = 1, SOUTH = 2, EAST = 3, NORTH = 4;
	
	
	static void q23() {
		boolean foundNemo = false;

		//list of all elements that we have cross
		LinkedList<Cell> l = new LinkedList<Cell>();
		
		//list of elements to process
		LinkedList<Cell> q = new LinkedList<Cell>();
		
		//fish that walks around
		fish = new Cell(-1, -1);
		
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
			slow();
			
			for(int i = 1; i < 5 && !foundNemo; i++) {
				Cell water = neighbors.get(i - 1);
				
				if(ocean.isNemo(water)) {
					foundNemo = true;
					ocean.setMark(water, i);
					fish = water;
				}
				else if((!ocean.isWall(water) && !contains(l, water))) {
					q.add(water);
					l.add(water);
					ocean.setMark(water, i);
				}
			}
		}	
	}


	static void backTrack() {
		q23();
		int mark = 0;
		while(!ocean.isMarlin(fish))
		{
			slow();
			mark = ocean.getMark(fish);
			switch(mark) {
				case WEST:
					ocean.setMark(fish, 200);
					fish = fish.east();
					break;
				case EAST:
					ocean.setMark(fish, 200);
					fish = fish.west();
					break;
				case NORTH:
					ocean.setMark(fish, 200);
					fish = fish.south();
					break;
				case SOUTH:
					ocean.setMark(fish, 200);
					fish = fish.north();
					break;
			}
		}
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
	    backTrack();
	}

}	