import java.util.List;

public interface Semester {
    void initializeCourses();   // Initialize courses for the semester
    List<Courses> getAvailableCourses();   // Get list of available courses
    void displayAvailableCourses();   // Display courses
    void deletecourses();   // Delete a course
    void pre_assigned_grades();   // Pre-assign grades to courses
    void assign_grades();   // Assign grades manually
}
