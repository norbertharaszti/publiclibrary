import java.sql.Date;
import java.time.LocalDateTime;

public class User {
    public static final String idColName = "ID";
    public static final String firstNameColName = "firstname";
    public static final String secondNameColName = "secondname";
    public static final String birthdayColName = "date_of_birth";
    public static final String dateOfRegistrationColName = "date_of_registration";
    public static final String userTableName = "user";
    private int id;
    private String firstName;
    private String secondName;
    private Date dateOfBirth;
    private Date dateOfRegister;

    public User(int id, String firstName, String secondName, Date dateOfBirth, Date dateOfRegister) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfRegister = dateOfRegister;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public Date getDateOfRegister() {
        return dateOfRegister;
    }
}
