package sandbox;

public class Movie {

    private String title;
    private String director;
    private String genre;
    private int year;
    private boolean deleted;

    public Movie(String title, String director, String genre, int year) {
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.year = year;
        this.deleted = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void delete() {
        this.deleted = true;
    }

}
