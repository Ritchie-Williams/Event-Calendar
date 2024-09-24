import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class AddEventModal extends JDialog {
    private EventListPanel eventListPanel;

    // Constructor
    public AddEventModal(EventListPanel eventListPanel) {
        this.eventListPanel = eventListPanel;
        setTitle("Add New Event");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        // Event type selection
        JLabel typeLabel = new JLabel("Event Type: ");
        String[] eventTypes = {"Deadline", "Meeting"};
        JComboBox<String> eventTypeDropDown = new JComboBox<>(eventTypes);

        // Name input
        JLabel nameLabel = new JLabel("Event Name: ");
        JTextField nameField = new JTextField();

        // Date input (for simplicity, using current time)
        JLabel dateLabel = new JLabel("Event Date: ");
        JTextField dateField = new JTextField("YYYY-MM-DD");

        // Location (for meeting only)
        JLabel locationLabel = new JLabel("Location: ");
        JTextField locationField = new JTextField();

        // Add the form fields
        add(typeLabel);
        add(eventTypeDropDown);
        add(nameLabel);
        add(nameField);
        add(dateLabel);
        add(dateField);
        add(locationLabel);
        add(locationField);

        // Add a button to submit the form
        JButton submitButton = new JButton("Add Event");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            Date dateTime = new Date(); // Simplified to current date for this example
            if (eventTypeDropDown.getSelectedItem().equals("Deadline")) {
                Deadline deadline = new Deadline(name, dateTime);
                eventListPanel.addEvent(deadline);
            } else {
                Meeting meeting = new Meeting(name, dateTime, new Date(dateTime.getTime() + 3600000), locationField.getText());
                eventListPanel.addEvent(meeting);
            }
            dispose();
        });
        add(submitButton);
    }
}
