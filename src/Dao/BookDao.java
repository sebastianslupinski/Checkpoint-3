package Dao;

import Model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {

    public ArrayList<Book> books = new ArrayList<>();

    private Connection connection = this.createConnection();

    public Connection createConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books");
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        return connection;
    }

    public ArrayList<String[]> getBooksDataFromDatabase() {

        String sql = "SELECT * FROM Books";
        int IsbnColumn = 0;
        int authorColumn = 1;
        int titleColumn = 2;
        int publisherColumn = 3;
        int publicationYearColumn = 4;
        int priceColumn = 5;
        int typeColumn = 6;
        ArrayList<String[]> allBooks = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String[] idLoginAndPassword = new String[7];
                idLoginAndPassword[IsbnColumn] = rs.getString("ISBN");
                idLoginAndPassword[authorColumn] = rs.getString("author");
                idLoginAndPassword[titleColumn] = rs.getString("title");
                idLoginAndPassword[publisherColumn] = rs.getString("publisher");
                idLoginAndPassword[publicationYearColumn] = rs.getString("publication_year");
                idLoginAndPassword[priceColumn] = rs.getString("price");
                idLoginAndPassword[typeColumn] = rs.getString("type");

                allBooks.add(idLoginAndPassword);
            }
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return allBooks;
    }

    public void createBookObjects(){
        ArrayList<String[]> booksInfo = getBooksDataFromDatabase();
        for (String[] bookInfo : booksInfo) {
            Book bookToAdd;
            String ISBN = bookInfo[0];
            String authorId = bookInfo[1];
            String title = bookInfo[2];
            String publisher = bookInfo[3];
            String publicationYear = bookInfo[4];
            String price = bookInfo[5];
            String type = bookInfo[6];
            bookToAdd = new Book(ISBN, authorId, title, publisher, publicationYear, price, type);
            books.add(bookToAdd);
        }
    }
}
