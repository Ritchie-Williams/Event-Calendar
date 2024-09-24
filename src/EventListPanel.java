import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class EventListPanel extends JPanel {
    private ArrayList<Event> events;
    private JPanel displayPanel;

    // Constructor
    public EventListPanel() {
        setLayout(new BorderLayout());

        events = new ArrayList<>();
        displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));

        // Create the control panel for sorting and adding events
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        // Add a sorting dropdown
        String[] sortOptions = {"Name", "Date"};
        JComboBox<String> sortDropDown = new JComboBox<>(sortOptions);
        sortDropDown.addActionListener(e -> sortEvents(sortDropDown.getSelectedItem().toString()));
        controlPanel.add(new JLabel("Sort by: "));
        controlPanel.add(sortDropDown);

        // Add an "Add Event" button
        JButton addEventButton = new JButton("Add Event");
        addEventButton.addActionListener(e -> openAddEventModal());
        controlPanel.add(addEventButton);

        // Add the control panel to the north and display panel to the center
        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(displayPanel), BorderLayout.CENTER);
    }

    // Add a new event to the list and update the display
    public void addEvent(Event event) {
        events.add(event);
        refreshEventList();
    }

    // Refresh the event list display
    private void refreshEventList() {
        displayPanel.removeAll();
        for (Event event : events) {
            displayPanel.add(new EventPanel(event));
        }
        displayPanel.revalidate();
        displayPanel.repaint();
    }

    // Sort the events by name or date
    private void sortEvents(String sortBy) {
        if (sortBy.equals("Name")) {
            Collections.sort(events, Comparator.comparing(Event::getName));
        } else if (sortBy.equals("Date")) {
            Collections.sort(events);
        }
        refreshEventList();
    }

    // Open the modal to add a new event
    private void openAddEventModal() {
        AddEventModal modal = new AddEventModal(this);
        modal.setVisible(true);
    }
}
