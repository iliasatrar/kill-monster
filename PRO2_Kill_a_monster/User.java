public class User {

	private int health = 200;

	public void setHealth(int value) {
		if (value >= 200) {
			value = 200;
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
