import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

	static User Trump = new User();
	static Enemy Hillary = new Enemy();
	static Enemy Pence = new Enemy();
	static Enemy Rubio = new Enemy();
	static List<Enemy> aliveEnemys = new ArrayList<Enemy>();
	static Boolean myTurn = true;

	public static void main(String[] args) throws InterruptedException {
		myTurn = true;
		aliveEnemys.add(Hillary);
		aliveEnemys.add(Pence);
		aliveEnemys.add(Rubio);
		run();
	}

	public static void run() {
		if (Trump.getHealth() == 0) {
			System.out.println("==================================");
			System.out.println("You lost!");
			return;
		}
		if (aliveEnemys.size() == 0) {
			System.out.println("==================================");
			System.out.println("You won!");
			return;
		}

		System.out.println("==================================");
		System.out.println("Hillary, Pence & Rubio appeared!");
		System.out.println("Enter: \"attack <monster> to attack!\"");
		Scanner scanner = new Scanner(System.in);
		String i = scanner.nextLine();
		if (i.toLowerCase().contains("attack ")) {
			String monster_name = i.substring(i.lastIndexOf(" ") + 1);
			int attackDamage = 0;
			switch (monster_name.toLowerCase()) {
			case "hillary":
				attackDamage = attackDamage();
				Hillary.setHealth(Hillary.getHealth() - attackDamage);
				System.out.println("==================================");
				System.out.println("Trump hits Hillary with " + attackDamage + " attack damage!");
				healthBar();
				myTurn = false;
				enemyAttack();
				break;
			case "pence":
				attackDamage = attackDamage();
				Pence.setHealth(Pence.getHealth() - attackDamage);
				System.out.println("==================================");
				System.out.println("Trump hits Pence with " + attackDamage + " attack damage!");
				healthBar();
				myTurn = false;
				enemyAttack();
				break;
			case "rubio":
				attackDamage = attackDamage();
				Rubio.setHealth(Rubio.getHealth() - attackDamage);
				System.out.println("==================================");
				System.out.println("Trump hits Rubio with " + attackDamage + " attack damage!");
				healthBar();
				myTurn = false;
				enemyAttack();
				break;
			default:
				System.out.println("==================================");
				System.out.println("This is not an valid user!");
				run();
				break;
			}
		} else {
			run();
		}
	}

	public static void enemyAttack() {
		if (aliveEnemys.size() > 0) {
			if (Hillary.getHealth() == 0) {
				aliveEnemys.remove(Hillary);
			}
			if (Pence.getHealth() == 0) {
				aliveEnemys.remove(Pence);
			}
			if (Rubio.getHealth() == 0) {
				aliveEnemys.remove(Rubio);
			}
			for (Enemy enemy : aliveEnemys) {
				int attackDamage = attackDamage();
				Trump.setHealth(Trump.getHealth() - attackDamage);
				System.out.println("==================================");
				System.out.println("An enemy hits Trump with " + attackDamage + " attack damage!");
			}
			healthBar();
			myTurn = true;
			run();
		}
	}

	public static void healthBar() {
		System.out.println("==================================");
		System.out.println("Trump (You): " + Trump.getHealth());
		System.out.println("Hillary: " + Hillary.getHealth());
		System.out.println("Pence: " + Pence.getHealth());
		System.out.println("Rubio: " + Rubio.getHealth());
	}

	public static int attackDamage() {
		Random rand = new Random();
		int attackDamage = rand.nextInt(25);
		return attackDamage;
	}

}
