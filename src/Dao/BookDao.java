package Dao;

import java.sql.*;
import java.util.ArrayList;

public class BookDao {

    private Connection connection = this.createConnection();


    public Connection createConnection() {

        String url = "jdbc:sqlite:books.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
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
}
