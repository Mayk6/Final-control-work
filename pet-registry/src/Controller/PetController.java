package Controller;

import Model.*;
import Services.PetCounter;
import Services.PetStorage;
import View.*;

import java.util.ArrayList;

public class PetController {
    PetStorage storage = new PetStorage();
    View consoleView = new ConlsoeView();

    public void run() {
        while (true) {
            try {
                consoleView.mainMenu();
                switch (consoleView.choose()) {
                    case 1 -> addPet();
                    case 2 -> System.out.println(getCommands(findPet()));
                    case 3 -> teachNewCommand(findPet());
                    case 0 -> System.exit(0);
                }
            } catch (NullPointerException e) {
                consoleView.petNotFound();
            }
        }

    }

    public void addPet() {
        try (PetCounter counter = new PetCounter()) {
            consoleView.showPetsType();
            Pet pet = null;
            while (true) {
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
            storage.addPet(pet);
            counter.add();
        }

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

    public Pet findPet() {
        Pet pet = null;
        boolean flag = true;
        consoleView.findType();
        while (flag) {
            flag = false;
            switch (consoleView.choose()) {
                case 1 -> pet = storage.findById(consoleView.choose());
                case 2 -> pet = storage.findByName(consoleView.getName());
                default -> {
                    consoleView.invalidInput();
                    flag = true;
                }
            }
        }
        return pet;
    }
}
