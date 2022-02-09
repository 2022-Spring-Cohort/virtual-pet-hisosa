package virtual_pet;

public class MechaPetDog extends MechaPet implements WalkRobot {

    protected String robotWoof;

    public MechaPetDog(String name, String description, String age) {
        super(name, description, age);
        this.robotWoof = robotWoof;
    }

    public String getRobotWoof() {
        return robotWoof;
    }

    @Override
    public void walkPet() {
        oilLevel -= 5;
        batteryLevel -= 5;
        corruption += 5;
    }
}
