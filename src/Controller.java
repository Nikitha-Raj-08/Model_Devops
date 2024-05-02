import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private List<Student> students = new ArrayList<>();
    private List<Course> courses = new ArrayList<>();
    private List<Registration> registrations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private View view;

    public Controller(View view) {
        this.view = view;
    }

    public void run() {
        boolean running = true;
        while (running) {
            view.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    registerStudent();
                    break;
                case 2:
                    displayRegistrations();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    view.displayMessage("Invalid choice. Please enter a valid option.");
            }
        }
    }

    private void registerStudent() {
        view.displayMessage("\nEnter student name: ");
        String name = scanner.nextLine();
        view.displayMessage("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Student student = new Student(name, id);

        view.displayAvailableCourses(courses);
        view.displayMessage("Enter course ID to register: ");
        int courseId = scanner.nextInt();

        Course selectedCourse = null;
        for (Course course : courses) {
            if (course.getCourseId() == courseId) {
                selectedCourse = course;
                break;
            }
        }

        if (selectedCourse != null) {
            registrations.add(new Registration(student, selectedCourse));
            view.displayMessage("Student " + student.getName() + " registered for " + selectedCourse.getCourseName());
        } else {
            view.displayMessage("Invalid course ID.");
        }
    }

    private void displayRegistrations() {
        view.displayMessage("\nRegistrations:");
        for (Registration registration : registrations) {
            view.displayMessage("Student: " + registration.getStudent().getName() + ", Course: " +
                    registration.getCourse().getCourseName());
        }
    }
}
