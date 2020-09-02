import domain.BaseEntity;

import javax.persistence.*;

@Entity
@Table(name = "CINEMA_SHOW")
public class CinemaShow extends BaseEntity {

    @OneToOne
    @JoinColumn(name = "cinema_hall_id")
    private CinemaHall cinemaHall;

    @OneToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Column(name = "movie_time")
    private String movieTime;

    @Transient
    private final CinemaHallSchedule cinemaHallSchedule;

    public CinemaShow(CinemaHallSchedule cinemaHallSchedule, Movie movie) {
        this.cinemaHall = cinemaHallSchedule.getCinemaHall();
        this.movie = movie;
        this.movieTime = cinemaHallSchedule.getMovieHour();
        this.cinemaHallSchedule = cinemaHallSchedule;
    }

    @Override
    public int getId() {
        return super.getId();
    }

    public CinemaHall getCinemaHall() {
        return cinemaHall;
    }

    public void setCinemaHall(CinemaHall cinemaHall) {
        this.cinemaHall = cinemaHall;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getMovieTime() {
        return movieTime;
    }

    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public CinemaHallSchedule getCinemaHallSchedule() {
        return cinemaHallSchedule;
    }

    @Override
    public String toString() {
        return "Seans{" +
                "cinemaHall=" + cinemaHall +
                ", movie=" + movie +
                ", movieTime='" + movieTime + '\'' +
                '}';
    }
}
