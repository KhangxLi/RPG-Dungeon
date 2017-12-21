
public class Room {
	
	private int difficulty; // room's difficulty level
	private int nbOfMonsters = 0; // nb of monsters in that room
	
	// constructor taking difficulty as argument
	public Room(int difficulty) {
		this.difficulty = difficulty;
	}
	
	
	// getters and setters
	public int getNbOfMonsters() {
		return (nbOfMonsters);
	}
	public void setNbOfMonsters(int x) {
		nbOfMonsters = x;
	}
	
	public int getDifficulty() {
		return (difficulty);
	}
	
	// method that generates monsters based on the room difficulty. Each room has variable nb of monsters, but the cumulative level of all monsters is equal to room difficulty
	public Monster[] generateMonsters() {
		int cumulevel = 0;
		int[] monsterIDs = new int[getDifficulty()]; // there can't be more monsters than the difficulty level of the room
		
		// keep creating new monsters until cumulative monster levels match difficulty
		do {
			Monster monster = new Monster((int) (Math.random()*getDifficulty())); // create random monster with id not surpassing room difficulty
			cumulevel += monster.getLevel();
			if (cumulevel > getDifficulty()) {
				cumulevel -= monster.getLevel();
			}
			// if cumulative level has not passed its limit, add that monster's id to the array
			else {
				monsterIDs[getNbOfMonsters()] = monster.getID();
				setNbOfMonsters(getNbOfMonsters() + 1); // count the number of monsters in the room
			}
			
		} while(cumulevel != getDifficulty());
		
		Monster[] roomMonsters = new Monster[getNbOfMonsters()]; // create array of Monster
		
		// create a new monster with the previously obtained IDs
		for (int i = 0; i < getNbOfMonsters(); i++) {
			roomMonsters[i] = new Monster(monsterIDs[i]);
		}
		
		// return the array of Monsters for that room
		return (roomMonsters);
	}
	
	
}
