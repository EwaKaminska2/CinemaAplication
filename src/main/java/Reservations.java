import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Reservations {

    private String first_name;
    private String last_name;
    private Integer row;
    private Integer seat;
    private boolean isBooking;

    Scanner scanner = new Scanner(System.in);



    public Reservations(){
        first_name = "";
        last_name = "";
        row=0;
        seat=0;
        isBooking=false;
    }
    public Reservations(String first_name, String last_name, Integer row, Integer seat, boolean isBooking) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.row = row;
        this.seat = seat;
        this.isBooking = isBooking;
    }

    public void booking(){
        if(isBooking){
            System.out.println("Miejsce już jest zarezerwowane");
        }
        else {
            System.out.println("Podaj imię: ");
            String first_name = scanner.nextLine();

            System.out.println("Podaj nazwisko: ");
            String last_name = scanner.nextLine();

            isBooking = true;
            System.out.println("Miejsce: "+ row+" "+seat+" "+" jest zarezerwowane dla "+first_name+ " "+last_name);
        }

    }

    public void deleteBooking(){
        if(isBooking){
            first_name = "";
            last_name="";

            isBooking = false;
            System.out.println("Rezerwacja anulowana");
        }
        else {
            System.out.println("Nie ma takiej reerwacji");
        }

    }

}
