import java.util.List;

public class Movie extends Production {
    private int durationInMinutes;
    private int launchYear;

    public Movie(String title, List<String> directors, List<String> actors, List<Genre> genres,
                 List<Rating> ratings, String description, Double score, int durationInMinutes, int launchYear) {
        super(title, directors, actors, genres,description);
        this.title = title;
        this.directors = directors;
        this.actors = actors;
        this.genres = genres;
        this.ratings = ratings;
        this.description = description;
        this.score = score;
        this.durationInMinutes = durationInMinutes;
        this.launchYear = launchYear;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public int getLaunchYear() {
        return launchYear;
    }

    @Override
    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Directors: " + directors);
        System.out.println("Actors: " + actors);
        System.out.println("Genres: " + genres);
        System.out.println("Ratings: " + ratings);
        System.out.println("Description: " + description);
        System.out.println("Score: " + score);
        System.out.println("Duration: " + durationInMinutes + " minutes");
        System.out.println("Launch Year: " + launchYear);
    }
}
