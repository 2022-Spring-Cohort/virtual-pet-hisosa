package virtual_pet;

public class MechaPet extends VirtualPet {
    protected int oilLevel;
    protected int batteryLevel;
    protected int corruption;

    public MechaPet(String name, String description, String age) {
        super(name, description, age);
        this.oilLevel = 5;
        this.batteryLevel = 5;
        this.corruption = 15;
    }

    public int getOilLevel() {
        return oilLevel;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public int getCorruption() {
        return corruption;
    }

    public void giveOil() {
        oilLevel+=5;
    }

    public void chargeBattery() {
        batteryLevel+=5;
    }

    public void cleanseCorruption() {
        corruption-=10;
    }

    @Override
    public void play() {
        corruption -= 10;
        batteryLevel--;
        oilLevel--;
    }

    @Override
    public void tick() {
        oilLevel--;
        batteryLevel--;
        corruption++;
    }
    @Override
    public void unTick(){
        oilLevel++;
        batteryLevel++;
        corruption--;
    }

    @Override
    public boolean arePetsHealthy() {
        return oilLevel > 0 && batteryLevel > 0 && corruption < 20;
    }
}
