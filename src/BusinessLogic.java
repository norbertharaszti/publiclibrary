import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BusinessLogic {
    private Connection getConnection() throws SQLException {
        Properties prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/library?serverTimezone=UTC", prop);
    }

    private static final String SQL_INSERT_INTO_BOOK = "INSERT INTO " + Book.bookTableName + " (" + Book.idColName + ", "
            + Book.isbnColName + ", " + Book.titleColName + ", " + Book.releaseYearColName + ") VALUES (?,?,?,?)";

    protected void addBook() {
        try {
            Connection connection = getConnection();

            List<Author> authors = getAuthors(connection);

            String message = "Please add the 10 or 13 digit long ISBN number of the book:";
            String isbn = getInputFromAdmin(message, Book.isbnColName);

            message = "Please add the title:";
            String title = getInputFromAdmin(message, Book.titleColName);
            message = "Please add the release date using the format YYYY";
            int releaseYear = Integer.parseInt(getInputFromAdmin(message, Book.releaseYearColName));

            message = "Please add the 1st author of the book: ";
            PreparedStatement psInsert = connection.prepareStatement(SQL_INSERT_INTO_BOOK);
//            psInsert.setString(1, Book.bookTableName);
//            psInsert.setString(2, Book.idColName);
//            psInsert.setString(3, Book.isbnColName);
//            psInsert.setString(4, Book.titleColName);
//            psInsert.setString(5, Book.releaseYearColName);
            psInsert.setInt(1, 0);
            psInsert.setString(2, isbn);
            psInsert.setString(3, title);
            psInsert.setInt(4, releaseYear);
            psInsert.addBatch();
            psInsert.executeBatch();

// Ha benne van az author listában, akkor nem kell új authort felvenni, amúgy igen...
//            String author = getInputFromAdmin(message, Author.nameColName);
            connection.close();
            System.out.println("Data insert was successful");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    protected List<Author> getAuthors(Connection connection) throws SQLException {
        List<Author> authors = new ArrayList<>();
        PreparedStatement ps = connection.prepareStatement(
                "SELECT * FROM author");
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            Author author = new Author(resultSet.getInt(Author.authorIdColName), resultSet.getString(Author.nameColName),
                    resultSet.getDate(Author.dateOfBirthColName));
            authors.add(author);
        }
        return authors;
    }

    private String getInputFromAdmin(String message, String colName) {
        Scanner scanner;
        boolean isInputOk;
        String input;
        do {
            System.out.println(message);
            scanner = new Scanner(System.in);
            input = scanner.nextLine();
            isInputOk = validateInput(input, colName);
        } while (!isInputOk);
        return input;
    }

    private boolean validateInput(String input, String colName) {
        String regExString1 = "";
        Pattern pattern;
        Matcher matcher;
        if (colName.equals(Book.isbnColName)) {
            regExString1 = "^\\d{13}$";
            String regExString2 = "^\\d{10}$";
            if (input.length() == 13) {
                pattern = Pattern.compile(regExString1);
            } else if (input.length() == 10) {
                pattern = Pattern.compile(regExString2);
            } else {
                return false;
            }
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                return true;
            }
        } else if (colName.equals(Book.titleColName)
                || colName.equals(Author.nameColName)) {
            regExString1 = "^.{2,45}$";
            pattern = Pattern.compile(regExString1);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                return true;
            }
        } else if (colName.equals(Book.releaseYearColName)) {
            regExString1 = "^\\d{4}$";
            pattern = Pattern.compile(regExString1);
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                int year = Integer.parseInt(input.substring(0, 4));
                if (year > LocalDate.now().getYear()) {
                    return false;
                }
                return true;
            }
//            int month = Integer.parseInt(input.substring(5, 7));
//            int day = Integer.parseInt(input.substring(8, 10));
        }
        return false;
    }
}
