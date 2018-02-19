package Controller;

import Model.Book;
import View.View;
import Dao.BookDao;

public class UserController {

    private BookDao bookDao;
    private BookController bookController;
    private String HEADER = "Choose what you want to do";
    private final String[] OPTIONS = {"Add new book", "?",
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
//                    this.createMentor(admin, loginDB);
//                    break;
                case 3:
//                    this.editMentor(admin, adminDB);
//                    break;
                case 4:
//                    this.assignMentorToGroup(admin, loginDB, adminDB, connection);
//                    break;
                case 5:
//                    this.displayMentorsGroup(connection, admin, studentDB);
//                    break;
                case 6:
//                    this.editAdminInfo(admin);
//                    adminDB.exportAdmin(connection, admin);
//                    break;
                case 7:
                    bookDao.closeConnection();
                    View.displayText("Good bye");
                    break;
            }
        }
    }
}
