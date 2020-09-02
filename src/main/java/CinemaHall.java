import domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalTime;
import java.util.Arrays;

@Entity
@Table(name = "CINEMA_HALL")
public class CinemaHall extends BaseEntity {

    @Column
    @Min(1)
    private final int seatRows;

    @Column
    @Min(1)
    private final int seatColumns;

    @Transient
    private final Seat[][] seats;

//    @ManyToOne
//    @JoinColumn(name = "movie_id")
//    private Movie movie;

//    @Column
//    private String movieTime;

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

    public Seat[][] getSeats() {
        return seats;
    }

//    public Movie getMovie() {
//        return movie;
//    }

//    public void setMovie(Movie movie) {
//        this.movie = movie;
//    }

//    public String getMovieTime() {
//        return movieTime;
//    }

//    public void setMovieTime(String movieTime) {
//        this.movieTime = movieTime;
//    }

    public void reserveSeat(char row, int column) {
        this.seats[(int) row - 65][--column].setFree(false);
    }

    public void releaseSeat(char row, int column) {
        this.seats[(int) row - 65][--column].setFree(true);
    }

    void printSeats() {
        // printing screen
        System.out.print("  "); // space before screen
        for (int i = 0; i < seatColumns - 1; i++) {
            System.out.print("---");
        }
        System.out.print("-\n\n");
        // printing numbers of seats
        for (int i = 1; i <= seatColumns; i++) {
            System.out.printf("%3d",i);
            //System.out.print(i + "  ");
        }
        System.out.println();
        // printing seats
        // F - free, X - taken
        char letter = 'A';
        for (Seat[] row : seats) {
            System.out.print(letter++ + " ");
            for (Seat col : row) {
                if (col.isFree()) {
                    System.out.print("F");
                } else {
                    System.out.print("X");
                }
                System.out.print("  ");
            }
            System.out.println();
        }
    }

    private boolean isFull() {
        for (Seat[] row : seats) {
            for (Seat col : row) {
                if (col.isFree()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "CinemaHall{" +
                "seatRows=" + seatRows +
                ", seatColumns=" + seatColumns +
                ", seats=" + Arrays.toString(seats) +
                '}';
    }
}
