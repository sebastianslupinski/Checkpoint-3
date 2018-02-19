package View;

import Model.Book;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

    public static String getString(String message) {
        String input = null;
            Scanner scanner = new Scanner(System.in);
            System.out.println(message);
            input = scanner.nextLine();
        return input;
    }

    public static void displayMenu(String header, String[] options) {
        int optionNumber = 1;
        displayText(header);

        for (String option : options) {
            displayText(optionNumber + "--->" + option);
            optionNumber ++;
        }
    }

    public static Integer getNumber(String message) {
        Boolean notDone = true;
        Integer output = 0;
        while (notDone) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(message);
                output = scanner.nextInt();
                notDone = false;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input! Must be '123' format");
            }
        }
        return output;
    }

    public static void displayListOfBooks(ArrayList<Book> books){
        int index = 0;
        for (Book book : books) {
            View.displayText(index + "--->" + book.toString());
            index++;
        }
    }

    public static void displayText(String text) {
        System.out.println(text);
    }
    public static void displayInteger(int text) {
        System.out.println(text);
    }
}
