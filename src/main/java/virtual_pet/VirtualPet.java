package virtual_pet;

public abstract class VirtualPet {
    protected String name;
    protected String description;
    protected String age;

    public VirtualPet(String name, String description, String age) {
        this.name = name;
        this.description = description;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getAge() {return age;}

    public abstract void tick();

    public abstract void unTick();

    public abstract void play();

    public abstract boolean arePetsHealthy();
}
