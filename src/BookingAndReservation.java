import java.sql.Date;

public class BookingAndReservation {
    private int ID;
    private int userID;
    private Date startDate;
    private Date endDate;
    private boolean isBooking;
    private int instanceId;

    public BookingAndReservation(int ID, int userID, Date startDate, Date endDate, boolean isBooking, int instanceId) {
        this.ID = ID;
        this.userID = userID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isBooking = isBooking;
        this.instanceId = instanceId;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public boolean isBooking() {
        return isBooking;
    }

    public int getInstanceId() {
        return instanceId;
    }
}
