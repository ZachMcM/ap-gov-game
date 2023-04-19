public class VladimirPutin extends Enemy {
    public VladimirPutin(double initHealth, String initName, String initDeathMessage) {
        super(initHealth, initName, initDeathMessage);
    }
    
    public void dealDamage(Player player, int wrongStreak) {
        double damage = 25;
        if (wrongStreak > 3) {
            damage = damage * 1.5;
        }
        player.takeDamage(damage);
        System.out.println();
        System.out.println("Vladimir Putin used Soviet Slam!");
        System.out.println(name + " Health: " + health);
    }
}
