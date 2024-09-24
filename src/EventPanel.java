import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventPanel extends JPanel {
    private Event event;
    private JButton completeButton;

    // Constructor
    public EventPanel(Event event) {
        this.event = event;
        setLayout(new FlowLayout());

        // Display the event details
        JLabel nameLabel = new JLabel("Event: " + event.getName());
        JLabel dateLabel = new JLabel("Date: " + event.getDateTime());

        // Add labels to the panel
        add(nameLabel);
        add(dateLabel);

        // If the event implements Completable, add a complete button
        if (event instanceof Completable) {
            completeButton = new JButton("Complete");
            completeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ((Completable) event).complete();
                    updateCompletionStatus();
                }
            });
            add(completeButton);
        }

        // Display the completion status
        updateCompletionStatus();
    }

    // Update the completion status
    private void updateCompletionStatus() {
        if (event instanceof Completable) {
            if (((Completable) event).isComplete()) {
                completeButton.setEnabled(false);
                setBackground(Color.GREEN); // Green for completed events
            } else {
                setBackground(Color.RED); // Red for incomplete events
            }
        }
    }
}
