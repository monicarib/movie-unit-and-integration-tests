package com.example.movieunitandintegrationtests.integration;

import com.example.movieunitandintegrationtests.service.Movie;

public interface OmdbManagerService {
    Movie getMovieInformationByTitle(String title);
}
