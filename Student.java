
import java.util.*;

public class Student {
    private String name;
    private String email;
    private String password;
    private List<Courses> registeredCourses;
    private List<Courses> completedCourses;
    private List<Complaints> StudentComplaints;


    public Student(String name,String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.registeredCourses = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        this.StudentComplaints=new ArrayList<>();
        initialize_completed_courses();


    }
    public Student(String name,String email, String password,List<Courses> registeredCourses) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.registeredCourses=registeredCourses;
        this.completedCourses = new ArrayList<>();
        this.StudentComplaints=new ArrayList<>();
        initialize_completed_courses();


    }
    public void initialize_completed_courses(){
        Sem1 sem1=new Sem1();
        for(Courses course:sem1.availableCourses){
            completedCourses.add(course);

        }
    }
    public void addcomplaint(String description){
        Complaints complaint=new Complaints(description,name);
        StudentComplaints.add(complaint);
    }
    public void viewcomplaints(){
        if(StudentComplaints.isEmpty()){
            System.out.println("No complaints");

        }
        else{
            int count1=1;
            for(Complaints comp:StudentComplaints) {
                System.out.println(count1 + ")");
                count1++;

                System.out.println("Complaint description: " + comp.getDescription());
                System.out.println("Complaint status: " + comp.getStatus());
                System.out.println();

            }
        }
    }
    public int getcgpa(){
        int finalcg=0;
        for (Courses course : completedCourses) {
            finalcg+=course.getGrades();

        }
        int total_subjects=completedCourses.size();
        return finalcg/total_subjects;


    }
    public void academic_progress(){
        for (Courses course : completedCourses) {
            System.out.println(course.getCourseCode()+ ": " + course.getTitle() );
            System.out.println("Grade: " + course.getGrades());
            System.out.println();
        }

    }

    // Getters and Setters
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }

//    public int getSemester() { return semester; }
    public List<Courses> getRegisteredCourses() {
        return registeredCourses;
    }
    public List<Courses> getCompletedCourses() {
        return completedCourses;
    }
    public void printRegisteredCourses(){
        if(registeredCourses.isEmpty()){
            System.out.println("Register for Courses First!");


        }
        else {
            System.out.println("The following are the courses you have registered for: ");
            int count = 1;
            for (Courses course : registeredCourses) {
                System.out.println(count + ")");

                course.displayCourseDetails();
                System.out.println();
                count++;
            }
        }

    }

    public void register_courses(Courses course) {
        registeredCourses.add(course);
        System.out.println("Course successfully registered!");

    }

    // Display Student Information
    public void displayStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Courses Registered: ");
        for (Courses course : registeredCourses) {
//            course.displayCourseInfo();
        }
    }
    public void viewschedule(){
        if(registeredCourses.isEmpty()){
            System.out.println("Register for courses first!!");
        }
        else{
            for(Courses course:registeredCourses){
                System.out.println("Course Name: "+course.getTitle());
                System.out.println("Professor Name: "+course.getProfessor());
                System.out.println("Course Timings and Location: "+course.getTimings());
                System.out.println();

            }
        }
    }
    public void dropcourse(int index){
        registeredCourses.remove(index);
        System.out.println("Course removed successfully!");

    }

}
