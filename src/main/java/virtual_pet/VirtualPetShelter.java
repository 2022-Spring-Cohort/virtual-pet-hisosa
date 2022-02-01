package virtual_pet;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter {

    private Map<String, VirtualPet> pets = new HashMap<>();

    VirtualPet Gojira = new VirtualPet("Gojira", "Mutant Lizard", 2, 2,5,15);
    VirtualPet Rodan = new VirtualPet("Rodan", "Pterodactyl", 3, 3, 5, 10);
    VirtualPet Mothra = new VirtualPet("Mothra", "Giant Moth", 2,2,2,15);
    VirtualPet Ghidora = new VirtualPet("Ghidora", "Space Hydra", 3, 3, 2, 10);

    public void addInitialPets(){
        pets.put(Gojira.getName(), Gojira);
        pets.put(Ghidora.getName(), Ghidora);
        pets.put(Rodan.getName(), Rodan);
        pets.put(Mothra.getName(), Mothra);
    }

    public void getAllPets(){
        System.out.printf("|%-15s|%-14s|%-8s|%-9s|%-7s|%-7s|","NAME","TYPE"," HUNGRY "," THIRSTY "," TIRED "," CHILL ");
        System.out.println("\n|---------------|--------------|--------|---------|-------|-------|");
        for (Map.Entry<String,VirtualPet>mapEntry: pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            System.out.printf("|%-15s|%-14s|%-8d|%-9d|%-7d|%-7d|\n",pet.getName(),pet.getType(),pet.getHungry(),pet.getThirst(),pet.getTired(),pet.getChill());
        }
    }

    public VirtualPet getPet(String petRequested){
        VirtualPet pet=null;
        for (Map.Entry<String,VirtualPet>mapEntry:pets.entrySet()){
            String petName = mapEntry.getKey();
            if(petRequested.equals(petName)){
                pet=mapEntry.getValue();
            }
        }
        return pet;
    }

    public void addPet(VirtualPet petAdded){
        pets.put(petAdded.getName(),petAdded);
    }

    public void removePet(String removedPet){
        pets.remove(removedPet);
    }

    public void playWithOnePet(String petRequested){
        VirtualPet pet = getPet(petRequested);
        pet.playWithPet();
    }

    public void feedAllPets(){
        for (Map.Entry<String,VirtualPet> mapEntry : pets.entrySet()){
            VirtualPet pet=mapEntry.getValue();
            pet.giveFood();
        }
    }

    public void waterAllPets(){
        for (Map.Entry<String,VirtualPet> mapEntry:pets.entrySet()){
            VirtualPet pet=mapEntry.getValue();
            pet.giveWater();
        }
    }

    public void restAllPets(){
        for (Map.Entry<String,VirtualPet> mapEntry:pets.entrySet()){
            VirtualPet pet=mapEntry.getValue();
            pet.giveRest();
        }
    }


    public void chillOutPets(){
        for (Map.Entry<String,VirtualPet>mapEntry:pets.entrySet()){
            VirtualPet pet=mapEntry.getValue();
            pet.giveChill();
        }
    }

    public void tickAllPets(){
        for (Map.Entry<String,VirtualPet>mapEntry:pets.entrySet()){
            VirtualPet pet = mapEntry.getValue();
            pet.tick();
        }
    }
    public void unTickAllPets(){
        for (Map.Entry<String,VirtualPet>mapEntry:pets.entrySet()){
            VirtualPet pet = mapEntry.getValue();
            pet.unTick();
        }
    }

    protected boolean checkPetHealth(){
        boolean checkPetHealth = true;
        for (Map.Entry<String,VirtualPet>mapEntry:pets.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            if (pet.arePetsHealthy()) {
                checkPetHealth = false;
                break;
            }
        }
        return checkPetHealth;
    }
    public void dieHuman (){
        System.out.println("         .                                                      ."+
                "\n        .n                   .                 .                  n."+
                "\n  .   .dP                  dP                   9b                 9b.    ."+
                "\n 4    qXb         .       dX                     Xb       .        dXp     t"+
                "\ndX.    9Xb      .dXb    __                         __    dXb.     dXP     .Xb"+
                "\n9XXb._       _.dXXXXb dXXXXbo.                 .odXXXXb dXXXXb._       _.dXXP"+
                "\n 9XXXXXXXXXXXXXXXXXXXVXXXXXXXXOo.           .oOXXXXXXXXVXXXXXXXXXXXXXXXXXXXP"+
                "\n  `9XXXXXXXXXXXXXXXXXXXXX'~   ~`OOO8b   d8OOO'~   ~`XXXXXXXXXXXXXXXXXXXXXP'"+
                "\n    `9XXXXXXXXXXXP' `9XX'   DIE    `98v8P'  HUMAN   `XXP' `9XXXXXXXXXXXP'"+
                "\n        ~~~~~~~       9X.          .db|db.          .XP       ~~~~~~~"+
                "\n                        )b.  .dbo.dP'`v'`9b.odb.  .dX("+
                "\n                      ,dXXXXXXXXXXXb     dXXXXXXXXXXXb."+
                "\n                     dXXXXXXXXXXXP'   .   `9XXXXXXXXXXXb"+
                "\n                    dXXXXXXXXXXXXb   d|b   dXXXXXXXXXXXXb"+
                "\n                    9XXb'   `XXXXXb.dX|Xb.dXXXXX'   `dXXP"+
                "\n                     `'      9XXXXXX(   )XXXXXXP      `'"+
                "\n                              XXXX X.`v'.X XXXX"+
                "\n                              XP^X'`b   d'`X^XX"+
                "\n                              X. 9  `   '  P )X"+
                "\n                              `b  `       '  d'"+
                "\n                               `             '");
    }

}
