package virtual_pet;

import java.util.HashMap;
import java.util.Map;

public class VirtualPetShelter{

    private final Map<String, VirtualPet> petMap = new HashMap<>();
        VirtualPet Sirloin = new OrganicPetDog("Sirloin", "Bulldog", "5");
        VirtualPet Chevy = new MechaPetDog("Chevy", "Mecha-Bulldog", "1");
        VirtualPet Tuna = new OrganicPetCat("Tuna", "Gray Cat", "7");
        VirtualPet Spatula = new MechaPetCat("Spatula", "Silver Cat", "1");


    public void addInitialPets(){
        petMap.put(Sirloin.getName(), Sirloin);
        petMap.put(Chevy.getName(), Chevy);
        petMap.put(Tuna.getName(), Tuna);
        petMap.put(Spatula.getName(), Spatula);
    }
    public void addPet(VirtualPet petAdded){
        petMap.put(petAdded.getName(),petAdded);
    }
    public void removePet(String petToRemove){
        petMap.remove(petToRemove);
    }
    public void getAllPets(){
        System.out.printf("|%-15s|%-15s|%-5s|%-9s|%-9s|%-7s|","NAME","TYPE"," AGE "," HUNGER "," THIRST "," CALM ");
        System.out.println("\n|---------------+---------------+-----+---------+---------+-------|");
        for (Map.Entry<String, VirtualPet> mapEntry: petMap.entrySet()) {
            VirtualPet organicPet = mapEntry.getValue();
            if (organicPet instanceof OrganicPet){
                System.out.printf("|%-15s|%-15s|%-5s|%-9d|%-9d|%-7d|\n", organicPet.getName(), organicPet.getDescription(), organicPet.getAge(), ((OrganicPet) organicPet).getHungry(),((OrganicPet) organicPet).getThirsty(),((OrganicPet) organicPet).getCalm());
            }
        }
        System.out.printf("\n|%-15s|%-15s|%-5s|%-5s|%-9s|%-10s|","NAME","TYPE"," AGE "," OIL "," BATTERY","CORRUPTION");
        System.out.println("\n|---------------+---------------+-----+-----+---------+----------|");
        for (Map.Entry<String,VirtualPet>mapEntry: petMap.entrySet()) {
            VirtualPet mechaPet = mapEntry.getValue();
            if (mechaPet instanceof MechaPet) {
                System.out.printf("|%-15s|%-15s|%-5s|%-5d|%-9d|%-10d|\n",mechaPet.getName(),mechaPet.getDescription(),mechaPet.getAge(),((MechaPet) mechaPet).getOilLevel(),((MechaPet) mechaPet).getBatteryLevel(),((MechaPet) mechaPet).getCorruption());
            }
        }
    }
    public void playWithOnePet(String requestedPet){
        VirtualPet pet = getVirtualPet(requestedPet);
        pet.play();
    }
    public VirtualPet getVirtualPet(String requestedPet){
        VirtualPet pet=null;
        for (Map.Entry<String,VirtualPet>mapEntry:petMap.entrySet()){
            String petName = mapEntry.getKey();
            if(requestedPet.equals(petName)){
                pet=mapEntry.getValue();
            }
        }
        return pet;
    }
    public void feedAllOrganicPets(){
        for (Map.Entry<String,VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet organicPet = mapEntry.getValue();
            if (organicPet instanceof OrganicPet){
                ((OrganicPet) organicPet).giveFood();
            }
        }
    }
    public void chargeAllPets(){
        for (Map.Entry<String, VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet mechaPet = mapEntry.getValue();
            if (mechaPet instanceof MechaPet){
                ((MechaPet) mechaPet).chargeBattery();
            }
        }
    }
    public void waterAllPets(){
        for (Map.Entry<String,VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet organicPet = mapEntry.getValue();
            if (organicPet instanceof OrganicPet){
                ((OrganicPet) organicPet).giveWater();
            }
        }
    }
    public void oilAllPets(){
        for (Map.Entry<String, VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet mechaPet = mapEntry.getValue();
            if (mechaPet instanceof MechaPet){
                ((MechaPet) mechaPet).giveOil();
            }
        }
    }
    public void calmPetsDown(){
        for (Map.Entry<String,VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet organicPet = mapEntry.getValue();
            if (organicPet instanceof OrganicPet){
                ((OrganicPet) organicPet).calmDown();
            }
        }
    }
    public void deleteErrors(){
        for (Map.Entry<String, VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet mechaPet = mapEntry.getValue();
            if (mechaPet instanceof MechaPet){
                ((MechaPet) mechaPet).cleanseCorruption();
            }
        }
    }
    public void tickAllPets(){
        for (Map.Entry<String,VirtualPet>mapEntry:petMap.entrySet()){
            VirtualPet pet = mapEntry.getValue();
            if (pet instanceof OrganicPet){
                pet.tick();
            }
            if (pet instanceof MechaPet){
                pet.tick();
            }
        }
    }
    public void unTickAllPets(){
        for (Map.Entry<String,VirtualPet>mapEntry:petMap.entrySet()){
            VirtualPet pet= mapEntry.getValue();
            if (pet instanceof OrganicPet) {
                pet.unTick();
            }
            if (pet instanceof MechaPet){
                pet.unTick();
            }
        }
    }
    public void cleanAll(){
        for(Map.Entry<String,VirtualPet>mapEntry:petMap.entrySet()) {
            VirtualPet pet = mapEntry.getValue();
            if (pet instanceof OrganicPet) {
                ((OrganicPet) pet).cleanCage();
            }
        }
    }
    public boolean arePetsHealthy() {
        boolean arePetsHealthy = true;
        for (Map.Entry<String, VirtualPet> mapEntry : petMap.entrySet()){
            VirtualPet pet = mapEntry.getValue();
            if (pet instanceof OrganicPet) {
                if (pet.arePetsHealthy()){
                    arePetsHealthy = false;
                }
            }
            if (pet instanceof MechaPet){
                if (pet.arePetsHealthy()){
                    arePetsHealthy = false;
                }
            }
        }return arePetsHealthy;
    }
}
