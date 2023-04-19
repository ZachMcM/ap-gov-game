public class Xi extends Enemy {
    public Xi(double initHealth, String initName, String initDeathMessage) {
        super(initHealth, initName, initDeathMessage);
    }
    
    public void dealDamage(Player player, int wrongStreak) {
        double damage = 30;
        if (wrongStreak > 3) {
            damage = damage * 2;
        }
        player.takeDamage(damage);
        System.out.println();
        System.out.println("Xi Jinping used China Chokehold!");
        System.out.println(name + " Health: " + health);
    }
}
