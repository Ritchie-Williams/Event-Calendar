import javax.swing.*;
import java.util.Date;


public class EventPlanner {
    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Event Calendar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        // Create the EventListPanel and add it to the frame
        EventListPanel eventListPanel = new EventListPanel();
        frame.add(eventListPanel);

        // Add some default events (at least one Deadline and one Meeting)
        EventPlanner.addDefaultEvents(eventListPanel);

        // Show the frame
        frame.setVisible(true);
    }

    // Method to add some default events to the EventListPanel
    public static void addDefaultEvents(EventListPanel eventListPanel) {
        // Add a default deadline event
        Deadline deadline = new Deadline("Project Submission", new Date(System.currentTimeMillis() + 86400000)); // 1 day from now
        eventListPanel.addEvent(deadline);

        // Add a default meeting event
        Meeting meeting = new Meeting("Team Meeting", new Date(System.currentTimeMillis() + 3600000), new Date(System.currentTimeMillis() + 7200000), "Conference Room");
        eventListPanel.addEvent(meeting);
    }
}
