package com.example.movieunitandintegrationtests.api;

import com.example.movieunitandintegrationtests.service.Movie;
import com.example.movieunitandintegrationtests.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public MovieResponse getMovieInformationByTitle(@RequestParam(name = "title") String title) {
        Movie movie = movieService.getMovieInformationByTitle(title);

        return new MovieResponse(movie.getTitle(), movie.getReleased(), movie.getRuntime(), movie.getGenre(),
                movie.getDirector(), movie.getPlot(), movie.getImdbRating(), movie.getRecommended());

    }
}
