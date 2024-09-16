import java.util.Date;

// Abstract class Event implementing Comparable<Event>
public abstract class Event implements Comparable<Event> {
    // Fields
    private String name;
    private Date dateTime;

    // Constructor
    public Event(String name, Date dateTime) {
        this.name = name;
        this.dateTime = dateTime;
    }

    // Abstract method to get the name
    public abstract String getName();

    // Method to get the date and time of the event
    public Date getDateTime() {
        return dateTime;
    }

    // Method to set the date and time of the event
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    // Method to set the name of the event
    public void setName(String name) {
        this.name = name;
    }

    // compareTo method to compare the dates of two events
    @Override
    public int compareTo(Event e) {
        return this.dateTime.compareTo(e.getDateTime());
    }
}

// Completable Interface
interface Completable {
    // Method to mark an event as complete
    void complete();

    // Method to check if an event is complete
    boolean isComplete();
}