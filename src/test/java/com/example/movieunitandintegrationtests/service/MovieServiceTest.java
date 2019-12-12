package com.example.movieunitandintegrationtests.service;

import com.example.movieunitandintegrationtests.integration.OmdbManagerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class MovieServiceTest {

    @Mock
    private OmdbManagerService omdbManagerService;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void whenTheMovieExistsAndItIsRecommendedShouldReturnItWithTrue() {
        Movie expectedMovie = new Movie();
        expectedMovie.setTitle("Joker");
        expectedMovie.setRuntime("122 min");
        expectedMovie.setReleased("04 Oct 2019");
        expectedMovie.setPlot("In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker.");
        expectedMovie.setImdbRating("8.7");
        expectedMovie.setGenre("Crime, Drama, Thriller");

        Mockito.when(omdbManagerService.getMovieInformationByTitle(expectedMovie.getTitle())).thenReturn(expectedMovie);

        Movie returnedMovie = movieService.getMovieInformationFromTitle(expectedMovie.getTitle());

        Assert.assertNotNull(returnedMovie);
        Assert.assertTrue(returnedMovie.getRecommended());
        Assert.assertEquals(expectedMovie.getRuntime(), returnedMovie.getRuntime());
        Assert.assertEquals(expectedMovie.getReleased(), returnedMovie.getReleased());
        Assert.assertEquals(expectedMovie.getPlot(), returnedMovie.getPlot());
        Assert.assertEquals(expectedMovie.getImdbRating(), returnedMovie.getImdbRating());
        Assert.assertEquals(expectedMovie.getDirector(), returnedMovie.getDirector());
        Assert.assertEquals(expectedMovie.getGenre(), returnedMovie.getGenre());
        Assert.assertEquals(expectedMovie.getTitle(), returnedMovie.getTitle());
    }

}