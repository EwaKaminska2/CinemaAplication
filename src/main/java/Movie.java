public class Movie {

    private final String title;
    private final String director;
    private final String type;
    private final int year;

    public Movie(String title, String director, String type, int year) {
        this.title = title;
        this.director = director;
        this.type = type;
        this.year = year;
    }

    public void showInfo(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", director='" + director + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                '}';
    }
}
