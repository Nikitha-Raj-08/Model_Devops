import java.util.List;
public class View {
    public void displayMenu() {
        System.out.println("\nCourse Registration System");
        System.out.println("1. Register Student");
        System.out.println("2. Display Registrations");
        System.out.println("3. Exit");
        System.out.print("Enter your choice: ");
    }

    public void displayAvailableCourses(List<Course> courses) {
        System.out.println("\nAvailable Courses:");
        for (Course course : courses) {
            System.out.println(course.getCourseId() + ". " + course.getCourseName());
        }
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
