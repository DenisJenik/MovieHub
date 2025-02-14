import java.util.Map;

public class Actor {
    String name;
    Map<String, Production> moviesAndShows;
    String bio;

    public Actor(String name, Map<String, Production> moviesAndShows, String bio) {
        this.name = name;
        this.moviesAndShows = moviesAndShows;
        this.bio = bio;
    }
    public void displayInfo() {
        System.out.println("Actor Name: " + name);
        System.out.println("Movies and Shows:");

        for (Map.Entry<String, Production> entry : moviesAndShows.entrySet()) {
            String filmName = entry.getKey();
            Production production = entry.getValue();
            System.out.println("  - " + filmName + " (" + production.getClass().getSimpleName() + ")");
        }

        System.out.println("Biography: " + bio);
    }
}
