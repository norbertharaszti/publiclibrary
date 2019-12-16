public class AuthorOfBooks {
    public static final String AUTHOR_OF_BOOKS_TABLE_NAME = "author_of_book";
    public static final String isbnColName = "book_id";
    public static final String authorIdColName = "author_id";
    private String isbn;
    private int authorId;

    public AuthorOfBooks(String isbn, int authorId) {
        this.isbn = isbn;
        this.authorId = authorId;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAuthorId() {
        return authorId;
    }
}
