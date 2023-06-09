import Controller.PetController;
import Model.Cat;
import Model.Pet;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        PetController controller = new PetController();
        controller.addPet();

    }
}