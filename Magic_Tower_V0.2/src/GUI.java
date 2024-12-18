import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI {
	GameData gameData;
	Menu menu;
	GameControl gameControl;
	JFrame f;
	JLabel[][] b;
	JButton upButton, downButton, leftButton, rightButton;
	public GUI(GameData gameData, Menu menu, GameControl gameControl) {
		this.gameData = gameData;
		this.menu = menu;
		this.gameControl = gameControl;
		f = new JFrame("Magic Tower");
		b = new JLabel[gameData.H][gameData.W];

		for (int i = 0; i < gameData.H; i++) {
			for (int j = 0; j < gameData.W; j++) {
				b[i][j] = new JLabel();
				b[i][j].setBounds(j * 100, i * 100, 100, 100);
				f.add(b[i][j]);
			}
		}

		upButton = new JButton("↑");
		downButton = new JButton("↓");
		leftButton = new JButton("←");
		rightButton = new JButton("→");

		upButton.setBounds(gameData.W * 100 + 40, 100, 80, 40);
		downButton.setBounds(gameData.W * 100 + 40, 200, 80, 40);
		leftButton.setBounds(gameData.W * 100 +10, 150, 80, 40);
		rightButton.setBounds(gameData.W * 100 + 90, 150, 80, 40);

		f.add(upButton);
		f.add(downButton);
		f.add(leftButton);
		f.add(rightButton);

		upButton.addActionListener(e -> {
            if (gameControl != null) {
                gameControl.handleInput('w');
                refreshGUI();
            }
        });

		downButton.addActionListener(e -> {
            if (gameControl != null) {
                gameControl.handleInput('s');
                refreshGUI();
            }
        });

		leftButton.addActionListener(e -> {
            if (gameControl != null) {
                gameControl.handleInput('a');
                refreshGUI();
            }
        });

		rightButton.addActionListener(e -> {
            if (gameControl != null) {
                gameControl.handleInput('d');
                refreshGUI();
            }
        });

		f.setSize(gameData.H * 100 + 200, gameData.W * 100 + 200);
		f.setLayout(null);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		refreshGUI();
	}


	public void refreshGUI() {
		for (int i = 0; i < gameData.H; i++) {
			for (int j = 0; j < gameData.W; j++) {
				Image scaledImage = chooseImage(gameData.map[gameData.currentLevel][i][j]);
				b[i][j].setIcon(new ImageIcon(scaledImage));
			}
		}
	}

	private static Image chooseImage(int index) {
		ImageIcon[] icons = new ImageIcon[10];
		Image scaledImage;
		icons[0] = new ImageIcon("Wall.jpg");
		icons[1] = new ImageIcon("Floor.jpg");
		icons[2] = new ImageIcon("Key.jpg");
		icons[3] = new ImageIcon("Door.jpg");
		icons[4] = new ImageIcon("Stair.jpg");
		icons[5] = new ImageIcon("Exit.jpg");
		icons[6] = new ImageIcon("Hero.jpg");
		icons[7] = new ImageIcon("Potion.jpg");
		icons[8] = new ImageIcon("Monster.jpg");
		if (index > 10)
			scaledImage = icons[7].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		else if (index < 0)
			scaledImage = icons[8].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		else
			scaledImage = icons[index].getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		return scaledImage;
	}
}