import java.util.List;
import java.util.Scanner;

public class ProfessorCourses extends Courses {
    private String syllabus;
    private int enrollement_limits;
    private String office_hours;
    Scanner scanner = new Scanner(System.in);

    // Constructor for ProfessorCourses
    public ProfessorCourses(String courseCode, String title, String professor, int credits, List<Courses> prerequisites, String timings, String syllabus,int enrollement_limits,String office_hours) {
        // Call the parent constructor (Courses) to set common attributes
        super(courseCode, title, professor, credits, prerequisites, timings);
        this.syllabus = syllabus;
        this.enrollement_limits=enrollement_limits;
        this.office_hours=office_hours;
    }

    // Getter for syllabus
    public String getSyllabus() {
        return syllabus;
    }
    public void setSyllabus(String syllabus) {
        this.syllabus=syllabus;
    }
    public void setOfficehourse(String office_hours) {
        this.office_hours=office_hours;
    }
    public void setEnrollement_limits(int enrollement_limits) {
        this.enrollement_limits=enrollement_limits;
    }

    // Override the displayCourseDetails method to also display the syllabus
    @Override
    public void displayCourseDetails() {
        // Call the parent method to display common course details
        super.displayCourseDetails();
        // Display the syllabus
        System.out.println("Syllabus: " + syllabus);
        System.out.println("Enrollment limit: " + enrollement_limits);
        System.out.println("Office Hours: " + office_hours);





    }
    public void editcourse() {

        // Editing syllabus
        System.out.println("Current Syllabus: " + syllabus);
        System.out.println("Enter new syllabus (-1 to keep unchanged): ");
        String newSyllabus = scanner.nextLine();
        if (!newSyllabus.equals("-1")) {
            setSyllabus(newSyllabus);
        }
        System.out.println("Current Enrollment Limit: " + enrollement_limits);
        System.out.println("Enter new enrollment limit (-1 to keep unchanged): ");
        int newEnrollmentLimit = scanner.nextInt();
        if (newEnrollmentLimit != -1) {
            setEnrollement_limits(newEnrollmentLimit);
        }
        scanner.nextLine();

        System.out.println("Current Office Hours: " + office_hours);
        System.out.println("Enter new office hours (-1 to keep unchanged): ");
        String newOfficeHours = scanner.nextLine();
        if (!newOfficeHours.equals("-1")) {
            setOfficehourse(newOfficeHours);
        }

        System.out.println("Credits: " + getCredits());
        System.out.println("Enter new credits(-1 to keep unchanged): ");
        int credit = scanner.nextInt();
        if (credit!=-1) {
            setcredits(credit);
        }

        System.out.println("Course details updated successfully!");
    }
}

