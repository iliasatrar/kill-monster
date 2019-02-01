public class Enemy {

	private int health = 50;

	public void setHealth(int value) {
		if (value >= 50) {
			value = 50;
		}
		if (value <= 0) {
			value = 0;
		}
		health = value;
	}

	public int getHealth() {
		return health;
	}

}
