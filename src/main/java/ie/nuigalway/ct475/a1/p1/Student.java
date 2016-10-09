package ie.nuigalway.ct475.a1.p1;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;

public class Student {

    private final DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-mm-yyyy");

    private Course course;
    private final ArrayList<Module> modules = new ArrayList();

    private final int studentID;
    private final String studentName;
    private final LocalDate dob;
    private final String username;

    public Student(final String name, final String dob, final int id) {
        this.studentName = name;
        this.dob = dtf.parseLocalDate(dob);
        this.studentID = id;
        this.username = generateUsername();
    }

    public String getStudentName() {
        return this.studentName;
    }

    public LocalDate getDob() {
        return this.dob;
    }

    public int getStudentID() {
        return this.studentID;
    }

    public void addCourse(final Course course) {
        this.course = course;
    }

    public String getUsername() {
        return this.username;
    }

    public Course getCourseName() {
        return this.course;
    }

    public String getAge() {
        return Integer.toString(new LocalDate().now().getYear() - dob.getYear());
    }

    public String generateUsername() {
        return this.studentName.replaceAll(" ", "") + getAge();
    }


    public void addModule(final Module module) {
        modules.add(module);
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    @Override
    public String toString() {
        return this.studentName + " : " + this.studentID;
    }
}