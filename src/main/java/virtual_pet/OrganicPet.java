package virtual_pet;

public class OrganicPet extends VirtualPet {
    protected int hungry;
    protected int thirsty;
    protected int calm;
    protected int cleanLevel;

    public OrganicPet(String name, String description, String age) {
        super(name, description, age);
        this.hungry = 15;
        this.thirsty = 15;
        this.calm = 5;
        this.cleanLevel = 20;
    }

    public int getHungry() {
        return hungry;
    }

    public int getThirsty() {
        return thirsty;
    }

    public int getCalm() {
        return calm;
    }

    public int getCleanLevel() {
        return cleanLevel;
    }

    public void giveFood() {
        hungry -= 3;
    }

    public void giveWater() {
        thirsty -= 3;
    }

    public void calmDown() {
        calm += 7;
    }

    public void cleanCage() {
        cleanLevel -= 5;
    }

    public boolean isClean() {
        return cleanLevel <= 20;
    }
    public boolean isDirty() {
        if (cleanLevel <= 10 ){
            return true;}
        return false;
    }

    @Override
    public void tick() {
        hungry++;
        thirsty++;
        calm--;
    }
    @Override
    public void unTick(){
        hungry--;
        thirsty--;
        calm++;
    }

    @Override
    public void play() {
        hungry++;
        thirsty++;
        calm += 10;
    }

    @Override
    public boolean arePetsHealthy() {
        return hungry < 20 && thirsty < 20 && calm > 0;
    }
}
