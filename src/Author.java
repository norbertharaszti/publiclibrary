import java.sql.Date;

public class Author {
    public static final String authorIdColName = "ID";
    public static final String nameColName = "name";
    public static final String dateOfBirthColName = "date_of_birth";
    private int authorId;
    private String name;
    private Date dateOfBirth;

    public Author(int authorId, String name, Date dateOfBirth) {
        this.authorId = authorId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getName() {
        return name;
    }
}
