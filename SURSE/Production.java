import java.util.ArrayList;
import java.util.List;

public abstract class Production implements Comparable {
    String title;
    List<String> directors;
    List<String> actors;
    List<Genre> genres;
    List<Rating> ratings;
    String description;
    Double score;



    public Production(String title, List<String> directors, List<String> actors, List<Genre> genres, String description) {
        this.title = title;
        this.directors = new ArrayList<>(directors);
        this.actors = new ArrayList<>(actors);
        this.genres = new ArrayList<>(genres);
        this.ratings = new ArrayList<>();
        this.description = description;
        this.score = 0.0;
    }

    public void addRating(Rating rating) {
        ratings.add(rating);
        recalculateScore();
    }

    private void recalculateScore() {
        if (!ratings.isEmpty()) {
            double totalScore = 0.0;
            for (Rating rating : ratings) {
                totalScore += rating.getGrade();
            }
            score = totalScore / ratings.size();
        }
    }

    public abstract void displayInfo();

    public int compareTo(Object o) {
        return this.title.compareTo(((Production) o).title);
    }
}
