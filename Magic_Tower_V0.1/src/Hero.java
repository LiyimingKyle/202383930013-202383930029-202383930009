public abstract class Hero {
    double health = 100;
    double physicalAttack = 10;
    double magicAttack =10;
    double amor = 5;
    double Blue = 10;
    GameData gameData;
    private double blue;

    public Hero(GameData gameData, double health, double physicalAttack, double magicAttack, double amor, double blue) {
        this.gameData = gameData;
        setHealth(health);
        setPhysicalAttack(physicalAttack);
        setMagicAttack(magicAttack);
        setAmor(amor);
        setBlue(blue);
    }
    public void setMagicAttack(double magicAttack) {
    }

    public void setPhysicalAttack(double physicalAttack) {
        this.physicalAttack = physicalAttack;
    }

    public void setAmor(double amor) {
        this.amor = amor;
    }

    public double getAmor() {
        return amor;
    }

    public void setGameData(GameData gameData) {
        this.gameData = gameData;
    }

    public GameData getGameData() {
        return gameData;
    }

    public void setHealth(double health) {
        this.health = health;
    }

    public double getHealth() {
        return health;
    }



    public double getMagicAttack() {
        return magicAttack;
    }


    public double getPhysicalAttack() {
        return physicalAttack;
    }

    public void setBlue(double blue) {
        this.Blue=blue;
    }
    public abstract void useSkill();
    public double getBlue(){
        return blue;
    }

}
