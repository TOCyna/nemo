import java.util.LinkedList;
import java.util.ListIterator;


public class Traversal {

	static final Ocean ocean = new Ocean(0);
	static final int pathColor = 200;
	static final int deadEndColor = 100;
	static boolean foundNemo = false;
	
	static void slow(){
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {}
	}
	

    ///////////// Metodos a serem completados ///////////// 
	
		
	static void q21() {
		
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

		int j = 0;
		while(j < 2 && !foundNemo) {
			fish = q.pop();
			
			//teste
			System.out.println("");
			System.out.print("Fish - ");
			print(fish);
			System.out.println("");
			System.out.println("");
			//System.out.println(fish.equals(new Cell(2,2)));
			
			neighbors = fish.neighbors();
			
			for(int i = 0; i < 4 && !foundNemo; i++) {
				Cell water = neighbors.get(i);
				
				System.out.print(i + ": isWater: " + !ocean.isWall(water));
				System.out.print(" - isntVisited: " + !contains(l, water));
				System.out.println(" - equal: " + (!ocean.isWall(water) && !contains(l, water)));
				
				if(ocean.isNemo(water)) {
					foundNemo = true;
					fish = water;
					print(fish);
				}
				else if((!ocean.isWall(water) && !contains(l, water))) {
					System.out.print("add to q - ");
					print(water);
					System.out.println();
					q.add(water);
					l.add(water);
				}
			}
			ListIterator<Cell> iterator = q.listIterator();
			System.out.print("q: ");
			while(iterator.hasNext()) {
				print(iterator.next());
				System.out.print(" - ");
			}
			System.out.println("");
			iterator = l.listIterator();
			System.out.print("l: ");
			while(iterator.hasNext()) {
				print(iterator.next());
				System.out.print(" - ");
			}
			System.out.println("");
			//j++; 
		}
		System.out.println("Nemo: " + ocean.nemo.toString());
		
	}

	static void q22() {
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
	    q21();
	}

}	