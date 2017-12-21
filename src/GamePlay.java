import java.util.InputMismatchException;
import java.util.Scanner;

public class GamePlay {
	static Scanner key = new Scanner(System.in);
	static String choice;
	static boolean gameOver = false;
	static boolean inDungeon = false;
	static int exhaustCount = 0;
	static int checkPoint = 0;
	static int roomLevelAt = 1;
	
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
					System.out.print(Player.getString() + "\n\nM-Menu\n\n>>> "); 
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
				case "S":
					loading("Counting Moni", 1, 500);
					System.out.println("Welcome dear customer! What item would you like to buy?\n");
					store();
					break;
				case "D":
					loading("Entering dungeon", 1, 500);
					System.out.println("We are not responsible for your death, " + Player.getName() + ".");
					dungeon();
					break;
				case "X":
					printMonsters();
					System.out.println("M-Menu \n\n>>> ");
					break;
				default: 
					System.out.print("Sorry, that is not a valid option.\n\n>>> ");
					break;
			}
		} while (!gameOver);
		
		key.close();
	}
	
	public static void menu() {
		System.out.print("\nWhat would you like to do? \nD-Dungeon   G-Gym   S-Store   H-Home   \nP-" + Player.getName() + 
				"'s Profile   I-Instructions   X-Monster Database \n\n>>> ");
	}
	
	public static void instruction() {
		System.out.print("instructions...");
	}
	
	public static void dungeon() throws InterruptedException {
		inDungeon = true;
		int i = 0;
		if (checkPoint > 0) {
			System.out.println("\nGo to CheckPoint room " + checkPoint + " (y/n)? " );
			choice = key.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				roomLevelAt = checkPoint;
				while (inDungeon) {
					enterRoom(checkPoint + (i++));
					roomLevelAt += 1;
				}
			}
			else {
				System.out.print("\nEnter the first room (y/n)? ");
				choice = key.nextLine();
				if (choice.equalsIgnoreCase("y")) {
					roomLevelAt = 1;
					while (inDungeon) {
						enterRoom(++i);
						roomLevelAt += 1;
					}
				}
				else
					menu();
			}
		}
		else {
			System.out.print("\nEnter the first room (y/n)? ");
			choice = key.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				while (inDungeon) {
					enterRoom(++i);
					roomLevelAt += 1;
				}
			}
			else
				menu();
		}
	}
	
	public static int usingItem() {
		System.out.print(Player.getItems() + "\n\nWhat to use? \n>>> ");
		choice = key.nextLine();
		switch (choice.toUpperCase()) {
			case "A":
				if (Player.getNbHPPotion() == 0)
					System.out.println("You don't have any HP Potion.");
				else {
					System.out.println("Use a HP potion (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setNbHPPotion(Player.getNbHPPotion() - 1);
						Player.setHP(Player.getHP() + 5);
						System.out.println("You recovered 5 HP!");
					}
				}
				break;
			case "B":
				if (Player.getNbSTAPotion() == 0)
					System.out.println("You don't have any STA Potion.");
				else {
					System.out.println("Use a STA potion (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setNbSTAPotion(Player.getNbSTAPotion() - 1);
						Player.setSta(Player.getSta() + 5);
						System.out.println("You recovered 5 STA!");
					}
				}
				break;
			case "C":
				if (Player.getNbCamouflage() == 0)
					System.out.println("You don't have any Camouflage.");
				else {
					System.out.println("Use a Camouflage (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setNbCamouflage(Player.getNbCamouflage() - 1);
						roomLevelAt += 1;
						System.out.println("You skipped one room!");
					}
				}
				break;
			case "D":
				if (Player.getNbMegaBooster() == 0)
					System.out.println("You don't have any Mega Booster.");
				else {
					System.out.println("Use a Mega Booster (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setNbMegaBooster(Player.getNbMegaBooster() - 1);
						roomLevelAt += 5;
						System.out.println("You skipped 5 rooms!");
					}
				}
				break;
			case "E":
				if (Player.getNbCheckPoint() == 0)
					System.out.println("You don't have any CheckPoint.");
				else {
					System.out.println("Use a CheckPoint (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setNbCheckPoint(Player.getNbCheckPoint() - 1);
						checkPoint = roomLevelAt;
						System.out.println("You placed a CheckPoint in room " + roomLevelAt);
					}
				}
				break;
			default:
				System.out.print("Sorry, that is not a valid option.\n\n>>> ");
				break;
		}
		return (roomLevelAt);
	}
	
	public static void enterRoom(int difficulty) throws InterruptedException {
		do {
			System.out.print("\nI-Items   F-Fight \n>>> ");
			choice = key.nextLine();
			
			switch (choice.toUpperCase()) {
				case "I":
					usingItem();
					difficulty = roomLevelAt;
					break;
				case "F":
					break;
				default:
					System.out.print("Sorry, that is not a valid option.\n\n>>> ");
					break;
			}
		} while (!choice.equalsIgnoreCase("F"));
		
		if (Player.getSta() == 0) {
			Player.setATK(Player.getATK()/2);
			Player.setDEX(Player.getDEX()/2);
			exhaustCount += 1;
		}
		
		if (Player.getDeepestRoom() < difficulty)
			Player.setDeepestRoom(difficulty);
		
		Room room = new Room(difficulty);
		
		Monster[] monsterList = room.generateMonsters();
		
		System.out.println("\nYou have entered room " + difficulty + ".");
		System.out.print("There " + (room.getNbOfMonsters() > 1 ? "are " + room.getNbOfMonsters() +  " monsters" : "is " + 
						  room.getNbOfMonsters() + " monster") + " in the room. There's no turning back.\n\n");
		
		for (int i = 0; i < room.getNbOfMonsters(); i++) {
			System.out.println(monsterList[i]);
		}

		System.out.print("Press Enter to continue.");
		choice = key.nextLine();
		battle(room.getNbOfMonsters(), monsterList);
	}
	
	public static void battle(int nbMonster, Monster[] monster) throws InterruptedException {
		boolean playerLast = false;
		int comboP = 1;
		int comboM = 1;

		for (int i = 0; i < nbMonster; i++) {
			
			Monster.setEncountered(monster[i].getID() ,Monster.getEncountered(monster[i].getID()) + 1);
			
			System.out.println("\nBatte " + (i+1) + ": " + Player.getBattleStats() + " vs " + monster[i]);
			
			System.out.print("Press Enter to continue.");
			choice = key.nextLine();
				
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
					System.out.print("Press Enter to continue.");
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
			
			if (Player.getHP() <= 0) {
				gameOver();
			}
			else {
				Player.setSta(Player.getSta() - 1);
				Player.setXP(Player.getXP() + monster[i].getID() + 1);
				Player.setMoni(Player.getMoni() + monster[i].getLevel()*3);
				System.out.println("\nYou won the battle. You gained +" + (monster[i].getID()+1) + "XP, +" + (monster[i].getLevel()*3) + "Moni and -1STA");
				Player.setNbOfKills(Player.getNbOfKills() + 1);
				playerLast = false;
	
				System.out.print("\nPress Enter to continue.");
				choice = key.nextLine();
			}
		}
		
		System.out.print("\nYou have defeated every monster in this room. \n\nHP: " + Player.getHP() + "   STA: " + Player.getSta());
		if (Player.getSta() == 0)
			System.out.println("\nYou are tired! Your current ATK and DEX will be reduced by half in the next room!");
		
		System.out.print("\nEnter next room (y/n)? ");
		choice = key.nextLine();
		if (!choice.equalsIgnoreCase("y")) {
			System.out.print("\nAre you sure? Room progress will be lost (y/n). ");
			choice = key.nextLine();
			if(choice.equalsIgnoreCase("y")) {
				loading("Getting to safety", 1, 500);
				inDungeon = false;
				menu();
			}
			else {
				System.out.print("Enter next room (y/n)? ");
				choice = key.nextLine();
				if(!choice.equalsIgnoreCase("y")) {
					loading("Getting to safety", 1, 500);
					inDungeon = false;
					menu();
					
				}
			}
		}
	}
	
	public static void gameOver() {
		System.out.println("\nYou have died. Game Over.\n");
		gameOver = true;
		inDungeon = false;
		System.out.println(Player.getString());
		key.close();
		System.exit(0);
	}
	
	public static void home() throws InterruptedException {
		System.out.print("\nR-Rest   E-Eat   M-Menu \n\n>>> ");
		choice = key.nextLine();
		do {
			switch (choice.toUpperCase()) {
				case "M":
					loading("Getting ready", 1, 500);
					menu();
					break;
				case "P": 
					System.out.print(Player.getString() + "\n\nPress Enter to go back.");
					choice = key.nextLine();
					home();
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
					if (exhaustCount > 0) {
						Player.setATK(Player.getATK() * 2 * exhaustCount);
						Player.setDEX(Player.getDEX() * 2 * exhaustCount);
						exhaustCount = 0;
					}
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
				Player.getDEX() + "   C-Dexterity(" + dexCost + "XP) \n\nM-Menu \n\n>>> ");
		
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
				case "P": 
					System.out.print(Player.getString() + "\n\nPress Enter to go back.");
					choice = key.nextLine();
					gym();
				case "M":
					loading("Thank you for training with us!", 1, 500);
					menu();
					break;
				default:
					System.out.print("Sorry, that is not a valid option.\n\n>>> ");
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
				else if (Player.getSta() == 0) {
					System.out.print("You're exhausted! Please go rest before training! \n");
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
	
	public static void store() throws InterruptedException {
		System.out.println("Moni: " + Player.getMoni());
		System.out.println("A-HP potion (30Moni)");
		System.out.println("B-STA potion (30Moni)");
		System.out.println("C-Camouflage (30Moni)");
		System.out.println("D-Mega Booster (50Moni)");
		System.out.print("E-CheckPoint (100Moni) \n\nM-Menu \n\n>>> ");
		
		choice = key.nextLine();
		do {
		switch (choice.toUpperCase()) {
			case "A":
				System.out.println("Drink this potion and recover 5 hp!");
				Player.setNbHPPotion(Player.getNbHPPotion() + buying(30, "HP potion"));
				store();
				break;
			case "B":
				System.out.println("Drink this potion and recover 5 stamina!");
				Player.setNbSTAPotion(Player.getNbSTAPotion() + buying(30, "STA potion"));
				store();
				break;
			case "C":
				System.out.println("Wear this camouflage to skip right through one dungeon room!");
				Player.setNbCamouflage(Player.getNbCamouflage() + buying(30, "Camouflage"));
				store();
				break;
			case "D":
				System.out.println("Use this booster to skip through 5 rooms!");
				Player.setNbMegaBooster(Player.getNbMegaBooster() + buying(50, "Mega Booster"));
				store();
				break;
			case "E":
				System.out.println("Use this to save a checkpoint to return to in the dungeon! ONE USE ONLY AND EACH USE OVERRIDES.");
				Player.setNbCheckPoint(Player.getNbCheckPoint() + buying(100, "CheckPoint"));
				store();
				break;
			case "P": 
				System.out.print(Player.getString() + "\n\nPress Enter to go back.");
				choice = key.nextLine();
				store();
			case "M":
				loading("Thank you for shopping with us!", 1, 500);
				menu();
				break;
			default:
				System.out.print("Sorry, that is not a valid option.\n\n>>> ");
				choice = key.nextLine();
				break;
			}
		} while (!choice.equalsIgnoreCase("m"));
	}
	
	public static int buying(int cost, String item) throws InterruptedException {
		int qty;
		try {
			System.out.print("How many " + item + " would you like to buy? ");
			qty = Integer.parseInt(key.nextLine());
			
			if (qty < 0)
				do {
					System.out.print("Please enter a positive integer: ");
					qty = Integer.parseInt(key.nextLine());
				} while (qty < 0);
			
			if (qty == 0)
				return (0);
			else {
				if (qty * cost > Player.getMoni()) {
					System.out.print("Sorry, you don't have enough Moni for that.\n");
					return (0);
				}
				else {
					System.out.print("Exchange " + (qty * cost) + "Moni for " + qty + " " + item + " (y/n)? ");
					choice = key.nextLine();
					if (choice.equalsIgnoreCase("y")) {
						Player.setMoni(Player.getMoni() - (qty * cost));
						loading("Buying", 1, 400);
						System.out.println("\nYou bought " + qty + " " + item + "\n");
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
	
	public static void printMonsters() {
		for (int i = 0; i < 26; i++) {
			if (Monster.getEncountered(i) > 0) {
				System.out.println(new Monster(i).getMonster());
			}
			else
				System.out.println("Monsters will appear here as you meet them.\n");
		}
	}
	
	public static void loading(String text, int repeat, int time) throws InterruptedException {
		for (int i = 0; i < repeat; i++) {
			System.out.print(text + "...   ");
			Thread.sleep(time);
		}
		System.out.println("");
	}
	

}
