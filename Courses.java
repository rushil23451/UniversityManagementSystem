import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Courses {
    private String courseCode;
    private String title;
    private String professor;
    private int credits;
    private List<Courses> prerequisites;
    private String timings;
    public int grades;
    private String syllabus;
    Scanner scanner=new Scanner(System.in);



    // Constructor
    public Courses(String courseCode, String title, String professor, int credits, List<Courses> prerequisites, String timings) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = prerequisites;
        this.timings = timings;

    }
    public Courses(String courseCode, String title, String professor, int credits, String timings) {
        this.courseCode = courseCode;
        this.title = title;
        this.professor = professor;
        this.credits = credits;
        this.prerequisites = new ArrayList<>();
        this.timings = timings;
    }





    public void setgrades(int grade){
        this.grades=grade;
    }
    public void setcredits(int credits){
        this.credits=credits;
    }

    public int getGrades(){
        return grades;
    }

    public String getCourseCode() {
        return courseCode;
    }
    public String getTitle() {
        return title;
    }
    public String getProfessor() {
        return professor;
    }
    public int getCredits() {
        return credits;
    }

    public void setprof(String prof_name) {
         professor=prof_name;
    }
    public List<Courses> getPrerequisites() {
        return prerequisites;
    }
    public String getTimings() {
        return timings;
    }

    public void displayCourseDetails() {
        System.out.println("Course Code: " + courseCode);
        System.out.println("Title: " + title);
        System.out.println("Professor: " + professor);
        System.out.println("Credits: " + credits);
        System.out.println("Timings: " + timings);
        if (prerequisites.isEmpty()) {
            System.out.println("Prerequisites: None");
        } else {
            System.out.println("Prerequisites: ");
            for (Courses prerequisite : prerequisites) {
                System.out.println(" - " + prerequisite.getTitle());
            }
        }
    }
}


