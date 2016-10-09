package ie.nuigalway.ct475.a1.p1;

import java.util.ArrayList;
import java.util.HashMap;

public class Module {

    public String moduleName;
    public String moduleID;
    private final HashMap<Integer, Student> students = new HashMap();

    public Module(final String name, final String id) {
        this.moduleName = name;
        this.moduleID = id;
    }

    public void addStudent(final Student student) {
        this.students.put(student.getStudentID(), student);
        student.addModule(this);
    }

    public void addStudents(final ArrayList<Student> students) {
        for (final Student student : students) {
            this.students.put(student.getStudentID(), student);
            student.addModule(this);
        }
    }

    public ArrayList<Student> getStudents() {
        return new ArrayList<>(students.values());
    }

    public String getModuleID() {
        return moduleID;
    }

    public String getModuleName() {
        return moduleName;
    }

    @Override
    public String toString() {
        return this.moduleID + " : " + this.moduleName;
    }
}
