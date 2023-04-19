public class KingGeorge extends Enemy {
    public KingGeorge(double initHealth, String initName, String initDeathMessage) {
        super(initHealth, initName, initDeathMessage);
    }
    
    public void dealDamage(Player player, int wrongStreak) {
        double damage = 20;
        if (wrongStreak > 3) {
            damage = damage * 1.25;
        }
        player.takeDamage(damage);
        System.out.println();
        System.out.println("King George III used Britain Bash!");
        System.out.println(name + " Health: " + getHealth());
    }
}
