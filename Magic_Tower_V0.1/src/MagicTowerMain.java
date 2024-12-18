import java.util.Scanner;

public class MagicTowerMain {
	static GameData gameData;
	static GameControl gameControl;
	static Menu menu;

	public static void main(String[] args) {
		gameData = new GameData();
		gameData.readMapFromFile("Map.in");
		gameData.printMap();

		Hero hero = chooseHero();
		gameData.setHero(hero);

		menu = new Menu(gameData);
		menu.loadMenu("Menu.XML");
		gameControl = new GameControl(gameData, menu);
		gameControl.gameStart();
	}

	private static Hero chooseHero() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请选择你的英雄:");
		System.out.println("1. 战士 (Warrior)");
		System.out.println("2. 法师 (Mage)");

		while (true) {
			String choice = scanner.next();
			switch (choice) {
				case "1":
					System.out.println("你选择了战士!");
					return new Warrior(gameData, 150, 10, 5, 10, 5);
				case "2":
					System.out.println("你选择了法师!");
					return new Mage(gameData, 100, 5, 15, 5, 10);
				default:
					System.out.println("无效输入，请重新选择!");
			}
		}
	}
}
