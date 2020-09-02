import domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import java.util.Arrays;

@Entity
@Table(name = "CINEMA_HALL")
public class CinemaHall extends BaseEntity {

    @Column
    private final String size;

    @Transient
    private final int seatRows;

    @Transient
    private final int seatColumns;

//    @Transient
//    private final Seat[][] seats;

    public CinemaHall(String size) {
        this.size = size;
        switch (size) {
            case "small":
                seatRows=5;
                seatColumns=10;
                break;
            case "medium":
                seatRows=8;
                seatColumns=15;
                break;
            case "big":
                seatRows=10;
                seatColumns=20;
                break;
            default:
                throw new IllegalArgumentException();
        }
//        this.seats = new Seat[seatRows][seatColumns];
//        for (int i = 0; i < seatRows; i++) {
//            for (int j = 0; j < seatColumns; j++) {
//                seats[i][j] = new Seat();
//            }
//        }
    }

    @Override
    public int getId() {
        return super.getId();
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

//    public void reserveSeat(char row, int column) {
//        this.seats[(int) row - 65][--column].setFree(false);
//    }
//
//    public void releaseSeat(char row, int column) {
//        this.seats[(int) row - 65][--column].setFree(true);
//    }

//    void printSeats() {
//        // printing screen
//        System.out.print("  "); // space before screen
//        for (int i = 0; i < seatColumns - 1; i++) {
//            System.out.print("---");
//        }
//        System.out.print("-\n\n");
//        // printing numbers of seats
//        for (int i = 1; i <= seatColumns; i++) {
//            System.out.printf("%3d", i);
//            //System.out.print(i + "  ");
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
//                System.out.print("  ");
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

    @Override
    public String toString() {
        return "CinemaHall{" +
                "size='" + size + '\'' +
                ", seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                '}';
    }
}
