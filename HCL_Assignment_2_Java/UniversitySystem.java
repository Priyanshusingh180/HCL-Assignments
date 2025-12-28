import java.util.*;
import java.util.regex.*;

class UniStudent {
    int id;
    String name, course;
    int marks;

    UniStudent(int id, String name, String course, int marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }
}

public class UniversitySystem {
    ArrayList<UniStudent> students = new ArrayList<>();
    Set<String> courses = new HashSet<>();
    HashMap<Integer, UniStudent> map = new HashMap<>();

    void addStudent(UniStudent s) {
        if (map.containsKey(s.id))
            throw new IllegalArgumentException("Duplicate Student");
        students.add(s);
        map.put(s.id, s);
        courses.add(s.course);
    }

    void displayStudents() {
        for (UniStudent s : students)
            System.out.println(s.id + " " + s.name + " " + s.marks);
    }

    void sortByMarks() {
        students.sort((a, b) -> b.marks - a.marks);
    }

    void convertToTreeMap() {
        TreeMap<Integer, UniStudent> tm = new TreeMap<>(map);
        System.out.println("Converted to TreeMap");
    }

    void courseWiseCount() {
        HashMap<String, Integer> count = new HashMap<>();
        for (UniStudent s : students)
            count.put(s.course, count.getOrDefault(s.course, 0) + 1);
        System.out.println(count);
    }

    public static void main(String[] args) {
        UniversitySystem us = new UniversitySystem();
        try {
            us.addStudent(new UniStudent(1, "Aman", "CS", 80));
            us.addStudent(new UniStudent(2, "Rohit", "IT", 90));
            us.displayStudents();
            us.sortByMarks();
            us.courseWiseCount();
            us.convertToTreeMap();
            System.out.println("Courses: " + us.courses);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
