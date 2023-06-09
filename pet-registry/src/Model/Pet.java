package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Pet {

    private int id;
    private String name;
    private LocalDate birthday;



    private ArrayList<String> commands;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        return formatter.format(birthday);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + getBirthday() +
                '}';
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }
}
