import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePlay {
	static Scanner key = new Scanner(System.in);
	static String choice;
	public static void main(String[] args) throws InterruptedException {
		
		System.out.print("What will your name be? ");
		String name = key.nextLine();
		Player player = new Player(name);
		
		/*System.out.println("\nWelcome to Dungeon HighScore, " + name + ".");
		System.out.print("See instructions? (yes/no) ");
		choice = key.nextLine();
		if (choice.equalsIgnoreCase("yes"))
			instruction();*/
		
		menu();
		do {
			choice = key.nextLine();
			switch (choice.toUpperCase()) {
				case "M":
					menu();
					break;
				case "P": 
					System.out.print(player + "\n\nM-Menu\n\n>>>"); 
					break;
				case "H":
					loading("Getting comfortable", 1, 500);
					System.out.print("Home Sweeet Home.\n");
					home();
					break;
				case "G":
					loading("Getting fired up", 1, 500);
					System.out.print("Welcome to the gym! What kind of training do you want?\n");
					gym();
					break;
				default: 
					System.out.print("Sorry, that is not a valid option.\n\n>>>");
					break;
			}
		} while (player.getHP() > 0);
		
		key.close();
	}
	
	public static void menu() {
		System.out.print("\nWhat would you like to do? \nD-Dungeon   G-Gym   L-Learn Skills   S-Store   \nH-Home   P-" + Player.getName() + 
				"'s Stats   I-Instructions   O-Options \n\n>>> ");
	}
	
	public static void instruction() {
		System.out.print("instructions...");
	}
	
	public static void home() throws InterruptedException {
		System.out.print("\nR-Rest   E-Eat   I-Inventory   M-Menu \n\n>>>");
		choice = key.nextLine();
		switch (choice.toUpperCase()) {
			case "M":
				loading("Getting ready", 1, 500);
				menu();
				break;
			case "E":
				loading("Eating", 1, 1000);
				Player.setHP(Player.getMaxHP());
				home();
				break;
			case "R":
				loading("Resting", 3, 1000);
				Player.setSta(Player.getMaxSta());
				home();
			default:
				System.out.print("Sorry, that is not a valid option.\n\n>>>");
		}
	}
	
	public static void gym() throws InterruptedException {
		int atkCost = Player.getATK() + 5;
		int defCost = Player.getDEF() + 5;
		int dexCost = Player.getDEX() + 5;
		
		System.out.print("\nXP: " + Player.getXP() + 
				"\nATK: " + Player.getATK() + "   A-Attack(" + atkCost + "XP) \nDEF: " + Player.getDEF() + "   B-Defense(" + defCost + "XP) \nDEX: " +
				Player.getDEX() + "   C-Dexterity(" + dexCost + "XP) \n\nM-Menu \n\n>>>");
		
		choice = key.nextLine();
		switch (choice.toUpperCase()) {
			case "A":
				Player.setATK(Player.getATK() + training(atkCost, "ATK"));
				gym();
				break;
			case "B":
				Player.setDEF(Player.getDEF() + training(defCost, "DEF"));
				gym();
				break;
			case "C":
				Player.setDEX(Player.getDEX() + training(dexCost, "DEX"));
				gym();
				break;
			case "M":
				loading("Thank you for training with us!", 1, 500);
				menu();
				break;
			default:
				System.out.print("Sorry, that is not a valid option.\n\n>>>");
				break;
		}
	}
	
	public static void learn() {
		
	}
	
	public static void loading(String text, int repeat, int time) throws InterruptedException {
		for (int i = 0; i < repeat; i++) {
			System.out.print(text + "...   ");
			Thread.sleep(time);
		}
		System.out.println("");
	}
	
	public static int training(int cost, String stat) throws InterruptedException {
		int qty;
		try {
			System.out.print("How many more " + stat + " do you want? ");
			qty = Integer.parseInt(key.nextLine());
			
			if (qty < 0)
				do {
					System.out.print("Please enter a positive integer: ");
					qty = Integer.parseInt(key.nextLine());
				} while (qty < 0);
			
			if (qty == 0)
				return (0);
			else {
				if (qty * cost > Player.getXP()) {
					System.out.print("Sorry, you don't have enough XP for that.\n");
					return (0);
				}
				else {
					System.out.print("Exchange " + (qty * cost) + "XP for " + qty + stat + " (yes/no)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("yes")) {
						Player.setXP(Player.getXP() - (qty * cost));
						loading(stat + " training", 3, 400);
						Player.setSta(Player.getMaxSta() - 1);
						return (qty);
					}
					else
						return(0);
				}
			}
		}
		catch (NumberFormatException e) {
			System.out.print("That's not a positive integer.\n");
			return (0);
		}
	}

}
