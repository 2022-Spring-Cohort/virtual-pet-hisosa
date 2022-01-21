package virtual_pet;

public class VirtualPet {

    private String name;
    private String colorScales;
    private int thirst;
    private int tired;
    private int hungry;
    private int chill;

    public VirtualPet(String name, String colorScales, int thirst, int tired, int hungry, int chill) {
        this.name = name;
        this.colorScales = colorScales;
        this.thirst = thirst;
        this.tired = tired;
        this.hungry = hungry;
        this.chill = chill;
    }


    public String getName() {
        return name;
    }

    public String getColorScales() {
        return colorScales;
    }

    public int getThirst() {
        return thirst;
    }

    public int getTired() {
        return tired;
    }

    public int getHungry() {
        return hungry;
    }

    public int getChill() {
        return chill;
    }

    public void tick() {
        hungry++;
        thirst++;
        tired++;
    }

    public void tick9() {
        hungry--;
        thirst--;
        tired--;
    }


    public void giveFood() {
        hungry = hungry - 4;
        tired++;
        thirst++;
    }

    public void giveRest() {
        tired = tired - 3;
        thirst++;
        hungry++;
    }

    public void giveWater() {
        thirst = thirst - 4;
        tired++;
        hungry++;
    }

    public void givechill() {
        tired = tired - 2;
        hungry++;
        thirst++;
    }

}
