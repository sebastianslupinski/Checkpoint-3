import Model.Book;
import Dao.BookDao;

public class Application {

    public static void main(String[] args){
        BookDao bookDao = new BookDao();
        bookDao.createBookObjects();
        System.out.println(bookDao.books);
    }
}
