# UniversityManagementSystem
------------------------------------------


Overview--
This is a Java-based University Management System designed to facilitate interactions between students, professors, and administrators. The system offers features such as course registration, student record management, complaint management, and course assignment.

Assumptions--
All instantiated students are assumed to be in semester 2 and have completed semester 1. Grades for semester 1 are not yet assigned.
The system can be extended to accommodate additional semesters as needed.

Application Flow--
Run the Mainapp.java file
---------------------------
User Role Selection:

Users are prompted to choose their role (Student, Professor, or Admin).
Based on the role, they can either Log in or signup.
Student Module:

Login/Signup: Students can Log in or signup. Admins can only Log in with a fixed password.
Available Actions:
View available courses
Register for courses
View their schedule
Track academic progress
Drop courses
Submit complaints
Implementation: Methods are implemented in the Student class.
Professor Module:

Available Actions:
View assigned courses
Change course details (syllabus, class timings, credits, office hours)
View enrolled students
Implementation: Methods are implemented in the Professor class.
Admin Module:

Available Actions:
View courses
Add courses
Delete courses
View student records
View and manage complaints
Assign professors to courses
Implementation: Methods are implemented in the Admin class.
How OOP Concepts Are Applied
Classes and Objects:

Student: Manages student-related operations.
Professor: Manages professor-related operations.
Admin: Manages administrative operations.
Semesters: Represents semester-related functionalities.
Sem1, Sem2: Specific implementations of semesters.
Courses: Represents courses.
ProfessorCourses: Extends Courses to include additional details like office hours and syllabus.
Interfaces:

Semester Interface: Defines important methods and attributes, implemented by Sem1 and Sem2.
Inheritance:

ProfessorCourses inherits from Courses, adding extra details such as office hours and syllabus.
Polymorphism:

Method Overloading: Used in the Courses class to initialize prerequisites, allowing flexibility in method signatures.
Additional examples of polymorphism are present throughout the system for varying implementations of methods.

UML link--
https://lucid.app/lucidchart/1cad1237-c0bf-412b-bb6c-7494e2da5967/edit?viewport_loc=-1324%2C-2237%2C8199%2C4439%2CHWEp-vi-RSFO&invitationId=inv_a6e8e4ae-df0c-46d4-b8da-ddf1e32ce085


