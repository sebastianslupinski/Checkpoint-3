package Dao;

import Model.Book;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {

    private ArrayList<Book> books = new ArrayList<>();

    private Connection connection = this.createConnection();

    public ArrayList<Book> getBooks() {
        return books;
    }

    public Connection createConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:books");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
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

    public void createBookObjects() {
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

    public void saveNewBookToDatabase(Book newBook) {
        String ISBN = newBook.getISBN();
        String authorId = newBook.getAuthorId();
        String title = newBook.getTitle();
        String publisher = newBook.getPublisher();
        String publicationYear = newBook.getPublicationYear();
        String price = newBook.getPrice();
        String type = newBook.getType();

        String sqlQuerry = "INSERT INTO Books(ISBN, author, title, publisher, publication_year, price, type) VALUES(?, ?, ?, ?, ?, ?, ?);";


        try (PreparedStatement pstmt1 = connection.prepareStatement(sqlQuerry)) {
            pstmt1.setString(1, ISBN);
            pstmt1.setString(2, authorId);
            pstmt1.setString(3, title);
            pstmt1.setString(4, publisher);
            pstmt1.setString(5, publicationYear);
            pstmt1.setString(6, price);
            pstmt1.setString(7, type);

            pstmt1.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public void updateBook(String columnToUpdate, String newData, String ISBN){
        String sql = "UPDATE Books SET ?=? WHERE ISBN=?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, columnToUpdate);
            pstmt.setString(2, newData);
            pstmt.setString(3, ISBN);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBookPublisher(String newData, String ISBN){
        String sql = "UPDATE Books SET publisher=? WHERE ISBN=?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newData);
            pstmt.setString(2, ISBN);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void updateBookTitle(String newData, String ISBN){
        String sql = "UPDATE Books SET title=? WHERE ISBN=?;";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, newData);
            pstmt.setString(2, ISBN);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}


