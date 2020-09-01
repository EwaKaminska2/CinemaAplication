import dao.HibernateUtil;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

    public static void main(String[] args) {

        final SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Movie.class)
                .addAnnotatedClass(CinemaHall.class)
                .buildSessionFactory();

        HibernateUtil movieDao = new HibernateUtil(sessionFactory.createEntityManager(), Movie.class);
        HibernateUtil cinemaHallDao = new HibernateUtil(sessionFactory.createEntityManager(), CinemaHall.class);

        Movie movie1 = new Movie("zootopia");
        CinemaHall cinemaHall1 = new CinemaHall(5,10);

        movieDao.create(movie1);
        movieDao.printAll();

        cinemaHallDao.create(cinemaHall1);
        cinemaHallDao.printAll();

        movieDao.close();
        sessionFactory.close();
    }
}
