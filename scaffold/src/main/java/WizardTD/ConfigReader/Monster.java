package WizardTD.ConfigReader;

public class Monster {
    private String type;
    private int hp;
    private double speed;
    private double armour;
    private int manaGainedOnKill;
    private int quantity;

    public Monster(String type, int hp, double speed, double armour, int manaGainedOnKill, int quantity) {
        this.type = type;
        this.hp = hp;
        this.speed = speed;
        this.armour = armour;
        this.manaGainedOnKill = manaGainedOnKill;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public double getSpeed() {
        return speed;
    }

    public double getArmour() {
        return armour;
    }

    public int getManaGainedOnKill() {
        return manaGainedOnKill;
    }

    public int getQuantity() {
        return quantity;
    }

}
