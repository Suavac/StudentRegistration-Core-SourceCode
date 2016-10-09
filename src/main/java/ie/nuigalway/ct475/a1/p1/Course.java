package ie.nuigalway.ct475.a1.p1;

import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;

public class Course {

    private final DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-mm-yyyy");
    private final String courseName;
    private final HashMap<String, Module> modules = new HashMap();
    private final HashMap<Integer, Student> students = new HashMap();
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Course(final String courseName, final String startDate, final String endDate) {
        this.courseName = courseName;
        this.startDate = this.dtf.parseLocalDate(startDate);
        this.endDate = dtf.parseLocalDate(endDate);
    }

    public void addModule(final Module module) {
        this.modules.put(module.getModuleID(), module);
        for (final Student student : module.getStudents()) {
            students.put(student.getStudentID(), student);
            student.addCourse(this);
        }
    }

    public ArrayList<Module> getModules() {
        return new ArrayList<>(modules.values());
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public String getCourseName() {
        return this.courseName;
    }

    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    @Override
    public String toString() {
        return this.courseName + "\n Programme" + this.startDate.toString() + " - " + this.endDate.toString();
    }
}
