package virtual_pet;

public class VirtualPet {

    private String name;
    private String type;
    private int hungry;
    private int thirst;
    private int tired;
    private int chill;

    public VirtualPet(String name, String color, int hungry, int thirst, int tired, int chill) {
        this.name = name;
        this.type = color;
        this.hungry = hungry;
        this.thirst = thirst;
        this.tired = tired;
        this.chill = chill;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public int getHungry() {
        return hungry;
    }
    public int getThirst() {
        return thirst;
    }
    public int getTired() {
        return tired;
    }
    public int getChill() {
        return chill;
    }

    public void giveFood() {
        hungry -= 4;
        thirst++;
        tired++;
        chill--;
    }
    public void giveWater() {
        thirst -= 3;
        hungry++;
        tired++;
        chill--;
    }
    public void giveRest() {
        tired -= 5;
        thirst++;
        hungry++;
        chill++;
    }
    public void giveChill() {
        tired -= 2;
        chill += 7;
        hungry++;
        thirst++;
    }
    public void playWithPet() {
        chill += 5;
        tired++;
        hungry++;
        thirst++;
    }
    public void tick() {
        hungry++;
        thirst++;
        tired++;
        chill--;
    }
    public void unTick() {
        hungry--;
        thirst--;
        tired--;
        chill++;
    }

    protected boolean arePetsHealthy() {
        return getHungry() < 30 && getThirst() < 30 && getTired() < 30 && getChill()>0;
    }
}
