import java.util.*;

class GovGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Question question = new Question();

        System.out.println();
        System.out.println("Welcome to The AP Gov Game");

        System.out.println();
        System.out.println("Please enter your name");
        Player player = new Player(input.nextLine());

        System.out.println();
        System.out.println("Hello " + player.getName());

        System.out.println();
        System.out.println("The goal is to beat all three enemies by answering US government and history questions correctly!");
        System.out.println("Type 1 to continue");
        
        String userInput = input.nextLine();
        while (!(userInput.equals("1"))) {
            System.out.println();
            System.out.println("Please type 1 to continue");
        }

        boolean levelWon = false;

        for (int i = 1; i <= 3; i++) {
            levelWon = gameLevel(i, input, question, player);
            if (!levelWon) {
                break;
            }
        }

        if (levelWon) {
            System.out.println();
            System.out.println("Congrats, " + player.getName() + " you won!");
            System.out.println("Your country thanks you");
        }

        input.close();
    }

    public static boolean gameLevel(int level, Scanner input, Question question, Player player) {
        Enemy npc = new Enemy();

        switch (level) {
            case 1: 
                npc = new KingGeorge(150, "King George III", "Barnacles init, we lost");
                break;
            case 2:
                npc = new VladimirPutin(175, "Vladimir Putin", "We will just spy on you later");
                break;
            case 3:
                npc = new VladimirPutin(200, "Xi Jinping", "The dollar will always be better");
                break;
            }

        System.out.println();
        System.out.println("Level " + level + ": " + npc.getName());
        System.out.println("Type 1 to continue");
        
        String userInput = input.nextLine();
        while (!(userInput.equals("1"))) {
            System.out.println();
            System.out.println("Please type 1 to continue");
        }

        while (npc.getHealth() > 0 && player.getHealth() > 0) {
            question.getQuestion();
        
            System.out.println();
            System.out.println("Choose A, B, or C");
            userInput = input.nextLine();
            while (
                    !(userInput.toLowerCase().equals("a"))
                    && !(userInput.toLowerCase().equals("b"))
                    && !(userInput.toLowerCase().equals("c"))
                ) {
                System.out.println();
                System.out.println("Please enter a valid choice");
                userInput = input.nextLine();
            }

            System.out.println();
            question.checkAnswer(npc, player, userInput);

            System.out.println();
            System.out.println("Type 1 to continue");
            userInput = input.nextLine();
            while (!(userInput.equals("1"))) {
                System.out.println();
                System.out.println("Please type 1 to continue");
            }
        }

        System.out.println();
        if (player.getHealth() < 0) {
            System.out.println(npc.getName() + " has defeated you");
            System.out.println("Better luck next time: " + player.getName());
            return false;
        } else {
            System.out.println("Good job " + player.getName());
            System.out.println("You beat " + npc.getName());
            return true;
        }
    }

}