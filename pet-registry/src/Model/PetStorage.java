package Model;

import java.util.ArrayList;

public class PetStorage {
    private ArrayList<Pet> storage;

    public void addPet(Pet pet) {
        storage.add(pet);
    }

    public void deletePet(Pet pet) {
        storage.remove(pet);
    }
}
