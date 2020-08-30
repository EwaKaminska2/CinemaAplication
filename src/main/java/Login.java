import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Login {

    private String first_name;
    private String last_name;
    private String password;
    private Integer accountNumber;
    private String login;





    public void signIn() throws FileNotFoundException {


        Scanner scan = new Scanner(new File("C:\\Users\\48501\\IdeaProjects\\CinemaAplication\\src\\main\\java.logi.txt"));
        Scanner keyboard = new Scanner(System.in);
        String user = scan.nextLine();
        String pass = scan.nextLine(); // looks at selected file in scan
        if (scan == null) throw new FileNotFoundException("Brak pliku");
        else {

            String inpUser = keyboard.nextLine();
            String inpPass = keyboard.nextLine(); // gets input from user

            if (inpUser.equals(user) && inpPass.equals(pass)) {
                System.out.print("You are logged in");
            } else {
                System.out.print("Wrong login or password");
            }

        }
    }
    private void logOut(){}
}
