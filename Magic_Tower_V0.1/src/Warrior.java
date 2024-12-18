public class Warrior extends Hero {
    public Warrior(GameData gameData, double health, double physicalAttack, double magicAttack, double amor, double blue) {
        super(gameData, health, physicalAttack, magicAttack, amor, blue);
        setHealth(150);
        setAmor(10);
        setPhysicalAttack(15);
        setMagicAttack(5);
        setBlue(5);
    }

    @Override
    public void useSkill() {
        if (getBlue() >= 5) {
            setBlue(getBlue() - 5);
            setAmor(getAmor() + 5);
            System.out.println("战士使用了护甲强化，护甲值增加到：" + getAmor());
        } else {
            System.out.println("蓝量不足，无法使用技能！");
        }
    }
}

