public class Warrior extends Player {

    private int cooldown;
    private int remaining;

    public Warrior(int cooldown, Integer experience, Integer level, SpecialAbility specialAbility, String name, Health health, Integer attackPoints, Integer defencePoints, Position position) {
        super(experience, level, specialAbility, name, health, attackPoints, defencePoints, position);
        this.remaining = 0;
        this.cooldown = cooldown;
    }

    @Override
    public boolean play() {
        return false;
    }

    public void gametick() {
        remaining = remaining - 1;
    }

    public boolean cast() {
        if (remaining > 0) {
            return false;
        } else {
            remaining = cooldown;
            getHealth().setCurrentHealth(Math.min(getHealth().getCurrentHealth() + 2 * getDefencePoints(), getHealth().getHealthPool()));
            return true;
        }
    }

    public int getCooldown() {
        return cooldown;
    }

    public void setCooldown(int cooldown) {
        this.cooldown = cooldown;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int remaining) {
        this.remaining = remaining;
    }

}
