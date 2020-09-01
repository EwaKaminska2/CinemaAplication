import domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import java.time.LocalTime;

@Entity
@Table(name = "CINEMA_HALL")
public class CinemaHall extends BaseEntity {

    @Column
    @Min(1)
    private final int seatRows;

    @Column
    @Min(1)
    private final int seatColumns;


    private final Seat[][] seats;


    private Movie movie;


    String movieTime;

    public CinemaHall(int rows, int columns) {
        this.seatRows = rows;
        this.seatColumns = columns;
        this.seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat();
            }
        }
    }

    public int getId() {
        return getId();
    }

    public int getSeatRows() {
        return seatRows;
    }

    public int getSeatColumns() {
        return seatColumns;
    }

//    public Seat[][] getSeats() {
//        return seats;
//    }
//
//    public Movie getMovie() {
//        return movie;
//    }
//
//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }
//
//    public void reserveSeat(char row, int column) {
//        this.seats[(int) row - 65][--column].setFree(false);
//    }
//
//    public void releaseSeat(char row, int column) {
//        this.seats[(int) row - 65][--column].setFree(true);
//    }
//
//    void printSeats() {
//        // printing screen
//        System.out.print("  "); // space before screen
//        for (int i = 0; i < columns * 2 - 1; i++) {
//            System.out.print("-");
//        }
//        System.out.println("\n");
//        // printing numbers of seats
//        System.out.print("  "); // space before numbers
//        for (int i = 1; i <= columns; i++) {
//            System.out.print(i + " ");
//        }
//        System.out.println();
//        // printing seats
//        // F - free, X - taken
//        char letter = 'A';
//        for (Seat[] row : seats) {
//            System.out.print(letter++ + " ");
//            for (Seat col : row) {
//                if (col.isFree()) {
//                    System.out.print("F");
//                } else {
//                    System.out.print("X");
//                }
//                System.out.print(" ");
//            }
//            System.out.println();
//        }
//    }
//
//    private boolean isFull() {
//        for (Seat[] row : seats) {
//            for (Seat col : row) {
//                if (col.isFree()) {
//                    return false;
//                }
//            }
//        }
//        return true;
//    }

}
