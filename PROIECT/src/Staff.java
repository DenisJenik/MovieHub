import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public class Staff extends User implements StaffInterface {
    ArrayList<Request> requests;
    SortedSet<Object> added;

    public Staff(User.Information information, AccountType type, String username, int experience) {
        super(information, type, username, experience);
        this.requests = new ArrayList<>();
        this.added = new TreeSet<>();
    }


    @Override
    public void addProductionSystem(Production p) {

    }

    @Override
    public void addActorSystem(Actor a) {

    }

    @Override
    public void removeProductionSystem(String name) {

    }

    @Override
    public void removeActorSystem(String name) {

    }

    @Override
    public void updateProduction(Production p) {

    }

    @Override
    public void updateActor(Actor a) {

    }

    @Override
    UserFactory getUserFactory() {
        return null;
    }
}
