package Model;

public class Book {

    private String ISBN;
    private String authorId;
    private String title;
    private String publisher;
    private String publicationYear;
    private String price;
    private String type;

    public Book(String ISBN, String authorId, String title, String publisher, String publicationYear, String price, String type){
        this.ISBN = ISBN;
        this.authorId = authorId;
        this.title = title;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.price = price;
        this.type = type;
    }



    public String getISBN() {
        return ISBN;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPrice() {
        return price;
    }

    public String getPublicationYear() {
        return publicationYear;
    }

    public String getType() {
        return type;
    }
}

