import dao.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(CinemaHall.class)
                .addAnnotatedClass(CinemaShow.class)
                .buildSessionFactory();

        HibernateUtil movieDao = new HibernateUtil(sessionFactory.createEntityManager(), Movie.class);
        HibernateUtil cinemaHallDao = new HibernateUtil(sessionFactory.createEntityManager(), CinemaHall.class);
        HibernateUtil filmShowDao = new HibernateUtil(sessionFactory.createEntityManager(), CinemaShow.class);

        Movie movie1 = new Movie("zootopia");
        Movie movie2 = new Movie("wonder woman");
        Movie movie3 = new Movie("black widow");
        Movie movie4 = new Movie("once upon a time in hollywood");
        CinemaHall cinemaHall1 = new CinemaHall(5,15);
        CinemaHall cinemaHall2 = new CinemaHall(7,20);
        CinemaHall cinemaHall3 = new CinemaHall(10,25);
        CinemaShow cinemaShow1 = new CinemaShow(cinemaHall1,movie1,"13:00");
        CinemaShow cinemaShow2 = new CinemaShow(cinemaHall2,movie4,"18:00");

        movieDao.create(movie1);
        movieDao.create(movie2);
        movieDao.create(movie3);
        movieDao.create(movie4);
        movieDao.printAll();

        cinemaHallDao.create(cinemaHall1);
        cinemaHallDao.create(cinemaHall2);
        cinemaHallDao.create(cinemaHall3);
        cinemaHallDao.printAll();

        filmShowDao.create(cinemaShow1);
        filmShowDao.create(cinemaShow2);
        filmShowDao.printAll();


        cinemaHallDao.close();
        movieDao.close();
        sessionFactory.close();
    }
}
