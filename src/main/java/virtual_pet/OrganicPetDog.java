package virtual_pet;

public class OrganicPetDog extends OrganicPet implements Walkable {
    public OrganicPetDog(String name, String description, String age) {
        super(name, description, age);
    }

    @Override
    public void walk() {
        hungry++;
        thirsty++;
        calm += 5;
        cleanLevel -= 5;
    }
}
