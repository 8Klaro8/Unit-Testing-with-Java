package src.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Before;
import org.junit.Test;

import src.main.models.Movie;
import src.main.models.Store;

public class StoreTest {

    Store store;

    @Before
    public void setup() {
        store = new Store();
        store.addMovie(new Movie("Hercules", "Blue-Ray", 9.2));
        store.addMovie(new Movie("Avatar", "Blue-Ray", 10));
        // store.addMovie(new Movie("Kung-Fu Panda", "DVD", 9));

        // store.sellMovie(new Movie("Hercules", "Blue-Ray", 9.2));

        store.rentMovie("Avatar");

    }

    @Test
    public void movieAdded() {
        assertTrue(store.contains(new Movie("Hercules", "Blue-Ray", 9.2)));
    }

    @Test
    public void sellMovieTest() {
        assertFalse(store.contains(new Movie("Hercules", "Blue-Ray", 9.2)));
    }

    @Test
    public void rentMovieTest() {
        store.rentMovie("Avatar");
        assertFalse(store.getMovie(1).isAvailable());
    }

    @Test
    public void returnMovieTest() {
        store.returnMovie("Avatar");
        assertTrue(store.getMovie(1).isAvailable());
    }
}
