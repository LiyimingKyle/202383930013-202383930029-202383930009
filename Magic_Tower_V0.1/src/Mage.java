public class Mage extends Hero {
    public Mage(GameData gameData, double health, double physicalAttack, double magicAttack, double amor, double blue) {
        super(gameData, health, physicalAttack, magicAttack, amor, blue);
        super.setHealth(100);
        setAmor(5);
        setPhysicalAttack(5);
        setMagicAttack(20);
        setBlue(20);
    }

    @Override
    public void useSkill() {
        if (getBlue() >= 10) {
            setBlue(getBlue() - 10);
            System.out.println("法师使用了火球术，对周围怪物造成伤害！");
            // 这里可以自定义对地图上怪物的伤害逻辑，例如将怪物血量减少：
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int tX = gameData.pX + i;
                    int tY = gameData.pY + j;
                    if (tX >= 0 && tX < gameData.H && tY >= 0 && tY < gameData.W &&
                            gameData.map[gameData.currentLevel][tX][tY] < 0) {
                        gameData.map[gameData.currentLevel][tX][tY] += 10; // 怪物受到10点伤害
                        System.out.println("怪物在 (" + tX + ", " + tY + ") 受到了10点伤害！");
                    }
                }
            }
        } else {
            System.out.println("蓝量不足，无法使用技能！");
        }
    }
}

