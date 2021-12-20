public class MVCPatternDemo {
    public static void main (String args []) {
        Student model = retriveStudentFromDatabase();
        studentView view = new studentView();
        studentController controller = new studentController(model, view);

        controller.updateView();
        controller.setStudentName("rio");
        controller.updateView();
    }

    private static Student retriveStudentFromDatabase() {
        Student student = new Student();
        student.setName("gesta");
        student.setRollNo("10");
        return student;
    }
}