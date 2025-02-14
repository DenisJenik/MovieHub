import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class Regular extends User implements RequestsManager {
    public Regular(User.Information information, AccountType type, String username, int experience) {
      super(information, type, username, experience);
    }


    void giveRating(Production production, int rating, String comments) {
        if (userType == AccountType.REGULAR) {
            if (isValidRating(rating)) {
                Rating userRating = new Rating(username, rating, comments);
                production.addRating(userRating);
                updateExperience();
            } else {
                System.out.println("Invalid rating. Please provide a rating between 1 and 10.");
            }
        } else {
            System.out.println("Only regular users can rate productions.");
        }
    }
    private boolean isValidRating(int rating) {
        return rating >= 1 && rating <= 10;
    }

    // FACTORY
    @Override
    public void createRequest(Request r) {
        IMDB.getInstance().requests.add(r);
    }

    @Override
    public void removeRequest(Request r) {
        IMDB.getInstance().requests.remove(r);
    }

    @Override
    UserFactory getUserFactory() {
        return new UserFactory();
    }
}
