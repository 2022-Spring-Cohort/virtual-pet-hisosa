package virtual_pet;

public class MechaPetCat extends MechaPet {

    protected String robotMeow;

    public MechaPetCat(String name, String description, String age) {
        super(name, description, age);
        this.robotMeow = robotMeow;
    }

    public String getRobotMeow() {
        return robotMeow;
    }
}
