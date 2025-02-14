public class Contributor extends Staff implements RequestsManager {
    public Contributor(User.Information information, AccountType type, String username, int experience) {
        super(information, type, username, experience);
    }

    // FACTORY
    @Override
    public void createRequest(Request r) {

    }

    @Override
    public void removeRequest(Request r) {

    }
}
