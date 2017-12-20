
public class Player {
	private static int atk = 0;
	private static int def = 0;
	private static int dex = 0;
	private static int hp = 10;
	private static int nbOfKills;
	private static int highestRoom;
	private static int availQuests;
	private static int CompQuests;
	private static int maxSta;
	private static int maxHP;
	private static int sta = 3;
	private static int moni;
	private static int xp = 10;
	private static String name;
	
	
	public static String getString() {
		return ("Your Stats \n\nHP: " + getHP() + "/" + getMaxHP() + "   ATK: " + getATK() + "   DEF: " + getDEF() + "   DEX: " + getDEX() + "\nSTA: " + getSta() + "/" +
	getMaxSta() + "   XP: " + getXP() + "   Moni: " + getMoni() + "   Monsters Defeated: " + getNbOfKills());
	}
	
	public static String getBattleStats() {
		return (Player.getName() + "(" + getATK() + "ATK, " + getDEF() + "DEF, " + getDEX() + "DEX, " + getHP() + "/" + getMaxHP() + "HP)");
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
		return (3 + getNbOfKills()/5);
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
