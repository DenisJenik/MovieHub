import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Series extends Production {
    int launchYear;
    int numberOfSeasons;
    private Map<String, ArrayList<Episode>> seasons;

    public Series(String title, List<String> directors, List<String> actors, List<Genre> genres, String description) {
        super(title, directors, actors, genres, description);
    }

    @Override
    public void displayInfo() {

    }

}
