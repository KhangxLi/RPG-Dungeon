public class Monster {
		private int atk;
		private int hp;
		private int maxHP;
		private int dex;
		private int id;
		private int level;
		private String type;
		
		public Monster(int id) {
			switch (id) {
				case 0: 
					this.id = 0; type = "Blob"; atk = 1; dex = 0; hp = 2; maxHP = 2;
					break;
				case 1:
					this.id = 1; type = "Slime"; atk = 1; dex = 1; hp = 2; maxHP = 3;
					break;
				case 2:
					this.id = 2; type = "Centipede"; atk = 1; dex = 2; hp = 2; maxHP = 2;
					break;
				case 3:
					this.id = 3; type = "Wasp"; atk = 2; dex = 2; hp = 2; maxHP = 2;
					break;
				case 4:
					this.id = 4; type = "Muder"; atk = 2; dex = 2; hp = 4; maxHP = 4;
				case 5:
					this.id = 5; type = "Crawler"; atk = 3; dex = 2; hp = 3; maxHP = 3;
				default:
					this.id = 25; type = "Yourself"; atk = Player.getATK(); dex = Player.getDEX(); hp = Player.getMaxHP();
					break;
			}
		}
		
		public String toString() {
			return (getType() + "(" + getATK() + "ATK, " + getDEX() + "DEX, " + getHP() + "HP)");
		}
		
		public int getLevel() {
			level = (int)((getATK() + getDEX() + getMaxHP())/3);
			return (level);
		}
		
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
			return(hp);
		}
		public void setHP(int x) {
			this.hp = x;
		}
		
		public int getMaxHP() {
			return(maxHP);
		}
	}