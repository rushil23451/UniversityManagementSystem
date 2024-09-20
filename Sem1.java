import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sem1 implements Semester {
    public List<Courses> availableCourses;
    Scanner scanner = new Scanner(System.in);

    public Sem1() {
        this.availableCourses = new ArrayList<>();
        initializeCourses();
        pre_assigned_grades();
    }

    @Override
    public void initializeCourses() {
        List<Courses> noPrerequisites = new ArrayList<>();
        availableCourses.add(new Courses("CS101", "Introduction to Programming", "Dr. Smith", 4, noPrerequisites, "Mon-Wed-Fri 9AM-10:30AM,LHC-201"));
        availableCourses.add(new Courses("COM101", "Communication Skills", "Dr. John", 4, noPrerequisites, "Tue-Thu 11AM-12:30PM,LHC-101"));
        availableCourses.add(new Courses("ECE101", "Digital Circuits", "Dr. Mary", 4, noPrerequisites, "Mon-Wed 2PM-3:30PM,LHC-102"));
        availableCourses.add(new Courses("MTH101","Linear Algebra", "Dr. Samaresh", 4,noPrerequisites,"Mon-Wed-Thur 10:30am-12:00pm,Old Acad-11 "));
        availableCourses.add(new Courses("SSH101","Human Computer Interaction", "Dr. Rajeev", 4,noPrerequisites,"Mon-Thur 11:30am-13:00pm,Old Acad-01 "));

    }

    @Override
    public List<Courses> getAvailableCourses() {
        return availableCourses;
    }

    @Override
    public void displayAvailableCourses() {
        System.out.println("Courses for Semester 1:");
        int count = 1;
        for (Courses course : availableCourses) {
            System.out.println(count + ")");
            course.displayCourseDetails();
            System.out.println();
            count++;
        }
    }

    @Override
    public void deletecourses() {
        displayAvailableCourses();
        System.out.println("Select the course option you want to delete (-1 if you don't want to delete): ");
        int option = scanner.nextInt();
        if (option == -1) {
            return;
        }
        if (option > availableCourses.size() || option < 1) {
            System.out.println("Enter a valid option number!");
            return;
        }
        availableCourses.remove(option - 1);
    }

    @Override
    public void pre_assigned_grades() {
        for (Courses course : availableCourses) {
            course.setgrades(0);
        }
    }

    @Override
    public void assign_grades() {
        System.out.println("Courses of Semester 1 for assigning grades:");
        int count = 1;
        for (Courses course : availableCourses) {
            System.out.println(count + ")");
            course.displayCourseDetails();
            System.out.println();
            count++;
        }
        int numberOfCourses = availableCourses.size();
        while (true) {
            System.out.println("Enter the course number to assign grade (-1 to exit):");
            int option = scanner.nextInt();
            if (option == -1) {
                break;
            }
            if (option > numberOfCourses || option < 1) {
                System.out.println("Enter a valid option number!");
                continue;
            }
            System.out.println("Enter the grade you want to assign:");
            int grade_new = scanner.nextInt();
            availableCourses.get(option - 1).setgrades(grade_new);
        }
    }
}
