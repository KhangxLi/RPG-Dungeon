
public class Player {
	// Basic Player attributes
	private static int atk = 0; // Player's attack power
	private static int def = 0; // PLayer's defense
	private static int dex = 0; // Player's dexterity
	private static int hp = 10; // Player's current hitpoints
	private static int sta = 10; // Player's current stamina
	private static int maxSta; // Player's maximum stamina
	private static int maxHP; // Player's maximum hp
	private static String name; // Player's name

	// Currency attributes
	private static int moni= 0; // Player's money to exchange
	private static int xp = 10; // Player's experience points to exchange
	
	// Score attributes
	private static int nbOfKills; // Nb of total monster kills
	private static int deepestRoom; // Farthest room attained by player
	
	// Item attributes
	private static int nbHPPotion = 0; // Nb of HP potion owned
	private static int nbSTAPotion = 0; // Nb of Stamina Potion owned
	private static int nbCamouflage = 0; //Nb of Camouflage owned
	private static int nbMegaBooster = 0; // Nb of Mega Booster Owned
	private static int nbCheckPoint = 0; // Nb of CheckPoint owned
	
	
	// return String of items and how many the Player owns
	public static String getItems() {
		return("Items \nA-HP potion: " + getNbHPPotion() + "   B-STA potion: " + getNbSTAPotion() + "   C-Camouflage: " + getNbCamouflage() + "\nD-Mega Booster: " +
	getNbMegaBooster() + "   E-CheckPoint: " + getNbCheckPoint()) + "   Moni: " + getMoni();
	}
	
	// return Player's stats, scores and items
	public static String getString() {
		return (getName() + "'s Profile \n\nHP: " + getHP() + "/" + getMaxHP() + "   ATK: " + getATK() + "   DEF: " + getDEF() + "   DEX: " + getDEX() + "\nSTA: " + 
	getSta() + "/" + getMaxSta() + "   XP: " + getXP() + "   Monsters Defeated: " + getNbOfKills() + "   Deepest Room Attained: " + 
	getDeepestRoom() + "\n\n" + getItems());
	}
	
	//return player's combat stats
	public static String getBattleStats() {
		return (Player.getName() + "(" + getATK() + "ATK, " + getDEF() + "DEF, " + getDEX() + "DEX, " + getHP() + "/" + getMaxHP() + "HP)");
	}
	
	
	// getters and setters for best room attained and nb of monster kills
	public static int getDeepestRoom() {
		return(deepestRoom);
	}
	public static void setDeepestRoom(int x) {
		deepestRoom = x;
	}
	
	public static int getNbOfKills() {
		return (nbOfKills);
	}
	public static void setNbOfKills(int x) {
		nbOfKills = x;
	}
	
	
	// getters and setters for basic attributes
	public static String getName() {
		return(name);
	}
	public static void setName(String x) {
		name = x;
	}
	
	public static int getMaxSta() {
		return (10 + getNbOfKills()/2);
	}
	public static void setMaxSta(int x) {
		maxSta = x;
	}
	
	public static int getSta() {
		if (sta >= 0)
			return (sta);
		else
			return (0);
	}
	public static void setSta(int x) {
		sta = x;
	}
	
	public static int getMaxHP() {
		return (10 + (getDEF() + getDEX() + getMaxSta())/3);
	}
	public static void setMaxHP(int x) {
		maxHP = x;
	}
	
	public static int getHP() {
		if (hp >= 0)
			return(hp);
		else
			return (0);
	}
	public static void setHP(int x) {
		hp = x;
	}
	
	public static int getDEF() {
		return(def);
	}
	public static void setDEF(int x) {
		def = x;
	}

	public static int getATK() {
		return(atk);
	}
	public static void setATK(int x) {
		atk = x;
	}
	
	public static int getDEX() {
		return(dex);
	}
	public static void setDEX(int x) {
		dex = x;
	}
	
	
	// getters and setters for experience points and moni
	public static int getXP() {
		return(xp);
	}
	public static void setXP(int x) {
		xp = x;
	}
	
	public static int getMoni() {
		return(moni);
	}
	public static void setMoni(int x) {
		moni = x;
	}
	
	// getters and setters for the items owned
	public static int getNbHPPotion() {
		return (nbHPPotion);
	}
	public static void setNbHPPotion(int x) {
		nbHPPotion = x;
	}
	
	public static int getNbSTAPotion() {
		return (nbSTAPotion);
	}
	public static void setNbSTAPotion(int x) {
		nbSTAPotion = x;
	}
	
	public static int getNbCamouflage() {
		return (nbCamouflage);
	}
	public static void setNbCamouflage(int x) {
		nbCamouflage = x;
	}
	
	public static int getNbMegaBooster() {
		return (nbMegaBooster);
	}
	public static void setNbMegaBooster(int x) {
		nbMegaBooster = x;
	}
	
	public static int getNbCheckPoint() {
		return (nbCheckPoint);
	}
	public static void setNbCheckPoint(int x) {
		nbCheckPoint = x;
	}
}
