import java.util.Date;

public class Deadline extends Event implements Completable {
    private boolean complete; // Whether the task is complete

    // Constructor
    public Deadline(String name, Date dateTime) {
        super(name, dateTime);
        this.complete = false;
    }

    // Get the name of the deadline event
    @Override
    public String getName() {
        return "Deadline: " + super.getDateTime();
    }

    // Mark the deadline as complete
    @Override
    public void complete() {
        this.complete = true;
    }

    // Check if the deadline is complete
    @Override
    public boolean isComplete() {
        return complete;
    }
}
