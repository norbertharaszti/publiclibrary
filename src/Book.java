import java.util.Date;

public class Book {
    public static final String idColName = "ID";
    public static final String isbnColName = "isbn";
    public static final String titleColName = "title";
    public static final String releaseYearColName = "release_year";
    public static final String bookTableName = "book";
    private int id;
    private String isbn;
    private String title;
    private int releaseYear;

    public Book(int id, String isbn, String title, int releaseDate) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.releaseYear = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
}
