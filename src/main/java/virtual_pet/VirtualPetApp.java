package virtual_pet;

import java.util.Map;
import java.util.Scanner;

public class VirtualPetApp {
    static VirtualPetShelter virtualPetShelter = new VirtualPetShelter();

    public static void main(String[] args) {
        gameIntro();
        showAllPets();
        gameLoop();
    }

    public static void gameIntro() {
        System.out.println("\nWelcome to the Pet Shelter App. You are in charge of very interesting pets." +
                "\nBe careful not to let your pet's needs exceed their limits and do not go overboard on their care." +
                "\n\nGood Luck!!\n");
        virtualPetShelter.addInitialPets();
    }

    public static void showAllPets() {
        System.out.println("Here are all the pets currently in the Shelter.\n");
        virtualPetShelter.getAllPets();
    }

    public static Integer playerChoice() {
        System.out.println("\nWhat would you like to do? \nPlease choose from the following:\n");
        System.out.println("1 - Give food to all the pets in shelter."+
                "\n2 - Give water to all the pets in shelter."+
                "\n3 - Play sounds of destruction for pets to calm down."+
                "\n4 - Charge batteries of pets."+
                "\n5 - Give pets an oil change."+
                "\n6 - Erase Corruption from pets."+
                "\n7 - Adopt a pet from the shelter."+
                "\n8 - Add a pet into the shelter."+
                "\n9 - Play with one pet."+
                "\n10 - Clean the cages."+
                "\n11 - View all pets in shelter."+
                "\n99 - Exit the shelter.");
        System.out.println("0 - Help.");

        Scanner scanner = new Scanner(System.in);
        int playerChoice = scanner.nextInt();
        return playerChoice;
    }

    public static void choiceSelected(Integer playerChoice) {
        if (playerChoice.equals(1)) {
            virtualPetShelter.feedAllOrganicPets();
        } else if (playerChoice.equals(2)) {
            virtualPetShelter.waterAllPets();
        } else if (playerChoice.equals(3)) {
            virtualPetShelter.calmPetsDown();
        } else if (playerChoice.equals(4)) {
            virtualPetShelter.chargeAllPets();
        }else if (playerChoice.equals(5)) {
            virtualPetShelter.oilAllPets();
        }else if (playerChoice.equals(6)) {
            virtualPetShelter.deleteErrors();
        } else if (playerChoice.equals(7)) {
            System.out.println("Which pet would you like to adopt?");
            String petToAdopt = whichPetToPlay();
            System.out.println(petToAdopt+" has been adopted.");
            virtualPetShelter.removePet(petToAdopt);
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(8)) {
            VirtualPet petToBeAdded = inputPetInfo();
            virtualPetShelter.addPet(petToBeAdded);
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(9)) {
            System.out.println("Which pet would you like to play with?");
            String petToPlayWith = whichPetToPlay();
            virtualPetShelter.playWithOnePet(petToPlayWith);
            System.out.println("You played with " + petToPlayWith);
            virtualPetShelter.unTickAllPets();
        }else if (playerChoice.equals(10)) {
            virtualPetShelter.cleanAll();
        }else if (playerChoice.equals(11)){
            virtualPetShelter.unTickAllPets();
        } else if (playerChoice.equals(99)) {
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
       Scanner input = new Scanner(System.in);
       String newPetName;
       String newPetDescription;
       String newPetAge;
       String newPetSpecies;

       System.out.println("Would you like to add an Organic or Mechanical Pet?");
       newPetSpecies = input.nextLine();

       if (newPetSpecies.equalsIgnoreCase("organic")){
           OrganicPet newPet = new OrganicPet("","","");
           System.out.println("What is this pet's name?");
           newPetName = input.nextLine();
           System.out.println("Please use 1 word to describe this pet.");
           newPetDescription = input.nextLine();
           System.out.println("How old is this pet?");
           newPetAge = input.nextLine();
           newPet = new OrganicPet(newPetName,newPetDescription,newPetAge);
           return newPet;
       }
        if (newPetSpecies.equalsIgnoreCase("mechanical")){
            MechaPet newPet = new MechaPet("","","");
            System.out.println("What is this pet's name?");
            newPetName = input.nextLine();
            System.out.println("Please use 1 word to describe this pet.");
            newPetDescription = input.nextLine();
            System.out.println("How old is this pet?");
            newPetAge = input.nextLine();
            newPet = new MechaPet(newPetName,newPetDescription,newPetAge);
            return newPet;
        }
        showAllPets();
        return null;
    }
    public static void gameLoop() {
        while (!virtualPetShelter.arePetsHealthy()) {
            Integer playerInput = playerChoice();
            choiceSelected(playerInput);
            System.out.println(" ");
            showAllPets();
        }
        System.out.println("\n\n\t\t\t\t\t\tOne of your pets has escaped! \n\n\t\t\t\t\t\t\t\t--WARNING--" +
                "\n\n\t\t\t\t\t\t\tGAME OVER!");
    }
}
