package Controller;

import Model.Book;
import View.View;

public class BookController {

    public static Book addNewBook(){
        Book newBook = null;
        String ISBN = View.getString("Please enter book ISBN: ");
        String authorId = View.getString("Please enter author id : ");
        String title = View.getString("Please enter book title: ");
        String publisher = View.getString("Please enter book publisher: ");
        String publicationYear = View.getString("Please enter book publication year: ");
        String price = View.getString("Please enter book price: ");
        String type = View.getString("Please enter book typeId: ");
        newBook = new Book(ISBN, authorId, title, publisher, publicationYear, price, type);
        return newBook;
    }

    public static
}
