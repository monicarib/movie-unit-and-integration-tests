package com.example.movieunitandintegrationtests.integration;

import com.example.movieunitandintegrationtests.integration.exception.OmdbIntegrationErrorCodeEnum;
import com.example.movieunitandintegrationtests.integration.exception.OmdbIntegrationException;
import com.example.movieunitandintegrationtests.service.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OmdbManagerServiceImpl implements OmdbManagerService {

    @Value("${integration.omdb.api.key}")
    private String omdbApiKey;

    private OmdbApi omdbApi;

    @Autowired
    public OmdbManagerServiceImpl(OmdbApi omdbApi) {
        this.omdbApi = omdbApi;
    }

    @Override
    public Movie getMovieInformationByTitle(String title) {
        OmdbMovieInformationResponse omdbMovieInformationResponse = omdbApi.getMovieInformation(title, omdbApiKey);

        if (omdbMovieInformationResponse.response.equalsIgnoreCase("False")) {
            throw new OmdbIntegrationException(OmdbIntegrationErrorCodeEnum.TITLE_NOT_FOUND, omdbMovieInformationResponse.getError());
        }

        Movie movie = new Movie();
        movie.setDirector(omdbMovieInformationResponse.getDirector());
        movie.setGenre(omdbMovieInformationResponse.getGenre());
        movie.setImdbRating(omdbMovieInformationResponse.getImdbRating());
        movie.setPlot(omdbMovieInformationResponse.getPlot());
        movie.setReleased(omdbMovieInformationResponse.getReleased());
        movie.setRuntime(omdbMovieInformationResponse.getRuntime());
        movie.setTitle(omdbMovieInformationResponse.getTitle());

        return movie;
    }
}
