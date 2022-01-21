package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
    private static final VirtualPet mutantLizard = new VirtualPet("Gawd Zilla", "Red", 10, 10, 10, 10);

    public static void main(String[] args) throws InterruptedException {
        //Interact with a VirtualPet object in this method
        System.out.println(" ");
        System.out.println("Welcome to the Virtual Pet Game! Please take good care of your pet!");
        System.out.println(" ");
        displayObjective();

        while (variableLimit()) {
            Scanner scanner1 = new Scanner(System.in);
            int playerSelect = Integer.parseInt(scanner1.next());

            if (playerSelect == 1) {
                mutantLizard.giveFood();
                System.out.println("nom nom nom\n");
            } else if (playerSelect == 2) {
                mutantLizard.giveWater();
                System.out.println("slurp slurp slurp\n");
            } else if (playerSelect == 3) {
                mutantLizard.giveRest();
                System.out.println("zzz zzz zzz\n");
            } else if (playerSelect == 4) {
                mutantLizard.givechill();
                System.out.println("");
            } else if (playerSelect == 5) {
                System.out.println("\nIt's okay to take a break.\nJust keep an eye on your pet!\n");
            }
            if (playerSelect == 6) {
                System.out.println("Thank you for playing the Virtual Pet Game. Goodbye.");
                break;
            }
            if (playerSelect == 9) {
                mutantLizard.tick9();
            }
            if (playerSelect == 0) {
                printInstructions();
            }
            if (playerSelect != 0) {
                mutantLizard.tick();
                currentStatus();
            }
            System.out.println("What do we do now?");
        }
        Thread.sleep(10000);
        System.out.println("OH NO!! Gawd Zilla is headed to destroy the city!");

    }

    private static void displayObjective() {
        System.out.println("Objective: Using the commands below, try to keep Gawd Zilla happy, fed and well rested.");
        System.out.println("If his needs are not met, Gawd Zilla will become very angry destroy the city!!");
        System.out.println("You can stop the destruction of the city by keeping his needs under their limits! (0-20).");
        System.out.println("Please be sure not to overdo Gawd Zilla's care...Good Luck!");
        System.out.println(" ");
        System.out.println("This is his current status:");
        currentStatus();
        System.out.println(" ");
        printInstructions();
    }

    private static void currentStatus() {
        System.out.println("Gawd Zilla's current hunger level is " + mutantLizard.getHungry());
        System.out.println("Gawd Zilla's current thirst level is " + mutantLizard.getThirst());
        System.out.println("Gawd Zilla's current tired level is " + mutantLizard.getTired());


    }

    private static void printInstructions() {
        System.out.println("1 - To give Gawd Zilla some food.");
        System.out.println("2 - To give Gawd Zilla some water.");
        System.out.println("3 - To give Gawd Zilla some rest");
        System.out.println("4 - To watch movies and chill.");
        System.out.println("5 - To do nothing at this time.");
        System.out.println("6 - To quit the game.");
        System.out.println("----------------------------------------");
        System.out.println("9 - To display pet's current status.");
        System.out.println("0 - To show the instructions.");
        System.out.println("  -Please make a selection.-");
    }

    private static boolean variableLimit() {
        return mutantLizard.getHungry() < 20 && mutantLizard.getThirst() < 20 && mutantLizard.getTired() < 20 && mutantLizard.getHungry() > 0 && mutantLizard.getThirst() > 0 && mutantLizard.getTired() > 0;
    }
}
