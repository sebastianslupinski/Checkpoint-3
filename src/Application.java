import Controller.UserController;
import Model.Book;
import Dao.BookDao;

public class Application {

    public static void main(String[] args){
        UserController controller = new UserController();
        controller.run();
    }
}
