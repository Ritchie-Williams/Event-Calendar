import java.util.Date;

public class Meeting extends Event implements Completable {
    private Date endDateTime;  // The time the meeting is over
    private String location;   // The location of the meeting
    private boolean complete;  // Whether the meeting is complete

    // Constructor
    public Meeting(String name, Date startDateTime, Date endDateTime, String location) {
        super(name, startDateTime);
        this.endDateTime = endDateTime;
        this.location = location;
        this.complete = false;
    }

    // Get the name of the meeting event
    @Override
    public String getName() {
        return "Meeting: " + super.getDateTime();
    }

    // Get the end time of the meeting
    public Date getEndTime() {
        return endDateTime;
    }

    // Set the end time of the meeting
    public void setEndTime(Date endDateTime) {
        this.endDateTime = endDateTime;
    }

    // Get the duration of the meeting in minutes
    public long getDuration() {
        return (endDateTime.getTime() - super.getDateTime().getTime()) / (60 * 1000);
    }

    // Get the location of the meeting
    public String getLocation() {
        return location;
    }

    // Set the location of the meeting
    public void setLocation(String location) {
        this.location = location;
    }

    // Mark the meeting as complete
    @Override
    public void complete() {
        this.complete = true;
    }

    // Check if the meeting is complete
    @Override
    public boolean isComplete() {
        return complete;
    }
}
