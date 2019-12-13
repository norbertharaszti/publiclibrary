import java.sql.Date;

public class User {
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
