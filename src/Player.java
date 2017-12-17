
public class Player {
	private static int atk;
	private static int def;
	private static int maxHP = 10;
	private static int hp = 10;
	private static int maxSta = 3;
	private static int sta = 3;
	private static int dex;
	private static int moni;
	private static int xp = 10;
	private static String name;

	public Player(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ("Your Stats \n\nHP: " + getHP() + "/" + getMaxHP() + "   ATK: " + getATK() + "   DEF: " + getDEF() + "   DEX: " + getDEX() + "\nXP: " + getXP() + 
				"   Moni: " + getMoni());
	}
	
	public static String getName() {
		return(name);
	}
	public static void setName(String x) {
		name = x;
	}
	
	public static int getMaxSta() {
		return (maxSta);
	}
	public static void setMaxSta(int x) {
		maxSta = x;
	}
	
	public static int getSta() {
		return (sta);
	}
	public static void setSta(int x) {
		sta = x;
	}
	
	public static int getMaxHP() {
		return (maxHP);
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
		return(hp);
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
