import java.util.ArrayList;
import java.util.List;

public class University {

    List<Student> students = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Course> courses = new ArrayList<>();

    public List<Course> findCoursesByStudentId(String document){
        List<Course> coursesStudent = new ArrayList<>();
        for (Course course : courses){
            for (Student student : course.getStudentList()){
                if (student.getDocument().equals(document)){
                    coursesStudent.add(course);
                    break;
                }
            }
        }
        return coursesStudent;
    }

}
