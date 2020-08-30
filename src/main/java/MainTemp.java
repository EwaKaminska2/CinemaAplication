public class MainTemp {
    public static void main(String[] args) {

        CinemaHall cinemaHall = new CinemaHall(4,8);

        cinemaHall.printSeats();

        cinemaHall.reserveSeat(3,4);

        cinemaHall.printSeats();
    }
}
