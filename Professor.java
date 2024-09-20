import java.util.*;
import java.util.Scanner;
public class Professor{
        private String email;
        private String name;
        private String password;
        private List<ProfessorCourses> prof_courses;
        Scanner scanner=new Scanner(System.in);

        Professor(String name,String email){
                this.name=name;
                this.email=email;
                this.prof_courses=new ArrayList<>();
        }

        Professor(String name,String email,String password,List<ProfessorCourses> prof_courses){
                this.name=name;
                this.email=email;
                this.password=password;
                this.prof_courses=prof_courses;
        }
        public void setprofcourses(List<ProfessorCourses> prof_courses){
                this.prof_courses=prof_courses;
        }
        public String getemail(){
                return email;
        }
        public String getname(){
                return name;
        }
        public String getpassword(){
                return password;
        }
        public List<ProfessorCourses> getprofcourses(){
                return prof_courses;
        }
        public void addcourse(Courses course, String syllabus,int enrollement_limits,String office_hours){
                ProfessorCourses newprofcourse=new ProfessorCourses(course.getCourseCode(),course.getTitle(),getname(),course.getCredits(),course.getPrerequisites(), course.getTimings(),syllabus, enrollement_limits,office_hours );
                prof_courses.add(newprofcourse);
        }


        public void viewEnrolledStudents(Courses course, List<Student> allStudents) {
                if (!prof_courses.contains(course)) {
                        System.out.println("You are not teaching this course.");
                        return;
                }

                System.out.println("Students enrolled in " + course.getTitle() + ":");
                for (Student student : allStudents) {
                        if (student.getRegisteredCourses().contains(course)) {
                                System.out.println("Student Name: " + student.getName());
                                System.out.println("Email: " + student.getEmail());
                                System.out.println("Academic Progress: ");
                                student.academic_progress();
                                System.out.println();
                        }
                }
        }
        public void veiwprofcourses(){
                if(prof_courses.isEmpty()){
                        System.out.println("Admin has not assigned any courses yet!");
                        return;
                }
                int count=1;
                for(ProfessorCourses newcourse:prof_courses){
                        System.out.println(count+")");
                        count++;

                        newcourse.displayCourseDetails();
                }
        }
        public void changecoursedetails(){
                System.out.println("Out of these courses enter the course number you want to edit: ");
                veiwprofcourses();
                if(prof_courses.isEmpty()){
                        System.out.println("No courses assigned! ");


                        return;
                }
                int option=scanner.nextInt();
                scanner.nextLine();
                prof_courses.get(option-1).editcourse();


        }







}
