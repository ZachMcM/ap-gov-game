public class Enemy {
    protected double health;
    protected String name;
    private String deathMessage;

    public Enemy(double initHealth, String initName, String initDeathMessage) {
        health = initHealth;
        name = initName;
        deathMessage = initDeathMessage;
    }

    public Enemy() {
        health = -1;
        name = "default";
        deathMessage = "default";
    }

    public String getName() {
        return name;
    }

    public double getHealth() {
        return  Math.floor(health * 100) / 100;
    }

    public void takeDamage(double damage) {
        health -= damage;
    }

    public void dealDamage(Player player, int wrongStreak) {}

    public void printDeathMessage() {
        System.out.println(name + "says, \"NOOOO! " + deathMessage + "\"");
    }
}
