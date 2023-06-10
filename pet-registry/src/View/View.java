package View;

import java.time.LocalDate;

public interface View {

    public void mainMenu();

    public void showPetsType();

    public String enterCommand();

    public void showMessage(String message);

    public void invalidInput();

    public int choose();

    public String getText();

    public String getName();

    public boolean anotherOneCommand(String text);

    public LocalDate enterBirthday();

    public void findType();

    public void petNotFound();

}
