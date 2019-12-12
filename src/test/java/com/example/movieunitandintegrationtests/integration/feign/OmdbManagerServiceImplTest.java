package com.example.movieunitandintegrationtests.integration.feign;

import com.example.movieunitandintegrationtests.BaseIntegrationTest;
import com.example.movieunitandintegrationtests.integration.OmdbManagerService;
import com.example.movieunitandintegrationtests.integration.exception.OmdbIntegrationException;
import com.example.movieunitandintegrationtests.service.Movie;
import kotlin.jvm.JvmField;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(stubs = {"classpath:/stubs"})
public class OmdbManagerServiceImplTest extends BaseIntegrationTest {

    @Autowired
    private OmdbManagerService omdbManagerService;

    @Rule
    @JvmField
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void whenSearchingForMovieInformationByTitleIfThereAreInformationShouldReturnThem() {
        Movie movie = omdbManagerService.getMovieInformationByTitle("The Green Mile");

        Assert.assertNotNull(movie);
        Assert.assertNotNull(movie.getTitle());
        Assert.assertNotNull(movie.getDirector());
        Assert.assertNotNull(movie.getGenre());
        Assert.assertNotNull(movie.getImdbRating());
        Assert.assertNotNull(movie.getPlot());
        Assert.assertNotNull(movie.getReleased());
        Assert.assertNotNull(movie.getRuntime());
    }

    @Test
    public void whenSearchingForMovieInformationByTitleIfMovieDoesNotExistShouldThrowException() {
        expectedException.expect(OmdbIntegrationException.class);
        expectedException.expectMessage("Movie not found!");

        omdbManagerService.getMovieInformationByTitle("This is an example, it does not exist.");
    }
}
