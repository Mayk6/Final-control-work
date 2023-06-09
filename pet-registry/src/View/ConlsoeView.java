package View;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConlsoeView implements View {

    private final Scanner scanner = new Scanner(System.in);

    public void mainMenu() {
        System.out.println();
        System.out.println(
                """
                        1 - Добавить новое животное\s
                        2 - Просмотр команд животного\s
                        3 - Обучить животное новой команде\s
                        0 - Выход""");
    }

    public void showPetsType() {
        System.out.println();
        System.out.println(
                """
                        Выберите тип животного:
                        1 - Кошка\s
                        2 - Собака\s
                        3 - Хомяк""");
    }

    public String enterCommand() {
        System.out.print("Введите команду: ");
        return scanner.next();
    }

    public void deleteCommand(String command) {
        System.out.println("Команда " + command + "успешно удалена");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void invalidInput() {
        System.out.println("Введена неверная команда, повторите ввод.");
    }

    public void invalidFormat() {
        System.out.println("Неверный формат ввода, повторите.");
    }


    public int choose() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ввод: ");
            int choose = scanner.nextInt();
            return choose;

        } catch (InputMismatchException e) {
            invalidFormat();
            return choose();
        }

    }

    public String getText() {
        return scanner.next();
    }

    public String getName() {
        System.out.print("Введите имя животного: ");
        return getText();
    }

    public boolean anotherOneCommand() {
        boolean flag = false;
        System.out.println("Желатете добавить еще команду?");
        System.out.println(
                """
                        1 - Да\s
                        2 - Нет""");

        while (true) {
            int choose = choose();
            if (choose == 1) {
                return true;
            } else if (choose == 2) {
                return  false;
            }
            else {
                invalidInput();
            }
        }
    }

    public LocalDate enterBirthday() {
        LocalDate tempDate = null;
        System.out.println("Введите дату в формате гггг-мм-дд");
        while (true) {
            try {
                tempDate = LocalDate.parse(getText());
                break;
            } catch (DateTimeParseException e) {
                invalidFormat();
            }
        }
        return tempDate;
    }
}
