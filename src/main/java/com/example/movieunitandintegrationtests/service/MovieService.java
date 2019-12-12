package com.example.movieunitandintegrationtests.service;

import com.example.movieunitandintegrationtests.integration.OmdbManagerService;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private OmdbManagerService omdbManagerService;

    public MovieService(OmdbManagerService omdbManagerService) {
        this.omdbManagerService = omdbManagerService;
    }

    public Movie getMovieInformationFromTitle(String title) {
        Movie movie = omdbManagerService.getMovieInformationByTitle(title);
        setIfMovieIsRecommendedOrNot(movie);

        return movie;
    }

    private void setIfMovieIsRecommendedOrNot(Movie movie) {
        if (Float.parseFloat(movie.getImdbRating()) >= 7.1) {
            movie.setRecommended(true);
        } else {
            movie.setRecommended(false);
        }
    }
}
