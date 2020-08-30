public class CinemaHall {

    private int id;
    private final int rows;
    private final int columns;
    private final Seat[][] seats;
    private Movie movie;

    public CinemaHall(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.seats = new Seat[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                seats[i][j] = new Seat();
            }
        }

    }

    public int getId() {
        return id;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void reserveSeat(int row, int column) {
        this.seats[--row][--column].setFree(false);
    }

    public void releaseSeat(int row, int column) {
        this.seats[--row][--column].setFree(true);
    }

    public void printSeats() {
        // printing screen
        System.out.print("  "); // space before screen
        for (int i = 0; i < columns * 2 - 1; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        // printing numbers of seats
        System.out.print("  "); // space before numbers
        for (int i = 1; i <= columns; i++) {
            System.out.print(i + " ");
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
                System.out.print(" ");
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

}
