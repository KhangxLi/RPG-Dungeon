
public class Room {
	
	private int difficulty;
	private int nbOfMonsters = 0;
	
	public Room(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public int getNbOfMonsters() {
		return (nbOfMonsters);
	}
	public void setNbOfMonsters(int x) {
		nbOfMonsters = x;
	}
	
	public int getDifficulty() {
		return (difficulty);
	}
	
	public Monster[] generateMonsters() {
		int cumulevel = 0;
		int[] monsterIDs = new int[getDifficulty()];
		do {
			Monster monster = new Monster((int) (Math.random()*getDifficulty()));
			cumulevel += monster.getLevel();
			if (cumulevel > getDifficulty()) {
				cumulevel -= monster.getLevel();
			}
			else {
				monsterIDs[getNbOfMonsters()] = monster.getID();
				setNbOfMonsters(getNbOfMonsters() + 1);
			}
			
		} while(cumulevel != getDifficulty());
		
		Monster[] roomMonsters = new Monster[getNbOfMonsters()];
		for (int i = 0; i < getNbOfMonsters(); i++) {
			roomMonsters[i] = new Monster(monsterIDs[i]);
		}
		
		return (roomMonsters);
	}
	
	
}
