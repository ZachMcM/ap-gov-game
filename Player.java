public class Player {
    private String name;
    private double health = 100.0;

    public Player(String initName) {
        name = initName;
    }

    public String getName() {
        return name;
    }

    public void takeDamage(double damage) {
        health -= damage;
    }

    public double getHealth() {
        return Math.floor(health * 100) / 100;
    }

    //attack methods
    private void randomAttack(Enemy npc) {
        int randomAttack = (int)(Math.random() * 6);
        switch (randomAttack) {
            case 0:
                freedomFist(npc);
                break;
            case 1:
                freePressPummel(npc);
                break;
            case 2:
                brownBash(npc);
                break;
            case 3:
                unenumeratedUproar(npc);
                break;
            case 4:
                patriotPunish(npc);
                break;
            case 5:
                tinkerTerrorize(npc);
                break;
        }
    }

    public void playerReact(Enemy npc, int rightStreak) {
        if (rightStreak == 10) {
            sovereigntyShield(npc);
        } else if (rightStreak == 20) {
            equalProtection(npc);
        } else if (rightStreak == 25) {
            washingtonWack(npc);
        } else {
            randomAttack(npc);
        }
    }

    private void printEnemyHealth(Enemy npc) {
        System.out.println();
        double enemyHealth = npc.getHealth();
        if (enemyHealth <= 0) {
            npc.printDeathMessage();
        } else {
            System.out.println(npc.getName() + " Health: " + npc.getHealth());
        }
    }

    public void printHealth() {
        if (health > 0) {
            System.out.println();
            System.out.println("Your health: " + health);
        }
    }

    private void washingtonWack(Enemy npc) {
        double currHealth = npc.getHealth();
        double damage = currHealth * 0.40;
        if (currHealth > 50) {
            npc.takeDamage(damage);
            System.out.println();
            System.out.println("You used Washington Wack!");
            System.out.println(damage + " Damage dealt");
            System.out.println("Your health: " + Math.floor(health * 100) / 100);
        } else {
            randomAttack(npc);
        }

        printEnemyHealth(npc);
    }

    private void freedomFist(Enemy npc) {
        double damage = 17.76;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Freedom Fist's!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    private void freePressPummel(Enemy npc) {
        double damage = 17.91;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Free Press Pummel!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    private void brownBash(Enemy npc) {
        double damage = 19.54;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Brown Bash!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    private void unenumeratedUproar(Enemy npc) {
        double damage = 17.91;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Unenumerated Uproar!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    private void patriotPunish(Enemy npc) {
        double damage = 20.01;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Patriot Punish!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    private void tinkerTerrorize(Enemy npc) {
        double damage = 19.69;
        npc.takeDamage(damage);

        System.out.println();
        System.out.println("You used Tinker Terrorize!");
        System.out.println(damage + " Damage dealt");
        System.out.println("Your health: " + Math.floor(health * 100) / 100);

        printEnemyHealth(npc);
    }

    //shield methods
    public void equalProtection(Enemy npc) {
        double healthAdded = 18.68;
        health += healthAdded; 
        System.out.println();
        System.out.println("You used Equal Protection!");
        System.out.println(healthAdded + " Health added");
        System.out.println("Your health: " + health);

        printEnemyHealth(npc);
    }

    public void sovereigntyShield(Enemy npc) {
        double healthAdded = 17.76;
        health += healthAdded; 
        System.out.println();
        System.out.println("You used Sovereignty Shield!");
        System.out.println(healthAdded + " Health added");
        System.out.println("Your health: " + health);

        printEnemyHealth(npc);
    }
}
