package virtual_pet;

import java.util.Scanner;

public class VirtualPetApp {
    static VirtualPetShelter virtualPetShelter = new VirtualPetShelter();

    public static void main(String[] args) {
        gameIntro();
        showAllPets();
        gameLoop();
    }

    public static void gameIntro() {
        System.out.println("\nWelcome to the Kaiju Pet Shelter App. \nYou are in charge of very dangerous pets." +
                "\nBe careful not to let your pet's needs exceed \ntheir limits and do not go overboard on their care." +
                "\n");
        virtualPetShelter.addInitialPets();
    }

    public static void showAllPets() {
        System.out.println("Here are all the pets currently in the Kaiju Shelter.\n");
        virtualPetShelter.getAllPets();
    }

    public static Integer playerChoice() {
        System.out.println("\nWhat would you like to do? \nPlease choose from the following:\n");
        System.out.println("1 - Give food to all the pets in shelter."+
                "\n2 - Give water to all the pets in shelter."+
                "\n3 - Give all pets in shelter some rest."+
                "\n4 - Have pets in shelter chill out."+
                "\n5 - Play with an individual pet from shelter."+
                "\n6 - Place a new pet in the shelter."+
                "\n7 - Adopt a pet from the shelter."+
                "\n8 - View list of all pets in shelter."+
                "\n9 - Exit the shelter.");
        System.out.println("0 - Help.");

        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        return playerChoice;
    }

    public static void choiceSelected(Integer playerChoice) {
        if (playerChoice.equals(1)) {
            virtualPetShelter.feedAllPets();
        } else if (playerChoice.equals(2)) {
            virtualPetShelter.waterAllPets();
        } else if (playerChoice.equals(3)) {
            virtualPetShelter.restAllPets();
        } else if (playerChoice.equals(4)) {
            virtualPetShelter.chillOutPets();
        } else if (playerChoice.equals(5)) {
            System.out.println("Which pet would you like to play with?");
            String petToPlayWith = whichPetToPlay();
            virtualPetShelter.playWithOnePet(petToPlayWith);
            System.out.println("You have selected to play with " + petToPlayWith);
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(6)) {
            VirtualPet petToBeAdded = inputPetInfo();
            virtualPetShelter.addPet(petToBeAdded);
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(7)) {
            System.out.println("Which pet would you like to adopt?");
            String petToAdopt = whichPetToPlay();
            virtualPetShelter.removePet(petToAdopt);
            System.out.println(petToAdopt + " has been adopted!");
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(8)) {
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(9)) {
            System.out.println("Thank you for playing.\n\nGOODBYE.");
            System.exit(0);
        } else if (playerChoice.equals(0)) {
            gameIntro();
            virtualPetShelter.unTickAllPets();
        }
        virtualPetShelter.tickAllPets();
    }

    public static String whichPetToPlay() {
        virtualPetShelter.getAllPets();
        Scanner scanner = new Scanner(System.in);
        String playerSelection = scanner.nextLine();
        return playerSelection;
    }

    public static VirtualPet inputPetInfo() {
        System.out.println("What is the name of the new pet?");
        Scanner scanner = new Scanner(System.in);
        String newPetName = scanner.nextLine();

        System.out.println("What type of animal is it?");
        Scanner scanner1 = new Scanner(System.in);
        String newPetType = scanner.nextLine();

        VirtualPet newPet = new VirtualPet(newPetName, newPetType, 5, 5, 5, 10);
        return newPet;
    }

    public static void gameLoop() {
        while (!virtualPetShelter.checkPetHealth()) {
            Integer playerInput = playerChoice();
            choiceSelected(playerInput);
            System.out.println(" ");
            showAllPets();
        }
        System.out.println("\n\n\t\t\t\t\t\tOne of your pets has escaped! \n\n\t\t\t\t\t\t\t\t--WARNING--" +
                "\n\n\t\t\t\t\t\tYOUR  LIFE  IS  IN  DANGER!");
        virtualPetShelter.dieHuman();
    }
}
