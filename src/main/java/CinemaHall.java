public class CinemaHall {

    private int id;
    private final int rows;
    private final int columns;
    private Seat[][] seats;
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

    public void setSeats(Seat[][] seats) {
        this.seats = seats;
    }

    public void printSeats() {
        // printing screen
        for (int i = 0; i < columns; i++) {
            System.out.print("-");
        }
        System.out.println("\n");
        // printing seats
        // F - free, X - taken
        for (Seat[] row : seats) {
            for (Seat col : row) {
                if (col.isFree()) {
                    System.out.print("F");
                } else {
                    System.out.print("X");
                }
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
