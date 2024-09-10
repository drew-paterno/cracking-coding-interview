package sandbox;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

public class CsvImporter {

    private static final String PATH = "C:\\Users\\drewp\\OneDrive\\Desktop\\sandbox\\cracking-coding-interview\\src\\sandbox\\movies.csv";

    public static void main(String[] args) {

        List<Movie> movies = new ArrayList<>();
        Map<DirectorAndGenre, List<Movie>> moviesByDirectorAndGenre = new HashMap<>();
        Set<Movie> moviesByReleaseYear = new TreeSet<>(Comparator.comparing(Movie::getYear));

        long moviesProcessed = 0;
        try(Stream<String> lines = Files.lines(Path.of(PATH))) {
            moviesProcessed = lines.skip(1) // skip header
                    .map(line -> line.split(","))
                    .map(data -> new Movie(data[0], data[1], data[2], Integer.parseInt(data[3])))
                    .peek(movies::add)
                    .peek(movie -> {
                        var key = new DirectorAndGenre(movie.getDirector(), movie.getGenre());
                        moviesByDirectorAndGenre.computeIfAbsent(key, k -> new ArrayList<>()).add(movie);
                    })
                    .peek(moviesByReleaseYear::add)
                    .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Movies processed: " + moviesProcessed);

        movies.get(2).delete();

        System.out.println("Movies processed: " + moviesProcessed);

    }

}
