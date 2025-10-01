import java.util.*;

class EmptyStudentListException extends Exception {
    public EmptyStudentListException(String msg) {
        super(msg);
    }
}

public class StudentList {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent(String name) {
        students.add(name);
    }

    public void removeStudent(String name) {
        if (!students.remove(name))
            System.out.println(name + " not found!");
    }

    public void displayStudents() throws EmptyStudentListException {
        if (students.isEmpty())
            throw new EmptyStudentListException("Student list is empty!");
        Collections.sort(students);
        System.out.println("Sorted names: " + students);
    }

    public static void main(String[] args) {
        StudentList list = new StudentList();

        System.out.println("Adding names: Alice, Bob, Charlie");
        list.addStudent("Alice");
        list.addStudent("Bob");
        list.addStudent("Charlie");

        try { list.displayStudents(); } 
        catch (Exception e) { System.out.println("Error: " + e.getMessage()); }

        System.out.println("Removing Bob...");
        list.removeStudent("Bob");
        try { list.displayStudents(); } 
        catch (Exception e) { System.out.println("Error: " + e.getMessage()); }

        list.removeStudent("Alice");
        list.removeStudent("Charlie");

        System.out.println("Attempting to display empty list...");
        try { list.displayStudents(); } 
        catch (Exception e) { System.out.println("Error: " + e.getMessage()); }
    }
}
