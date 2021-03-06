public class Monster {
		private int atk; // monster's attack power
		private int hp; // monster's current hp
		private int maxHP; // monster's maximum hp
		private int dex; // monster's dexterity
		private int id; // monster's id number
		private int level; // monster's level
		private String type; // monster's type
		private static int[] encountered = new int[26]; // array with each index representing monster's id and containing the number of times it has been encountered by Player
		
		// Monster constructor taking an id as argument
		public Monster(int id) {
			switch (id) {
				case 0: 
					this.id = id; type = "Blob"; atk = 1; dex = 0; hp = 2; maxHP = 2;
					break;
				case 1:
					this.id = id; type = "Slime"; atk = 1; dex = 1; hp = 2; maxHP = 3;
					break;
				case 2:
					this.id = id; type = "Centipede"; atk = 1; dex = 2; hp = 2; maxHP = 2;
					break;
				case 3:
					this.id = id; type = "Wasp"; atk = 2; dex = 2; hp = 2; maxHP = 2;
					break;
				case 4:
					this.id = id; type = "Frog"; atk = 2; dex = 2; hp = 4; maxHP = 4;
					break;
				case 5:
					this.id = id; type = "Rat"; atk = 3; dex = 2; hp = 3; maxHP = 3;
					break;
				case 6:
					this.id = id; type = "Coyote"; atk = 3; dex = 3; hp = 3; maxHP = 3;
					break;
				case 7:
					this.id = id; type = "Wolf"; atk = 3; dex = 3; hp = 5; maxHP = 5;
					break;
				case 8:
					this.id = id; type = "Tiger"; atk = 5; dex = 3; hp = 6; maxHP = 6;
					break;
				case 9:
					this.id = id; type = "Grizzly"; atk = 4; dex = 3; hp = 7; maxHP = 7;
					break;
				case 10:
					this.id = id; type = "Undead"; atk = 3; dex = 1; hp = 13; maxHP = 13;
					break;
				case 11:
					this.id = id; type = "Ghost"; atk = 2; dex = 5; hp = 10; maxHP = 10;
					break;
				case 12:
					this.id = id; type = "LoliDemon"; atk = 5; dex = 3; hp = 10; maxHP = 10;
					break;
				case 13:
					this.id = id; type = "Rotten Gator"; atk = 4; dex = 4; hp = 11; maxHP = 11;
					break;
				case 14:
					this.id = id; type = "SwordMonkey"; atk = 5; dex = 4; hp = 13; maxHP = 13;
					break;
				case 15:
					this.id = id; type = "Golem"; atk = 4; dex = 2; hp = 15; maxHP = 15;
					break;
				case 16:
					this.id = id; type = "FireSpirit"; atk = 6; dex = 5; hp = 13; maxHP = 13;
					break;
				case 17:
					this.id = id; type = "WaterSpirit"; atk = 6; dex = 6; hp = 13; maxHP = 13;
					break;
				case 18:
					this.id = id; type = "DarkSpirit"; atk = 5; dex = 5; hp = 17; maxHP = 17;
					break;
				case 19:
					this.id = id; type = "PureSpirit"; atk = 6; dex = 5; hp = 17; maxHP = 17;
					break;
				case 20:
					this.id = id; type = "Abomination"; atk = 8; dex = 5; hp = 18; maxHP = 18;
					break;
				case 21:
					this.id = id; type = "Ouroboros"; atk = 9; dex = 6; hp = 20; maxHP = 20;
					break;
				case 22:
					this.id = id; type = "Dragan"; atk = 10; dex = 6; hp = 25; maxHP = 25;
					break;
				case 23:
					this.id = id; type = "Kraniki"; atk = 15; dex = 7; hp = 30; maxHP = 30;
					break;
				case 24:
					this.id = id; type = "MotherShip"; atk = 20; dex = 0; hp = 50; maxHP = 50;
					break;
				default:
					this.id = 25; type = "Yourself"; atk = Player.getATK(); dex = Player.getDEX(); hp = Player.getMaxHP();
					break;
			}
		}
		
		// toString for in combat
		public String toString() {
			return (getType() + "(" + getATK() + "ATK, " + getDEX() + "DEX, " + getHP() + "HP)");
		}
		
		// return monster id, level and stats and the number of times it has been encountered
		public String getMonster() {
			return (getType() + ", ID#: " + getID() + ", " + getATK() + "ATK, " + getDEX() + "DEX, " + getMaxHP() + "HP, Level: " + getLevel() + ", encountered " + 
		(getEncountered(getID()) > 1 ? getEncountered(getID()) + " times.\n" : getEncountered(getID()) + " time.\n"));
		}
		
		// return a monster's level which depends on its attack, dexterity and max hp
		public int getLevel() {
			level = (int)((getATK() + getDEX() + getMaxHP())/3);
			return (level);
		}
		
		
		// getters and setters
		public int getID() {
			return (id);
		}
		
		public String getType() {
			return (type);
		}
		
		public int getATK() {
			return (atk);
		}
		
		public int getDEX() {
			return(dex);
		}
		
		public int getHP() {
			if (hp <= 0)
				return (0);
			else
				return(hp);
		}
		public void setHP(int x) {
			this.hp = x;
		}
		
		public int getMaxHP() {
			return(maxHP);
		}
		
		
		// getter and setter taking monster id as argument
		public static int getEncountered(int id) {
			return (encountered[id]);
		}
		public static void setEncountered(int id, int x) {
			encountered[id] = x;
		}
	}