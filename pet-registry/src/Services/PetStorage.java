package Services;

import Model.Pet;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PetStorage {

    private ArrayList<Pet> storage;

    public PetStorage() {
        storage = new ArrayList<>();
    }

    public Pet findByName(String name) {
        Pet pet = null;
        try {
            pet = storage.stream().filter(x -> x.getName().equals(name)).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return pet;
    }

    public Pet findById(int id) {
        Pet pet = null;
        try {
            pet = storage.stream().filter(x -> x.getId().equals(id)).findFirst().get();
        } catch (NoSuchElementException e) {
            return null;
        }
        return pet;
    }

    public void addPet(Pet pet) {
        storage.add(pet);
    }

    public void deletePet(Pet pet) {
        storage.remove(pet);
    }

    public ArrayList<Pet> getAllPets() {
        return storage;
    }
}
