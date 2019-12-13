public class AuthorOfBooks {
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
