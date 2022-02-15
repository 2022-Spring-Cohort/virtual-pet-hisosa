package virtual_pet;

public class OrganicPetCat extends OrganicPet {

    protected String catPurr;

    public OrganicPetCat(String name, String description, String age) {
        super(name, description, age);
        this.catPurr = catPurr;
    }

    public String getCatPurr() {
        return catPurr;
    }
}
