package sandbox;

import java.util.Objects;

public class DirectorAndGenre {

    private final String director;
    private final String genre;

    public DirectorAndGenre(String director, String genre) {
        this.director = director;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(director, genre);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DirectorAndGenre directorAndGenre) {
            return this.director.equals(directorAndGenre.getDirector()) && this.genre.equals(directorAndGenre.getGenre());
        } else {
            return false;
        }
    }

}
