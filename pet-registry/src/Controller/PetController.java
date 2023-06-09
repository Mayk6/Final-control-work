package Controller;

import Model.*;
import View.*;

import java.util.ArrayList;

public class PetController {
    PetStorage storage = new PetStorage();
    View consoleView = new ConlsoeView();

    public void addPet() {
        consoleView.showPetsType();
        Pet pet = null;
        while (true){
            try {
                int choose = consoleView.choose();
                switch (choose) {
                    case 1 -> pet = new Cat();
                    case 2 -> pet = new Dog();
                    case 3 -> pet = new Humster();
                    default -> throw (new NullPointerException());
                }
                break;
            } catch (NullPointerException e) {
                consoleView.invalidInput();
            }
        }
        pet.setName(consoleView.getName());
        teachNewCommand(pet);
        pet.setBirthday(consoleView.enterBirthday());
        System.out.println(pet);
        System.out.println(getCommands(pet));
    }

    public String getCommands(Pet pet) {
        return "Животное " +
                pet.getName() +
                " знает команды: " +
                String.join(" ", pet.getCommands());
    }

    public void teachNewCommand(Pet pet) {
        boolean flag = true;
        while (flag) {
            String command = consoleView.enterCommand();
            ArrayList<String> temp = pet.getCommands();
            if (temp == null) temp = new ArrayList<>();
            temp.add(command);
            pet.setCommands(temp);
            flag = consoleView.anotherOneCommand();
        }
    }
}
