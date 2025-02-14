public class Rating {
    private String username;
    private int grade;
    private String comments;

    public Rating(String username, int grade, String comments) {
        this.username = username;
        this.grade = grade;
        this.comments = comments;
    }

    public String getUsername() {
        return username;
    }

    public int getGrade() {
        return grade;
    }

    public String getComments() {
        return comments;
    }

}
