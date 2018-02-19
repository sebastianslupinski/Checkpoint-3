package Model;

public class Author {

    private int authorId;
    private String name;
    private String surname;
    private int birthYear;
    private String city;
    private String country;

    public Author(int authorId, String name, String surname, int birthYear, String city, String country){
        this.authorId = authorId;
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.city = city;
        this.country = country;
    }
}
