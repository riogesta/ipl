public class Course {
    
    private String courseName;
    private String courseId;
    private String courseCategory;

    public String getId() {
        // mengembalikan nilali id course
        return courseId;
    }

    public void setId(String id) {
        this.courseId = id;
    }

    public String getName() {
        return courseName;
    }

    public void setName(String name) {
        this.courseName = name;
    }

    public String getCategory() {
        return courseCategory;
    }

    public void setCategory(String category) {
        this.courseCategory = category;
    }
}