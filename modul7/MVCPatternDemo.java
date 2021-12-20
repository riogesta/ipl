public class MVCPatternDemo {
    public static void main (String args []) {
        // fetch student record based on his roll no from the database
        Course model = retriveCourseFromDatabase();
        // create a view : to write course details on console
        courseView view = new courseView();
        courseController controller = new courseController(model, view);
        
        controller.updateView();

        // update data model
        controller.setCourseName("Python");
        System.out.println("\nAfter updating, course details are as follows");

        controller.updateView();
    }

    private static Course retriveCourseFromDatabase() {
        Course course = new Course();
        course.setName("Java");
        course.setId("01");
        course.setCategory("Programming");
        return course;
    }
}