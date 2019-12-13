import java.util.Date;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private Date releaseDate;

    public Book(int id, String isbn, String title, Date releaseDate) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.releaseDate = releaseDate;
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

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}
