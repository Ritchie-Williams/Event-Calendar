import java.util.Date;

public class EventTester {

    public static void main(String[] args) {
        // Test Deadline class
        testDeadline();

        // Test Meeting class
        testMeeting();
    }

    // Test method for Deadline
    public static void testDeadline() {
        System.out.println("Testing Deadline...");

        // Create a Deadline event
        Date deadlineDate = new Date(System.currentTimeMillis() + 86400000); // 1 day from now
        Deadline deadline = new Deadline("Project Submission", deadlineDate);

        // Print details
        System.out.println("Deadline Name: " + deadline.getName());
        System.out.println("Deadline DateTime: " + deadline.getDateTime());
        System.out.println("Is Deadline Complete? " + deadline.isComplete());

        // Mark as complete
        deadline.complete();
        System.out.println("Marking deadline as complete...");
        System.out.println("Is Deadline Complete? " + deadline.isComplete());

        System.out.println("------ End of Deadline Test ------\n");
    }

    // Test method for Meeting
    public static void testMeeting() {
        System.out.println("Testing Meeting...");

        // Create a Meeting event
        Date meetingStartTime = new Date(System.currentTimeMillis() + 3600000); // 1 hour from now
        Date meetingEndTime = new Date(System.currentTimeMillis() + 7200000); // 2 hours from now
        Meeting meeting = new Meeting("Team Meeting", meetingStartTime, meetingEndTime, "Conference Room");

        // Print details
        System.out.println("Meeting Name: " + meeting.getName());
        System.out.println("Meeting Start Time: " + meeting.getDateTime());
        System.out.println("Meeting End Time: " + meeting.getEndTime());
        System.out.println("Meeting Duration: " + meeting.getDuration() + " minutes");
        System.out.println("Meeting Location: " + meeting.getLocation());
        System.out.println("Is Meeting Complete? " + meeting.isComplete());

        // Mark as complete
        meeting.complete();
        System.out.println("Marking meeting as complete...");
        System.out.println("Is Meeting Complete? " + meeting.isComplete());

        System.out.println("------ End of Meeting Test ------\n");
    }
}
