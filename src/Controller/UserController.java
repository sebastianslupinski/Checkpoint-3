package Controller;

import Model.Book;
import View.View;
import Dao.BookDao;

public class UserController {

    private BookDao bookDao;
    private BookController bookController;
    private String HEADER;
    private final String[] OPTIONS = {"Add new book", "Edit Book",
            "?", "?",
            "?",
            "?",
            "Exit"};

    public UserController() {
        this.bookDao = new BookDao();
        this.HEADER = "Choose what you want to do";
    }

    public void run() {
        bookDao.createBookObjects();
        Integer option = 1;

        while (!(option == 7)) {
            View.displayMenu(HEADER, OPTIONS);
            option = View.getNumber("Choose option: ");
            switch (option) {
                case 1:
                    Book newBook = BookController.addNewBook();
                    bookDao.saveNewBookToDatabase(newBook);
                    break;
                case 2:
                    Book bookToEdit = BookController.getBook(bookDao);
                    BookController.editBook(bookToEdit, bookDao);
                case 3:
//                    ??
//                    break;
                case 4:
//                    ??
//                    break;
                case 5:
//                    ??
//                    break;
                case 6:
//                    ??
//                    ??
//                    break;
                case 7:
                    bookDao.closeConnection();
                    View.displayText("Good bye");
                    break;
            }
        }
    }
}
