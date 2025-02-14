import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

public abstract class User {
    Information userInfo;
    AccountType userType;
    String username;
    int experience;
    ArrayList<String> notifications;
    SortedSet<Object> favourites;

    class UserFactory {
        public User factory(User.Information information, AccountType type, String username, int experience) {
            if (type == AccountType.REGULAR) {
                return new Regular(information, type, username, experience);
            } else if (type == AccountType.CONTRIBUTOR) {
                return new Contributor(information, type, username, experience);
            } else if (type == AccountType.ADMIN) {
                return new Admin(information, type, username, experience);
            }
            return null;
        }
    }


    abstract UserFactory getUserFactory();
    public User(UserFactory userFactory, String username, Credentials credentials, Information.InformationBuilder informationBuilder, AccountType userType) {
        this.username = username;
        this.userInfo = informationBuilder.build();
        this.userType = userType;
        this.notifications = new ArrayList<>();
        this.favourites = new TreeSet<>();
        this.experience = 0; // Ajustat în funcție de tipul de utilizator
        this.userInfo.userCredentials = credentials;
    }

    public User(User.Information information, AccountType type, String username, int experience) {
        this.userInfo = information;
        this.userType = type;
        this.username = username;
        this.experience = experience;
        this.favourites = new TreeSet<>();
        this.notifications = new ArrayList<>();
    }

    public static class Information {
        private Credentials userCredentials;
        private String name;
        private String country;
        private int age;
        private char gender;
        private LocalDate birthday;

        private Information(InformationBuilder builder) {
            this.userCredentials = builder.userCredentials;
            this.name = builder.name;
            this.country = builder.country;
            this.age = builder.age;
            this.gender = builder.gender;
            this.birthday = builder.birthday;
        }

        // Getters pentru a accesa atributele

        public static class InformationBuilder {
            private Credentials userCredentials;
            private String name;
            private String country;
            private int age;
            private char gender;
            private LocalDate birthday;

            public InformationBuilder(Credentials userCredentials, String name) {
                this.userCredentials = userCredentials;
                this.name = name;
            }

            public InformationBuilder setCountry(String country) {
                this.country = country;
                return this;
            }

            public InformationBuilder setAge(int age) {
                this.age = age;
                return this;
            }

            public InformationBuilder setGender(char gender) {
                this.gender = gender;
                return this;
            }

            public InformationBuilder setBirthday(LocalDate birthday) {
                this.birthday = birthday;
                return this;
            }

            public Information build() {
                return new Information(this);
            }
        }
    }

    void addFavourite(Object o) {

    }

    void removeFavourite(Object o) {

    }

    void updateExperience() {

    }

    boolean authenticate(String email, String pass) {
        if (!email.equals(this.userInfo.userCredentials.getEmail()))
            return false;
        if(!pass.equals(this.userInfo.userCredentials.getPassword()))
            return false;

        return true;
    }
    void logOut() {

    }
}
