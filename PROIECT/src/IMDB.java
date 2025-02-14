
import java.time.LocalDate;
import java.util.*;


public class IMDB {
    private static IMDB unique = null;

    private IMDB() {
        regulars = new ArrayList<>();
        contributors = new ArrayList<>();
        admins = new ArrayList<>();
        requests = new ArrayList<>();
        movies = new ArrayList<>();
        series = new ArrayList<>();
        actors = new ArrayList<>();
    }

    public static IMDB getInstance() {
        if (unique == null) {
            unique = new IMDB();
        }
        return unique;
    }

    ArrayList<Regular> regulars;
    ArrayList<Contributor> contributors;
    ArrayList<Admin> admins;
    ArrayList<Request> requests;
    ArrayList<Movie> movies;
    ArrayList<Series> series;
    ArrayList<Actor> actors;
    User CurentUser;

    public void run() {
        //custom info
        //user
        LocalDate date = LocalDate.of(2020, 1, 8);
        Credentials userCredentials = new Credentials("user@example.com", "password123");
        User.Information Usinformation = new User.Information.InformationBuilder(userCredentials, "user")
                .setAge(19)
                .setBirthday(date)
                .setGender('M')
                .setCountry("Columbia")
                .build();

        Regular useras = new Regular(Usinformation, AccountType.REGULAR, "user", 0);
        regulars.add(useras);

        //Movie
        List<String> directors = new ArrayList<>();
        directors.add("AlaDeIlFilmaPeBahoi");
        directors.add("Mickimaus");
        List<String> actors = new ArrayList<>();
        actors.add("Bahoi");
        actors.add("Podul");
        List<Genre> genres = new ArrayList<>();
        genres.add(Genre.ACTION);
        genres.add(Genre.COMEDY);
        List<Rating> ratings = new ArrayList<>();
        ratings.add(new Rating("User1", 8, "Foarte eu am fost podul"));
        ratings.add(new Rating("User2", 7, "Nice, eu am fost apa, 7 ca m-a durat"));

        Movie film = new Movie("Bahoi sare de pe pod", directors, actors, genres, ratings, "Description", 7.5, 120, 2022);
        movies.add(film);

        //actor
        Map<String, Production> moviesAndShows = new HashMap<>();
        moviesAndShows.put(film.title, film);
        Actor actorel = new Actor("Bahoi", moviesAndShows,"Merge secundele?");
        this.actors.add(actorel);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Selectați modul de utilizare:");
        System.out.println("1. Modul text (CLI)");
        System.out.println("2. Modul grafic (GUI)");

        int mode = scanner.nextInt();

        if (mode == 1) {
            runOnCLI();
        } else if (mode == 2) {
            runOnGUI();
        } else {
            System.out.println("Opțiune invalidă. Încercați din nou.");
            run();
        }
    }

    private void runOnCLI() {
        System.out.println("Aplicația rulează în modul text (CLI).");

        boolean isAuthenticated = authenticateUser();

        if (isAuthenticated) {
            System.out.println("Utilizator autentificat cu succes!");
            switch (CurentUser.userType){
                case REGULAR -> startFlowRegular(this.CurentUser);
                case CONTRIBUTOR -> startFlowContributor();
                case ADMIN -> startFlowAdmin();
            }
        } else {
            System.out.println("Autentificarea a eșuat. Închidere aplicație.");
        }
    }

    private boolean authenticateUser() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu adresa de email: ");
        String email = scanner.nextLine();

        System.out.print("Introdu parola: ");
        String password = scanner.nextLine();

        for (Regular regular : regulars) {
            if (regular.authenticate(email, password)) {
                CurentUser = regular;
                return true;
            }
        }

        for (Contributor contributor : contributors) {
            if (contributor.authenticate(email, password)) {
                CurentUser = contributor;
                return true;
            }
        }

        for (Admin admin : admins) {
            if (admin.authenticate(email, password)) {
                CurentUser = admin;
                return true;
            }
        }

        return false;
    }

    private void runOnGUI() {
        // Implementare pentru modul grafic (GUI)
        // Puteți utiliza o bibliotecă GUI, cum ar fi JavaFX sau Swing
    }

    void startFlowRegular(User actualUser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome back, " + actualUser.username + "!" );
        System.out.println("Username: " + actualUser.username);
        System.out.println("User experience: " + actualUser.experience);
        System.out.println("Choose action:");
        System.out.println("    1) View productions details");
        System.out.println("    2) View actors details");
        System.out.println("    3) View notifications");
        System.out.println("    4) Search for actor/movie/series");
        System.out.println("    5) Add/Delete actor/movie/series to/from favorites");
        System.out.println("    6) Request/Delete ticket");
        System.out.println("    7) Add/Delete review");
        System.out.println("    8) Log out");
        System.out.print("Choose: ");
       while (this.CurentUser != null) {
           Integer choosen = scanner.nextInt();
           scanner.nextLine();
           System.out.println();
           System.out.println();
           switch (choosen) {
               case 1:
                   for (Movie muvi : this.movies) {
                       muvi.displayInfo();
                   }
                   break;
               case 2:
                    for (Actor actuela : this.actors) {
                        actuela.displayInfo();
                    }
                   break;
               case 3:

                   break;
               case 4:

                   break;
               case 5:

                   break;
               case 6:

                   break;
               case 7:

                   break;
               case 8:
                    this.CurentUser = null;
                   break;
               default:
                   System.out.println("Invalid choice. Please choose a number from 1 to 8.");
                   break;
           }
           System.out.println();
           System.out.println();
           System.out.println("Choose another option(1-8): ");
       }
        System.out.println("Successfully loged out!");
        System.out.println("    1) Login");
        System.out.println("    2) Exit");
        System.out.print("Choose: ");
        Integer choosen = scanner.nextInt();
        scanner.nextLine();
        if (choosen == 1) {
            runOnCLI();
        }
    }

    void startFlowContributor() {

    }
    void startFlowAdmin(){

    }
}


