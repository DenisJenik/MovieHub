import java.util.List;

public class Admin extends Staff {
    // FACTORY

    public Admin(User.Information information, AccountType type, String username, int experience) {
        super(information, type, username, experience);
    }
}
