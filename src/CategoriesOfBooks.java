public class CategoriesOfBooks {
    private String isbn;
    private int categoryId;

    public CategoriesOfBooks(String isbn, int categoryId) {
        this.isbn = isbn;
        this.categoryId = categoryId;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCategoryId() {
        return categoryId;
    }
}
