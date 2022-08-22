package src.main.models;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie) {
        this.movies.add(new Movie(movie));
    }

    public int getMovieIndex(String name) {
        // Filter using stream
        // return IntStream.range(0, this.movies.size())
        //         .filter((i) -> this.movies.get(i).getName().equalsIgnoreCase(name))
        //         .findFirst()
        //         .orElse(-1000);

        // Filter using loop
        for (int i = 0; i < movies.size(); i++) {
        if (movies.get(i).getName().equalsIgnoreCase(name)) {
        movies.get(i).setAvailable(false);
        return i;
        }
        }
        return -1000;
    }

    public void returnMovie(String movieTitle) {
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getName().equalsIgnoreCase(movieTitle)) {
                movies.get(i).setAvailable(true);
            }
        }
    }

    public void rentMovie(String name) {
        getMovie(getMovieIndex(name)).setAvailable(false);

        // for (int i = 0; i < movies.size(); i++) {
        //     if (movies.get(i).getName().equalsIgnoreCase(name)) {
        //         movies.get(i).setAvailable(false);
        //     }
        // }
    }

    public void sellMovie(Movie movieInput) {
        for (int i = 0; i < movies.size(); i++) {
            // if (movies.get(i).equals(movieInput));
            // movies.remove(movieInput);
            // }

            // if (movies.get(i).getName().equalsIgnoreCase(movieInput.getName())) {
            // movies.remove(i);
            // }

            this.movies.removeIf((movie) -> movie.getName().equalsIgnoreCase(movieInput.getName()));
        }
    }

    public boolean contains(Movie movie) {
        return movies.contains(movie);
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
