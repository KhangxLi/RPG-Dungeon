
public class Monster {
	private int atk;
	private int hp;
	private int dex;
	private String type;
	
	public Monster(String type) {
		switch (type) {
			case "Blob": this.type = type; atk = 1; hp = 6; dex = 1; break;
		}
	}
}
