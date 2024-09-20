import java.util.*;
import java.util.Scanner;
public class Admin{

    private String password;
    private Sem1 sem1;
    private Sem2 sem2;
    Scanner scanner=new Scanner(System.in);
    Admin(String password){

        this.password=password;
        sem1=new Sem1();
        sem2=new Sem2();
    }
    public void veiewcourses(){
        sem1.displayAvailableCourses();
        System.out.println();
        sem2.displayAvailableCourses();
    }
    public void deletecourse(){
        System.out.println("Select the semester you want to delete course from: ");
        int option=scanner.nextInt();
        if(option==1){
            sem1.deletecourses();
        }
        else if(option==2){
            sem2.deletecourses();
        }


    }
    public void addcourse(){
        System.out.println("Select the semester you want to add course for: ");
        int option=scanner.nextInt();
        scanner.nextLine();

        if(option==1){
            System.out.println("Enter the course code: ");
            String courseCode = scanner.nextLine();
            System.out.println("Enter the course title: ");
            String title = scanner.nextLine();
//            System.out.println("Enter the professor's name: ");
//            String professor = scanner.nextLine();
            System.out.println("Enter the number of credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine();
            List<Courses> prerequisites = new ArrayList<>();            System.out.println("Enter the course timings: ");
            String timings = scanner.nextLine();

            Courses newcourse = new Courses(courseCode, title, "NA", credits, prerequisites, timings);
            sem1.availableCourses.add(newcourse);
            System.out.println("Course added successfully!");
            sem1.displayAvailableCourses();




        }else if(option==2){
            System.out.println("Enter the course code: ");
            String courseCode = scanner.nextLine();
            System.out.println("Enter the course title: ");
            String title = scanner.nextLine();
            System.out.println("Enter the professor's name: ");
            String professor = scanner.nextLine();
            System.out.println("Enter the number of credits: ");
            int credits = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter the course timings: ");
            String timings = scanner.nextLine();

            Courses newcourse = new Courses(courseCode, title, professor, credits, timings);
            sem2.availableCourses.add(newcourse);
            System.out.println("Course added successfully!");
            sem2.displayAvailableCourses();

        }
    }
    public void assigncourse(List<Professor> proflist){
        System.out.println("Select the semester of the course you want to change the professor of: ");
        int option=scanner.nextInt();
        scanner.nextLine();

        if(option==1){
            System.out.println("Select the course number you want to assign the professor of: ");
            sem1.displayAvailableCourses();
            int option2=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the new professor name: ");
            String prof_name=scanner.nextLine();
            System.out.println("Enter the new professor email: ");
            String prof_email=scanner.nextLine();


            boolean found = false;
            for (Professor prof : proflist) {  // Access shared list
                if (prof.getemail().equals(prof_email) && prof.getname().equals(prof_name)) {
                    sem1.availableCourses.get(option2-1).setprof(prof_name);
                    prof.addcourse(sem1.availableCourses.get(option2-1),"No syllabus yet",60,"Not assigned");
                    found = true;
                    break;

                }
            }
            if (!found) {
                sem1.availableCourses.get(option2-1).setprof(prof_name);

                Professor newprof=new Professor(prof_name,prof_email);
                newprof.addcourse(sem1.availableCourses.get(option2-1),"No syllabus yet",60,"Not assigned");
                proflist.add(newprof);




            }



        }
        if(option==2){
            System.out.println("Select the course number you want to assign the professor of: ");
            sem2.displayAvailableCourses();
            int option2=scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the new professor name: ");
            String prof_name=scanner.nextLine();
            System.out.println("Enter the new professor email: ");
            String prof_email=scanner.nextLine();
            boolean found = false;
            for (Professor prof : proflist) {  // Access shared list
                if (prof.getemail().equals(prof_email) && prof.getname().equals(prof_name)) {
                    sem2.availableCourses.get(option2-1).setprof(prof_name);

                    prof.addcourse(sem2.availableCourses.get(option2-1),"No syllabus yet",60,"Not assigned");
                    found = true;
                    break;

                }
            }
            if (!found) {
                sem2.availableCourses.get(option2-1).setprof(prof_name);

                Professor newprof=new Professor(prof_name,prof_email);
                newprof.addcourse(sem2.availableCourses.get(option2-1),"No syllabus yet",60,"Not assigned");
                proflist.add(newprof);




            }



        }




    }
    public void viewstudentrecord(List<Student> students){
        int count=1;
        for(Student student:students){
            System.out.println(count+")");
            count++;


            System.out.println("Student name: "+student.getName());
            System.out.println("Student email: "+student.getEmail());
            System.out.println("Do you want to view the grade and courses of the student(yes or no)?");
            String choice=scanner.nextLine();
            if(choice.equalsIgnoreCase("yes")){
                for(Courses courses:student.getCompletedCourses()){
                    System.out.println("Course title: "+ courses.getTitle());
                    System.out.println("Course Grade: "+ courses.getGrades());
                    System.out.println("Do you want to change the grade(yes or no)?: ");
                    String choice2=scanner.nextLine();

                    if(choice2.equalsIgnoreCase("yes")){
                        System.out.println("Enter the new grade: ");
                        int grade=scanner.nextInt();
                        scanner.nextLine();
                        courses.setgrades(grade);
                        System.out.println("Grade updated!! ");





                    }
                    else{
                        continue;
                    }








                }
            }else if(choice.equalsIgnoreCase("no")){
                continue;
            }






        }

    }










}

