import java.util.Scanner;

public class Cinema {
Scanner scanner = new Scanner(System.in);
    private int seatsNumber = 40;
    private Reservations[] allSeats;

    public Cinema() {

        int i = 0;
        for (i = 0; i < seatsNumber; i++) {
            allSeats[i] = seats("","",i+1,false);

        }
    }

    private Reservations seats(String s, String s1, int i, boolean b) {
        return seats("","",i,false);
    }


    public void showAllSeats(){
        int i = 0;

        for ( i = 0; i < seatsNumber; i++) {
            allSeats[i].printSeats();

        }
    }
    public void selectSeats(){
        System.out.println(" Wybierz numer miejsca:  ");
        int yourSeat = scanner.nextInt();

        if((yourSeat <= 0) || (yourSeat > seatsNumber)){
            if(yourSeat!=0){
                yourSeat=0;
                System.out.println("Nie ma takiego miejsca");
            }
        }
    }
    public void addReservation(int yourSeat){
        selectSeats();
        if(yourSeat!=0){
            allSeats[yourSeat-1].booking();
        }
    }

public void selectDate(){}

public void bookingTicket(){}

public void chooseIfYouWantLogin(){}
}
