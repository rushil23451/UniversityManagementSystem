import java.util.Scanner;
import java.util.*;

class enrolled_students {
    public static List<Student> studentList = new ArrayList<>();
    public enrolled_students() {
    }
    public void add_student(Student student1) {
        studentList.add(student1);
    }
    public static List<Student> getstudentlist() {
        return studentList;
    }
    public void viewEnrolledStudentsForCourse(Courses course) {
        for (Student student : getstudentlist()) {
            if (student.getRegisteredCourses().contains(course)) {
                System.out.println("Student Name: " + student.getName());
                System.out.println("Email: " + student.getEmail());
                System.out.println();
            }
        }
    }
}

public class Mainapp {
    public static List<Professor> proflist = new ArrayList<>();
    public static List<Complaints> complaints = new ArrayList<>();


    public static void main(String[] args) {
        List<Courses> Prereqs_DSA = new ArrayList<>();
        List<Courses> noPrerequisites = new ArrayList<>();
        Courses IP=new Courses("CS101", "Introduction to Programming", "Dr. Smith", 4, noPrerequisites, "Mon-Wed-Fri 9AM-10AM");
        ProfessorCourses IP_prof = new ProfessorCourses("CS101", "Intro to Programming", "Dr. Smith", 4, noPrerequisites, "Mon-Wed-Fri 9AM-10AM", "Basic programming concepts and hands-on coding.", 60, "Mon 2:00 PM - 3:00 PM");

        List<ProfessorCourses> Smith_courses = new ArrayList<>();
        Smith_courses.add(IP_prof);
        proflist.add(new Professor("Dr. Smith", "smith@iiitd.ac.in", "smith123", Smith_courses));
        Prereqs_DSA.add(IP);

//        JONES IMPLEMENTATION-DSA TEACHER;

        ProfessorCourses DSA = new ProfessorCourses("CS201", "Data Structures and Algorithm", "Dr. Jones", 4, Prereqs_DSA, "Mon-Wed 10:00-11:30", "Basic programming concepts and hands-on coding.", 60, "Mon 2:00 PM - 3:00 PM");
        List<ProfessorCourses> Jone_courses = new ArrayList<>();
        Jone_courses.add(DSA);
        proflist.add(new Professor("Dr. Jones", "jones@iiitd.ac.in", "jones123", Jone_courses));

        List<Courses> Prereqs_CO = new ArrayList<>();
        Courses DC=new Courses("ECE101", "Digital_Circuits", "Dr. Josh", 4, noPrerequisites, "Mon-Wed-Fri 9AM-10AM");
        ProfessorCourses DC_course = new ProfessorCourses("ECE101", "Digital_Circuits", "Dr. Josh", 4, noPrerequisites, "Mon-Wed-Fri 9AM-10AM", "Basic programming concepts and hands-on coding.", 60, "Mon 2:00 PM - 3:00 PM");
        List<ProfessorCourses> Josh_courses = new ArrayList<>();
        Josh_courses.add(DC_course);
        proflist.add(new Professor("Dr. Josh", "josh@iiitd.ac.in", "josh123", Josh_courses));


        Prereqs_CO.add(DC);
        ProfessorCourses CO = new ProfessorCourses("ECE201", "Computer Organization", "Dr. Mary", 4, Prereqs_CO, "Mon-Wed 2PM-3:30PM,LHC-102", "Basic programming concepts and hands-on coding.", 120, "Fri 12:00 PM - 2:00 PM");
        List<ProfessorCourses> Mary_course = new ArrayList<>();
        Mary_course.add(CO);
        proflist.add(new Professor("Dr. Mary", "mary@iiitd.ac.in", "mary123", Mary_course));

        enrolled_students enrolled_students1 = new enrolled_students();
        enrolled_students1.add_student(new Student("Simar", "simar@iiitd.in", "simar123"));
        enrolled_students1.add_student(new Student("Rushil", "rushil@iiitd.in", "rushil123"));
        enrolled_students1.add_student(new Student("Arvind", "arvind@iiitd.in", "arvind123"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Are you a Student, Professor,Admin or Exit the app: ");
            String person = scanner.nextLine();

            if (person.equalsIgnoreCase("exit")) {
                break;
            } else if (person.equalsIgnoreCase("Student")) {
                System.out.println("Do you want to signup or login?: ");
                String welcome = scanner.nextLine();
                String email;
                String password;
                String name;
                Student newstudent = null;

                if (welcome.equalsIgnoreCase("signup")) {
                    System.out.println("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Create a password: ");
                    password = scanner.nextLine();
                    newstudent = new Student(name, email, password);
                    enrolled_students1.add_student(newstudent);


                } else {
                    System.out.println("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    boolean found = false;
                    for (Student student : enrolled_students.getstudentlist()) {  // Access shared list
                        if (student.getEmail().equals(email) && student.getPassword().equals(password)) {
                            newstudent = student;
                            found = true;
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println("Account not found, Creating a new one!");
                        newstudent = new Student(name, email, password);
                        enrolled_students1.add_student(newstudent);


                    }


                }

                Sem2 sem2 = new Sem2();  // Assuming Sem2 is defined somewhere else
                  // Add student to the shared list

                boolean flag = true;
                System.out.println("Welcome student, what do you want to do?: ");

                while (flag) {
                    System.out.println("1) View Available Courses ");
                    System.out.println("2) Register for Courses ");
                    System.out.println("3) View schedule ");
                    System.out.println("4) Track Academic progress ");
                    System.out.println("5) Drop Courses ");
                    System.out.println("6) Submit complaints ");
                    System.out.println("7) LOGOUT ");

                    String function = scanner.nextLine();
                    switch (function) {
                        case "1":
                            sem2.displayAvailableCourses();
                            break;

                        case "2":
                            System.out.println("Out of these courses, select your courses (enter the option number, enter -1 when done): ");
                            sem2.displayAvailableCourses();
                            int credit = 20; // Initial credit available to the student
                            int count = 0;
                            int numberOfCourses = sem2.availableCourses.size();
                            boolean[] visited = new boolean[numberOfCourses];

                            while (true) {
                                System.out.println("Enter the Course No: ");
                                int option = scanner.nextInt();
                                scanner.nextLine();

                                if (count >= numberOfCourses) {
                                    System.out.println("Maximum courses have been added.");
                                    break;
                                }
                                if (option == -1) {
                                    break;
                                }
                                if (option > numberOfCourses || option < 1) {
                                    System.out.println("Enter a valid option number! ");
                                    continue;
                                }
                                if (visited[option - 1]) {
                                    System.out.println("Course already registered! ");
                                    continue;
                                }

                                // Check if the student has completed the prerequisites
                                Courses selectedCourse = sem2.availableCourses.get(option - 1);
                                List<Courses> prerequisites = selectedCourse.getPrerequisites();
                                boolean prerequisitesCompleted = true;

                                for (Courses prereq : prerequisites) {
                                    boolean prereqCompleted = false;
                                    for (Courses completedCourse : newstudent.getCompletedCourses()) {
                                        if (completedCourse.getTitle().equals(prereq.getTitle())) {
                                            prereqCompleted = true;
                                            break;
                                        }
                                    }
                                    if (!prereqCompleted) {
                                        prerequisitesCompleted = false;
                                        break;
                                    }
                                }

                                if (!prerequisitesCompleted) {
                                    System.out.println("You have not completed the prerequisites for this course!");
                                    continue;
                                }

                                // Check if the student has enough credits remaining to register for the course
                                int courseCredits = selectedCourse.getCredits();
                                if (credit >= courseCredits) {
                                    visited[option - 1] = true;
                                    newstudent.register_courses(selectedCourse);
                                    credit -= courseCredits;
                                    count++;
                                    System.out.println("Course successfully registered!"); // Only printed once when a course is registered
                                } else {
                                    System.out.println("Not enough credits remaining to register for this course.");
                                }
                            }

                            newstudent.printRegisteredCourses();
                            break;
                        case "3":
                            newstudent.viewschedule();
                            break;

                        case "4":
                            newstudent.academic_progress();
                            System.out.println("The student's final CGPA: " + newstudent.getcgpa());
                            break;

                        case "5":
                            int size = newstudent.getRegisteredCourses().size();
                            System.out.println(size);

                            newstudent.printRegisteredCourses();
                            if (size == 0) {
                                break;
                            } else {
                                System.out.println("Enter the course option you want to remove: ");
                                int remove = scanner.nextInt();
                                scanner.nextLine(); // Consume the leftover newline

                                if ((remove - 1) < size && (remove - 1) >= 0) {
                                    newstudent.dropcourse(remove - 1);
                                } else {
                                    System.out.println("Enter a valid option! ");
                                }
                            }
                            System.out.println("Updated list for Registered Courses: ");
                            System.out.println();
                            newstudent.printRegisteredCourses();
                            break;

                        case "6":
                            System.out.println("Do you want to view your complaints or add a new one?(enter 'view' or 'add'): ");
                            String job = scanner.nextLine();
                            if (job.equalsIgnoreCase("view")) {
                                newstudent.viewcomplaints();
                            } else if (job.equalsIgnoreCase("add")) {
                                System.out.println("Enter a description of the complaint you want to submit to the authorities: ");
                                String description = scanner.nextLine();
                                newstudent.addcomplaint(description);
                                Complaints newcomplaint = new Complaints(description, newstudent.getName());
                                complaints.add(newcomplaint);
                                System.out.println("Successfully added complaint! ");
                            } else {
                                System.out.println("Invalid input");
                            }
                            break;

                        case "7":
                            System.out.println("Logging out...");
                            flag = false;
                            break;

                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
                }
            }
            // Professor implementation
            else if (person.equalsIgnoreCase("professor")) {
                System.out.println("Do you want to signup or login?: ");
                String welcome = scanner.nextLine();
                String email;
                String password;
                String name;
                Professor newprof = null;
                if (welcome.equalsIgnoreCase("signup")) {
                    System.out.println("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Create a password: ");
                    password = scanner.nextLine();
                    newprof = new Professor(name, email);
                } else {
                    System.out.println("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.println("Enter your email: ");
                    email = scanner.nextLine();
                    System.out.println("Enter your password: ");
                    password = scanner.nextLine();
                    boolean found = false;
                    for (Professor prof : proflist) {  // Access shared list
                        if (prof.getemail().equals(email) && prof.getname().equals(name)) {
                            newprof = prof;
                            found = true;
                            break;

                        }
                    }
                    if (!found) {
                        System.out.println("Account not found, Creating a new one!");
                        newprof = new Professor(name, email);


                    }


                }
                proflist.add(newprof);  // Add student to the shared list

                boolean flag = true;
                System.out.println("Welcome Professor, what do you want to do?: ");

                while (flag) {
                    System.out.println("1) View Assigned Courses ");
                    System.out.println("2) Change Syllabus,class timings,credits,office hours of a course: ");
                    System.out.println("3) View enrolled students: ");
                    System.out.println("4) LOGOUT ");

                    String function = scanner.nextLine();
                    switch (function) {
                        case "1":
                            newprof.veiwprofcourses();
                            break;

                        case "2":

                            newprof.changecoursedetails();
                            break;

                        case "3":
                            if (newprof.getprofcourses().isEmpty()) {
                                System.out.println("Admin has not assigned any courses yet!");


                            } else {
                                for (ProfessorCourses profcourse : newprof.getprofcourses()) {
                                    System.out.println("Course: " + profcourse.getTitle());
                                    System.out.println("Students Registered-");


                                    for (Student student : enrolled_students.getstudentlist()) {
                                        for (Courses courses : student.getRegisteredCourses()) {
                                            if (courses.getTitle().equals(profcourse.getTitle())) {
                                                System.out.println("Student: " + student.getName());
                                                System.out.println("Email: " + student.getEmail());
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case "4":
                            System.out.println("Logging out...");
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");
                    }
                }

            } else if (person.equalsIgnoreCase("admin")) {
                String email;
                String password;
                Admin admin = null;

                System.out.println("Welcome Admin Sign in to the System--");

                System.out.println("Enter the password(admin password is 123): ");
                password = scanner.nextLine();
                while (!(password.equals("123"))) {
                    System.out.println("Password is incorrect(admin password is 123)! Try again: ");
                    password = scanner.nextLine();


                }

                admin = new Admin(password);

                boolean flag = true;
                System.out.println("Welcome Admin, what do you want to do?: ");

                while (flag) {
                    System.out.println("1) View Courses: ");
                    System.out.println("2) Add Courses: ");
                    System.out.println("3) Delete Courses: ");
                    System.out.println("4) View Student Records: ");
                    System.out.println("5) View and manage complaints: ");
                    System.out.println("6) Assign professors to courses: ");
                    System.out.println("7) LOGOUT ");

                    String function = scanner.nextLine();
                    switch (function) {
                        case "1":
                            admin.veiewcourses();
                            break;

                        case "2":
                            admin.addcourse();
                            break;

                        case "3":
                            admin.deletecourse();
                            break;
                        case "4":
                            admin.viewstudentrecord(enrolled_students.studentList);
                            break;
                        case "5":
                            System.out.println("Do you want to view pending complaints or all complaints? ");
                            String choice = scanner.nextLine();
                            if(complaints.size()==0){
                                System.out.println("No complaint found");
                            }
                            else {

                                if (choice.equalsIgnoreCase("all")) {
                                    int count = 1;
                                    for (Complaints complaint : complaints) {
                                        System.out.println(count + ")");
                                        count++;
                                        System.out.println("Student name: " + complaint.getStudent_name());
                                        System.out.println("Complaint Description: " + complaint.getDescription());
                                        System.out.println("Status: " + complaint.getStatus());
                                        if (complaint.getStatus().equalsIgnoreCase("pending")) {
                                            System.out.println("Is this complaint resolved? ");
                                            String choice2 = scanner.nextLine();
                                            if (choice2.equalsIgnoreCase("yes")) {
                                                complaint.adminresolve();
                                                System.out.println("Complaint resolved! ");
                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                } else {
                                    int count = 1;
                                    for (Complaints complaint : complaints) {
                                        if (complaint.getStatus().equalsIgnoreCase("pending")) {
                                            System.out.println(count + ")");
                                            System.out.println("Student name: " + complaint.getStudent_name());
                                            System.out.println("Complaint Description: " + complaint.getDescription());
                                            System.out.println("Status: " + complaint.getStatus());
                                            System.out.println("Is this complaint resolved? ");
                                            String choice2 = scanner.nextLine();
                                            if (choice2.equalsIgnoreCase("yes")) {
                                                complaint.adminresolve();
                                                System.out.println("Complaint resolved! ");

                                            } else {
                                                continue;
                                            }
                                        }
                                    }
                                }
                            }
                            break;
                        case "6":
                            admin.assigncourse(proflist);
                            System.out.println("Course assigned successfully!");
                            break;
                        case "7":
                            System.out.println("Logging out...");
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid choice, please try again.");

                    }

                }
            }
        }
    }
}


