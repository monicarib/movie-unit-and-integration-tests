package com.example.movieunitandintegrationtests.service;

import com.example.movieunitandintegrationtests.integration.OmdbManagerService;
import org.junit.Assert;
import org.junit.Before;
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

    private Movie movie;

    @Before
    public void setUp(){

        movie = new Movie();
        movie.setGenre("Drama");
        movie.setImdbRating("9.1");
        movie.setPlot("Resumo do filme");
        movie.setRuntime("1h");
        movie.setReleased("23 Nov 2010");
        movie.setTitle("The Green Mile");
        movie.setDirector("Test");

    }

    @Test
    public void whenGettingAMovieInformationByTitleIfMovieIsRecommendedShouldReturnTrue() {
        //given
        String title = "The Green Mile";
        movie.setTitle(title);
        movie.setImdbRating("9.1");

        Mockito.when(omdbManagerService.getMovieInformationByTitle(title)).thenReturn(movie);

        //when
        Movie movieReceived = movieService.getMovieInformationByTitle(title);

        //then
        Assert.assertNotNull(movieReceived);
        Assert.assertEquals(movie.getGenre(), movieReceived.getGenre());
        Assert.assertTrue(movieReceived.getRecommended());
    }

    @Test
    public void whenGettingAMovieInformationByTitleIfMovieIsNotRecommendedShouldReturnFalse() {
        //given
        movie.setImdbRating("2.3");

        Mockito.when(omdbManagerService.getMovieInformationByTitle(movie.getTitle())).thenReturn(movie);

        //when
        Movie movieReceived = movieService.getMovieInformationByTitle(movie.getTitle());

        //then
        Assert.assertNotNull(movieReceived);
        Assert.assertEquals(movie.getGenre(), movieReceived.getGenre());
        Assert.assertFalse(movieReceived.getRecommended());
    }
}