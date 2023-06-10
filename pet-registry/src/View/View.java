package View;

import java.time.LocalDate;
import java.util.ArrayList;

public interface View {

    public void mainMenu();

    public void showPetsType();

    public String enterCommand();

    public void deleteCommand(String command);

    public void showMessage(String message);

    public void invalidInput();

    public int choose();

    public String getText();

    public String getName();

    public boolean anotherOneCommand();

    public LocalDate enterBirthday();

    public void findType();

    public void petNotFound();
}
