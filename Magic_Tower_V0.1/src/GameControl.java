import java.util.Scanner;

public class GameControl {
	GameData gameData;
	Menu menu;

	GameControl(GameData gameData, Menu menu) {
		this.gameData = gameData;
		this.menu = menu;
	}

	void gameStart() {
		Scanner keyboardInput = new Scanner(System.in);
		while (true) {
			System.out.println("请输入指令 (w/a/s/d 移动, 0 进入菜单, k 使用技能)：");
			String input = keyboardInput.next();
			if (input.length() != 1 || "wasd0k".indexOf(input.charAt(0)) == -1) {
				System.out.println("输入无效，请重新输入！");
				continue;
			}
			if (input.charAt(0) == '0') {
				menu.enterMenu();
			} else if (input.charAt(0) == 'k') {
				gameData.getHero().useSkill(); // 调用英雄技能
			} else {
				handleInput(input.charAt(0)); // 移动指令
			}
			gameData.printMap();
		}
	}


	void handleInput(char inC) {
		int tX = 0, tY = 0;
		if (inC == 'a') {
			tX = gameData.pX;
			tY = gameData.pY - 1;
		}
		if (inC == 's') {
			tX = gameData.pX + 1;
			tY = gameData.pY;
		}
		if (inC == 'd') {
			tX = gameData.pX;
			tY = gameData.pY + 1;
		}
		if (inC == 'w') {
			tX = gameData.pX - 1;
			tY = gameData.pY;
		}
		if (gameData.map[gameData.currentLevel][tX][tY] == 2) {
			gameData.keyNum++;
			moveHero(tX, tY);
		} else if (gameData.map[gameData.currentLevel][tX][tY] == 3 && gameData.keyNum > 0) {
			gameData.keyNum--;
			moveHero(tX, tY);
		} else if (gameData.map[gameData.currentLevel][tX][tY] == 4) {
			gameData.map[gameData.currentLevel][gameData.pX][gameData.pY] = 1;
			gameData.currentLevel++;
			for (int i = 0; i < gameData.H; i++)
				for (int j = 0; j < gameData.W; j++)
					if (gameData.map[gameData.currentLevel][i][j] == 6) {
						gameData.pX = i;
						gameData.pY = j;
					}
		} else if (gameData.map[gameData.currentLevel][tX][tY] == 5) {
			System.out.print("You Win!!");
			System.exit(0);
		} else if (gameData.map[gameData.currentLevel][tX][tY] > 10) {
			gameData.heroHealth += gameData.map[gameData.currentLevel][tX][tY];
			moveHero(tX, tY);
		} else if (gameData.map[gameData.currentLevel][tX][tY] == 1) {
			moveHero(tX, tY);
		} else if (gameData.map[gameData.currentLevel][tX][tY] < 0) {
			if (gameData.map[gameData.currentLevel][tX][tY] + gameData.heroHealth <= 0) {
				System.out.print("That monster has " + Integer.toString(-gameData.map[gameData.currentLevel][tX][tY])
						+ " power, You Lose!!");
				System.exit(0);
			} else {
				gameData.heroHealth += gameData.map[gameData.currentLevel][tX][tY];
				moveHero(tX, tY);
			}
		}
	}

	void moveHero(int tX, int tY) {
		gameData.map[gameData.currentLevel][gameData.pX][gameData.pY] = 1;
		gameData.map[gameData.currentLevel][tX][tY] = 6;
		gameData.pX = tX;
		gameData.pY = tY;
	}
}
