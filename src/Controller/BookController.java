package Controller;

import Dao.BookDao;
import Model.Book;
import View.View;

public class BookController {

    private static String HEADER2 = "Choose what attribute you want to edit";
    private static final String[] OPTIONS2 = {"Author ID", "Title", "Publisher",
            "Publication Year", "Price", "Type"};

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

    public static Book getBook(BookDao bookDao){
            boolean bookNotChosen = true;
            Integer bookIndex = 0;
            while(bookNotChosen){
                View.displayListOfBooks(bookDao.getBooks());
                bookIndex = View.getNumber("Please enter a book number");
                if (bookIndex < bookDao.getBooks().size()){
                    bookNotChosen = false;
                }
                else {
                    View.displayText("Wrong number");
                }
            }
            return bookDao.getBooks().get(Integer.valueOf(bookIndex));
        }

    public static void editBook(Book book, BookDao bookDao) {
        String ISBN = book.getISBN();
        boolean optionChosen = false;
        while(!optionChosen) {
            Book bookToEdit = getBook(bookDao);
            View.displayMenu(HEADER2, OPTIONS2);
            Integer option = View.getNumber("Enter your option");
            switch (option) {
                case 1:
                    String newAuthorId = View.getString("Enter new author Id");
                    bookToEdit.setAuthorId(newAuthorId);
                    bookDao.updateBook("author", newAuthorId, ISBN);
                    optionChosen = true;
                    break;
                case 2:
                    String newTitle = View.getString("Enter Title");
                    bookToEdit.setTitle(newTitle);
                    bookDao.updateBook("title", newTitle, ISBN);
                    optionChosen = true;
                    break;
                case 3:
                    String newPublisher = View.getString("Enter new Publisher");
                    bookToEdit.setPublisher(newPublisher);
                    bookDao.updateBook("publisher", newPublisher, ISBN);
                    optionChosen = true;
                    break;
                case 4:
                    String newPublicationYear = View.getString("Enter new PublicationYear");
                    bookToEdit.setPublicationYear(newPublicationYear);
                    bookDao.updateBook("publication_year", newPublicationYear, ISBN);
                    optionChosen = true;
                    break;
                case 5:
                    String newPrice = View.getString("Enter new Price");
                    bookToEdit.setPrice(newPrice);
                    bookDao.updateBook("price", newPrice, ISBN);
                    optionChosen = true;
                    break;
                case 6:
                    String newType = View.getString("Enter new Type");
                    bookToEdit.setPrice(newType);
                    bookDao.updateBook("type", newType, ISBN);
                    optionChosen = true;
                    break;
            }
        }
    }
}
