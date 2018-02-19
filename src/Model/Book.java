package Model;

public class Book {

    private int ISBN;
    private int authorId;
    private String title;
    private String publisher;
    private int publicationYear;
    private double price;
    private int type;

    public Book(int ISBN, int authorId, String title, String publisher, int publicationYear, double price, int type){
        this.ISBN = ISBN;
        this.authorId = authorId;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = type;
    }
}

