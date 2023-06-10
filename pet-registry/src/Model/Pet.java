package Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public abstract class Pet {

    private static int ID;
    private Integer id;
    private String name;
    private LocalDate birthday;

    Pet() {
        id = ID;
        ID++;
    }

    private ArrayList<String> commands;

    public Integer getId() {
        return id;
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
        return this.getType() +
                " id=" + id +
                ", Имя: '" + name + '\'' +
                ", Дата рождения: " + getBirthday() +
                '}';
    }

    public ArrayList<String> getCommands() {
        return commands;
    }

    public void setCommands(ArrayList<String> commands) {
        this.commands = commands;
    }

    public String getType() {
        int temp = this.getClass().toString().lastIndexOf(".");
        return this.getClass().toString().substring(temp + 1);
    }
}
