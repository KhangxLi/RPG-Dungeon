
public class Player {
	private static int atk = 50;
	private static int def = 0;
	private static int dex = 50;
	private static int hp = 10;
	private static int nbOfKills;
	private static int deepestRoom;
	private static int maxSta;
	private static int maxHP;
	private static int sta = 10;
	private static int moni= 1000;
	private static int xp = 10;
	private static String name;
	
	private static int nbHPPotion;
	private static int nbSTAPotion;
	private static int nbCamouflage;
	private static int nbMegaBooster = 5;
	private static int nbCheckPoint = 5;
	
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
	
	public static String getItems() {
		return("Items \nA-HP potion: " + getNbHPPotion() + "   B-STA potion: " + getNbSTAPotion() + "   C-Camouflage: " + getNbCamouflage() + "\nD-Mega Booster: " +
	getNbMegaBooster() + "   E-CheckPoint: " + getNbCheckPoint()) + "   Moni: " + getMoni();
	}
	
	public static String getString() {
		return (getName() + "'s Profile \n\nHP: " + getHP() + "/" + getMaxHP() + "   ATK: " + getATK() + "   DEF: " + getDEF() + "   DEX: " + getDEX() + "\nSTA: " + 
	getSta() + "/" + getMaxSta() + "   XP: " + getXP() + "   Monsters Defeated: " + getNbOfKills() + "   Deepest Room Attained: " + 
	getDeepestRoom() + "\n\n" + getItems());
	}
	
	public static String getBattleStats() {
		return (Player.getName() + "(" + getATK() + "ATK, " + getDEF() + "DEF, " + getDEX() + "DEX, " + getHP() + "/" + getMaxHP() + "HP)");
	}
	
	public static int getDeepestRoom() {
		return(deepestRoom);
	}
	public static void setDeepestRoom(int x) {
		deepestRoom = x;
	}
	
	public static String getName() {
		return(name);
	}
	public static void setName(String x) {
		name = x;
	}
	
	public static int getNbOfKills() {
		return (nbOfKills);
	}
	public static void setNbOfKills(int x) {
		nbOfKills = x;
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
		return (10 + (getATK() + getDEF() + getDEX() + getMaxSta())/3);
	}
	public static void setMaxHP(int x) {
		maxHP = x;
	}
	
	public static int getXP() {
		return(xp);
	}
	public static void setXP(int x) {
		xp = x;
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
	
	public static int getHP() {
		if (hp >= 0)
			return(hp);
		else
			return (0);
	}
	public static void setHP(int x) {
		hp = x;
	}
	
	public static int getDEX() {
		return(dex);
	}
	public static void setDEX(int x) {
		dex = x;
	}
	
	public static int getMoni() {
		return(moni);
	}
	public static void setMoni(int x) {
		moni = x;
	}
}
