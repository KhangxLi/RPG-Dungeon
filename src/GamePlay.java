import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePlay {
	static Scanner key = new Scanner(System.in);
	static String choice;
	static boolean gameOver = false;
	static boolean inDungeon = false;
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.print("What will your name be? ");
		Player.setName(key.nextLine());
		
		/*System.out.println("\nWelcome to Dungeon HighScore, " + name + ".");
		System.out.print("See instructions? (y/n) ");
		choice = key.nextLine();
		if (choice.equalsIgnoreCase("y"))
			instruction();*/
		
		menu();
		
		do {
			choice = key.nextLine();
			switch (choice.toUpperCase()) {
				case "M":
					menu();
					break;
				case "P": 
					System.out.print(Player.getString() + "\n\nM-Menu\n\n>>>"); 
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
				case "D":
					loading("Entering dungeon", 1, 500);
					System.out.println("We are not responsible for your death, " + Player.getName() + ".");
					dungeon();
					break;
				default: 
					System.out.print("Sorry, that is not a valid option.\n\n>>>");
					break;
			}
		} while (!gameOver);
		
		key.close();
	}
	
	public static void menu() {
		System.out.print("\nWhat would you like to do? \nD-Dungeon   G-Gym   L-Learn Skills   S-Store   \nH-Home   P-" + Player.getName() + 
				"'s Stats   I-Instructions   O-Options \n\n>>> ");
	}
	
	public static void instruction() {
		System.out.print("instructions...");
	}
	
	public static void dungeon() throws InterruptedException {
		inDungeon = true;
		int i = 0;
		System.out.print("\nEnter the first room (y/n)? ");
		choice = key.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			while (inDungeon) {
				enterRoom(++i);
			}
		}
		else
			menu();
	}
	
	public static void enterRoom(int difficulty) throws InterruptedException {
		Room room = new Room(difficulty);
		
		Monster[] monsterList = room.generateMonsters();
		
		System.out.println("\nYou have entered room " + difficulty + ".");
		System.out.print("There " + (room.getNbOfMonsters() > 1 ? "are " + room.getNbOfMonsters() +  " monsters" : "is " + 
						  room.getNbOfMonsters() + " monster") + " in the room. There's no turning back.\n\n");
		
		for (int i = 0; i < room.getNbOfMonsters(); i++) {
			System.out.println(monsterList[i]);
		}

		System.out.print("Press enter to continue.");
		choice = key.nextLine();
		battle(room.getNbOfMonsters(), monsterList);
	}
	
	public static void battle(int nbMonster, Monster[] monster) throws InterruptedException {
		boolean playerLast = false;
		int comboP = 1;
		int comboM = 1;

		for (int i = 0; i < nbMonster; i++) {
			System.out.println("\nBatte " + (i+1) + ": " + Player.getBattleStats() + " vs " + monster[i]);
			
			System.out.print("\nWhat's your next move? \"Enter\"-Fight \n>>>");
			choice = key.nextLine();
			
		//	if (choice.equalsIgnoreCase("C")) {
				
				if(Math.random()*Player.getDEX() >= Math.random()*monster[i].getDEX()) {
					System.out.println("\n" + Player.getName() + " has the initiative!");
					monster[i].setHP(monster[i].getHP() - Player.getATK());
					System.out.println(Player.getName() + " deals " + Player.getATK() + " dmg - " + monster[i].getType() + " has " + monster[i].getHP() + "HP left!");
					playerLast = true;
				}
				else {
					System.out.println("\n" + monster[i].getType() + " has the initiative!");
					Player.setHP(Player.getHP() - (monster[i].getATK() - Player.getDEF() > 0 ? monster[i].getATK() - Player.getDEF() : 0));
					System.out.println(monster[i].getType() + " deals " + (monster[i].getATK() - Player.getDEF() > 0 ? monster[i].getATK() - Player.getDEF() : 0) + 
							" dmg - " + Player.getName() + " has " + Player.getHP() + "HP left!");
				}
				
				do {
					if (monster[i].getHP() <= 0)
						break;
					System.out.print("Press enter to continue.");
					choice = key.nextLine();
					
					if (playerLast) {
						if(Math.random()*Player.getDEX() - comboP >= Math.random()*monster[i].getDEX()) {
							comboP += 0.5;
							System.out.println("\n" + Player.getName() + " is on fire! Combo attack!");
							monster[i].setHP(monster[i].getHP() - Player.getATK());
							System.out.println(Player.getName() + " deals " + Player.getATK() + " dmg - " + monster[i].getType() + " has " + monster[i].getHP() + "HP left!");
						}
						else {
							if(Math.random()*Player.getDEX() - 1 >= Math.random()*monster[i].getDEX()) {
								System.out.println("\n" + monster[i].getType() + " attacks! "+ Player.getName() + " dodges! " + monster[i].getType() + " deals 0 dmg");
								comboP += 0.5;
							}
							else {
								Player.setHP(Player.getHP() - (monster[i].getATK() - Player.getDEF() > 0 ? monster[i].getATK() - Player.getDEF() : 0));
								System.out.println("\n" + monster[i].getType() + " attacks! " + Player.getName() + " receives " + 
								(monster[i].getATK() - Player.getDEF() > 0 ? monster[i].getATK() - Player.getDEF() : 0) + " dmg. \n" + Player.getName() + 
								" has " + Player.getHP() + "HP left!");
								comboP = 1;
							}
							playerLast = false;
						}
					}
					else {
						if(Math.random()*Player.getDEX() < Math.random()*monster[i].getDEX() - comboM) {
							comboM += 0.5;
							System.out.println("\n" + monster[i].getType() + " is on fire! Combo attack!");
							Player.setHP(Player.getHP() - monster[i].getATK());
							System.out.println(monster[i].getType() + " deals " + monster[i].getATK() + " dmg - " + Player.getName() + " has " + Player.getHP() + "HP left!");
						}
						else {
							if(Math.random()*Player.getDEX() < Math.random()*monster[i].getDEX() - 1) {
								System.out.println("\n" + Player.getName() + " attacks! "+ monster[i].getType() + " dodges! " + Player.getName() + " deals 0 dmg");
								comboM += 0.5;
							}
							else {
								monster[i].setHP(monster[i].getHP() - Player.getATK());
								System.out.println("\n" + Player.getName() + " attacks! " + monster[i].getType() + " receives " + Player.getATK() + " dmg. \n" + 
										monster[i].getType() + " has " + monster[i].getHP() + "HP left!");
								comboM = 1;
							}
							playerLast = true;
						}
					}
				} while (Player.getHP() > 0 && monster[i].getHP() > 0);
			//}
			
			if (Player.getHP() <= 0) {
				gameOver();
			}
			else {
				Player.setSta(Player.getSta() - 1);
				Player.setXP(Player.getXP() + monster[i].getID() + 1);
				Player.setMoni(Player.getMoni() + monster[i].getLevel()*3);
				System.out.println("\nYou've won the battle. You gained +" + (monster[i].getID()+1) + "XP, +" + (monster[i].getLevel()*3) + "Moni and -1STA");
				Player.setNbOfKills(Player.getNbOfKills() + 1);
				playerLast = false;
				System.out.print("\nPress Enter to continue.");
				choice = key.nextLine();
			}
		}
		
		System.out.print("You have defeated every monster in this room. \n\nHP: " + Player.getHP() + "   STA: " + Player.getSta() + "\nEnter next room (y/n)? ");
		choice = key.nextLine();
		if (!choice.equalsIgnoreCase("y")) {
			System.out.print("\nAre you sure? Room progress will be lost (y/n). ");
			choice = key.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				menu();
				inDungeon = false;
			}
			else {
				System.out.print("Enter next room (y/n)? ");
				choice = key.nextLine();
				if(!choice.equalsIgnoreCase("y")) {
					menu();
					inDungeon = false;
				}
			}
		}
	}
	
	public static void gameOver() {
		System.out.println("\nYou have died. Game Over.\n");
		gameOver = true;
		inDungeon = false;
		System.out.println(Player.getString());
		System.exit(0);
	}
	
	public static void home() throws InterruptedException {
		System.out.print("\nR-Rest   E-Eat   I-Inventory   M-Menu \n\n>>>");
		choice = key.nextLine();
		do {
			switch (choice.toUpperCase()) {
				case "M":
					loading("Getting ready", 1, 500);
					menu();
					break;
				case "E":
					loading("Eating", 3, 500);
					Player.setHP(Player.getMaxHP());
					System.out.print("\nYou have recovered all your hp!\n");
					home();
					break;
				case "R":
					loading("Resting", 3, 1000);
					Player.setSta(Player.getMaxSta());
					System.out.print("\nYou have recovered all your stamina!\n");
					home();
					break;
				default:
					System.out.print("Sorry, that is not a valid option.\n\n>>>");
					choice = key.nextLine();
					break;
			}
		} while(!choice.equalsIgnoreCase("M"));
	}
	
	public static void gym() throws InterruptedException {
		int atkCost = Player.getATK() + 5;
		int defCost = Player.getDEF() + 5;
		int dexCost = Player.getDEX() + 5;
		
		System.out.print("\nXP: " + Player.getXP() + "   STA: " + Player.getSta() + "/" + Player.getMaxSta() +
				"\nATK: " + Player.getATK() + "   A-Attack(" + atkCost + "XP) \nDEF: " + Player.getDEF() + "   B-Defense(" + defCost + "XP) \nDEX: " +
				Player.getDEX() + "   C-Dexterity(" + dexCost + "XP) \n\nM-Menu \n\n>>>");
		
		choice = key.nextLine();
		do {
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
					choice = key.nextLine();
					break;
			}
		} while(!choice.equalsIgnoreCase("M"));
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
					System.out.print("Exchange " + (qty * cost) + "XP for " + qty + stat + " (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setXP(Player.getXP() - (qty * cost));
						loading(stat + " training", 3, 400);
						Player.setSta(Player.getSta() - 1);
						System.out.println("\nYou gained +" + qty + stat + " and -1STA");
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
	
	public static void learn() {
		
	}
	
	public static void loading(String text, int repeat, int time) throws InterruptedException {
		for (int i = 0; i < repeat; i++) {
			System.out.print(text + "...   ");
			Thread.sleep(time);
		}
		System.out.println("");
	}
	

}
