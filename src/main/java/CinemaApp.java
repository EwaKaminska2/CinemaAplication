import dao.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CinemaApp {

    public static void main(String[] args) {

        // beginning of hibernate app
        SessionFactory sessionFactory = createSessionFactory();
        HibernateUtil movieDao = new HibernateUtil(sessionFactory.createEntityManager(), Movie.class);
        HibernateUtil cinemaHallDao = new HibernateUtil(sessionFactory.createEntityManager(), CinemaHall.class);
        HibernateUtil filmShowDao = new HibernateUtil(sessionFactory.createEntityManager(), CinemaShow.class);

        Movie movie1 = new Movie("zootopia");
        Movie movie2 = new Movie("wonder woman");
        Movie movie3 = new Movie("black widow");
        Movie movie4 = new Movie("once upon a time in hollywood");

        List<Movie> movies = new LinkedList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);

        CinemaHall smallCinemaHall = new CinemaHall("small");
        CinemaHall mediumCinemaHall = new CinemaHall("medium");
        CinemaHall bigCinemaHall = new CinemaHall("big");

        CinemaHallSchedule cinemaHallSchedule1 = new CinemaHallSchedule("12:00", smallCinemaHall);
        CinemaHallSchedule cinemaHallSchedule2 = new CinemaHallSchedule("15:00", smallCinemaHall);
        CinemaHallSchedule cinemaHallSchedule3 = new CinemaHallSchedule("20:00", smallCinemaHall);
        CinemaHallSchedule cinemaHallSchedule4 = new CinemaHallSchedule("13:30", mediumCinemaHall);
        CinemaHallSchedule cinemaHallSchedule5 = new CinemaHallSchedule("17:00", mediumCinemaHall);
        CinemaHallSchedule cinemaHallSchedule6 = new CinemaHallSchedule("19:30", mediumCinemaHall);
        CinemaHallSchedule cinemaHallSchedule7 = new CinemaHallSchedule("10:00", bigCinemaHall);
        CinemaHallSchedule cinemaHallSchedule8 = new CinemaHallSchedule("16:00", bigCinemaHall);
        CinemaHallSchedule cinemaHallSchedule9 = new CinemaHallSchedule("21:00", bigCinemaHall);

        CinemaShow cinemaShow1 = new CinemaShow(cinemaHallSchedule1, movie1);
        CinemaShow cinemaShow2 = new CinemaShow(cinemaHallSchedule2, movie2);
        CinemaShow cinemaShow3 = new CinemaShow(cinemaHallSchedule3, movie4);
        CinemaShow cinemaShow4 = new CinemaShow(cinemaHallSchedule4, movie3);
        CinemaShow cinemaShow5 = new CinemaShow(cinemaHallSchedule5, movie2);
        CinemaShow cinemaShow6 = new CinemaShow(cinemaHallSchedule6, movie2);
        CinemaShow cinemaShow7 = new CinemaShow(cinemaHallSchedule7, movie1);
        CinemaShow cinemaShow8 = new CinemaShow(cinemaHallSchedule8, movie2);
        CinemaShow cinemaShow9 = new CinemaShow(cinemaHallSchedule9, movie3);

        List<CinemaShow> cinemaShowList = new LinkedList<>();
        cinemaShowList.add(cinemaShow1);
        cinemaShowList.add(cinemaShow2);
        cinemaShowList.add(cinemaShow3);
        cinemaShowList.add(cinemaShow4);
        cinemaShowList.add(cinemaShow5);
        cinemaShowList.add(cinemaShow6);
        cinemaShowList.add(cinemaShow7);
        cinemaShowList.add(cinemaShow8);
        cinemaShowList.add(cinemaShow9);

        movieDao.create(movie1);
        movieDao.create(movie2);
        movieDao.create(movie3);
        movieDao.create(movie4);

        cinemaHallDao.create(smallCinemaHall);
        cinemaHallDao.create(mediumCinemaHall);
        cinemaHallDao.create(bigCinemaHall);

        filmShowDao.create(cinemaShow1);
        filmShowDao.create(cinemaShow2);
        filmShowDao.create(cinemaShow3);
        filmShowDao.create(cinemaShow4);
        filmShowDao.create(cinemaShow5);
        filmShowDao.create(cinemaShow6);
        filmShowDao.create(cinemaShow7);
        filmShowDao.create(cinemaShow8);
        filmShowDao.create(cinemaShow9);

        cinemaHallDao.close();
        movieDao.close();
        sessionFactory.close();
        // end of hibernate app

        // main sequence
        Scanner scanner = new Scanner(System.in);
        int step;
        System.out.println("Welcome to the best cinema!");

        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Buy tickets");
            System.out.println("2. Show movies info");
            System.out.println("3. Cancel your reservation");
            System.out.println("Exit");
            step = scanner.nextInt();
            switch (step) {
                case 1:
                    // buy tickets

                    // show titles
                    System.out.println("Choose movie");
                    showMovieTitles(movies);
                    int movieId = scanner.nextInt();
                    // show hours
                    System.out.println("Choose hour of chosen movie");
                    List<Integer> showsId = showMovieHours(cinemaShowList, movieId);
                    CinemaShow chosenShow = cinemaShowList.get(showsId.get(scanner.nextInt() - 1) - 1);
                    // if chosen movie has full cinema hall
                    if (chosenShow.getCinemaHallSchedule().isFull()) {
                        System.out.println("Sorry, cinema hall is full");
                    } else {
                        // choose number of tickets
                        System.out.println("Choose number of tickets");
                        int numberOfTickets = scanner.nextInt();
                        // choose tickets type (normal, reduced)
                        boolean ticketsQuantityOK;
                        int normalTickets;
                        int reducedTickets;
                        do {
                            System.out.println("Choose tickets type");
                            System.out.println("Normal tickets quantity:");
                            normalTickets = scanner.nextInt();
                            System.out.println("Reduced tickets quantity:");
                            reducedTickets = scanner.nextInt();
                            ticketsQuantityOK = normalTickets + reducedTickets == numberOfTickets;
                            if (!ticketsQuantityOK || normalTickets < 0 || reducedTickets < 0) {
                                System.out.println("Wrong tickets quantity");
                            }
                        } while (!ticketsQuantityOK);
                        // choose seats
                        System.out.println("Choose available seat on cinema hall");
                        System.out.println("F - free seat, X - taken seat");
                        chosenShow.getCinemaHallSchedule().printSeats();
                        System.out.println("First type row, then enter, then type column");
                        int reservedSeats = 0;
                         while (reservedSeats < numberOfTickets) {
                            scanner.nextLine();
                            char row = scanner.nextLine().toUpperCase().charAt(0);
                            int col = scanner.nextInt();
                            if (chosenShow.getCinemaHallSchedule().reserveSeat(row,col)) {
                                reservedSeats++;
                            } else {
                                System.out.println("Seat already taken");
                            }
                        }
                         // pay
                        int bill = calculateBill(normalTickets, reducedTickets);
                        System.out.println("Thank you, the amount to pay is: " + bill);
                    }
                    break;
                case 2:
                    // show movies
                    for (Movie movie : movies) {
                        movie.showInfo();
                    }
                    break;
                case 3:
                    // cancel reservation
                    break;
                default:
                    System.out.println("Bye, bye");
            }
        } while (step > 0 && step <= 3);

    }

    private static SessionFactory createSessionFactory() {
        return new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(CinemaHall.class)
                .addAnnotatedClass(CinemaShow.class)
                .buildSessionFactory();
    }

    private static void showMovieTitles(List<Movie> movies) {
        for (Movie movie : movies) {
            System.out.printf("%d. %s\n", movie.getId(), movie.getTitle());
        }
    }

    private static List<Integer> showMovieHours(List<CinemaShow> cinemaShowList, int movieId) {
        int i = 1;
        List<Integer> showsId = new LinkedList<>();
        for (CinemaShow cinemaShow : cinemaShowList) {
            if (cinemaShow.getMovie().getId() == movieId) {
                System.out.printf("%d. %s\n", i, cinemaShow.getMovieTime());
                showsId.add(cinemaShow.getId());
                i++;
            }
        }
        return showsId;
    }

    private static int calculateBill(int normalTickets, int reducedTickets) {
        return normalTickets * 20 + reducedTickets * 10;
    }
}
