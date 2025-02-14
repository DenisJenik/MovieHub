import java.util.Scanner;

public class Credentials {
    private String password;
    private String email;

    public Credentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Metodă pentru a seta credențiale noi
    public void setCredentials(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword(){ return password; }


    public boolean checkCredentials(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void completeCredentials() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdu adresa de email: ");
        String email = scanner.nextLine();

        System.out.print("Introdu parola: ");
        String password = scanner.nextLine();

        setCredentials(email, password);
    }
}
