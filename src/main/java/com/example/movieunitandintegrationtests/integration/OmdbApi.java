package com.example.movieunitandintegrationtests.integration;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface OmdbApi {
    @RequestLine("GET /?apikey={apikey}&t={t}")
    OmdbMovieInformationResponse getMovieInformation(@Param("t") String title, @Param("apikey") String apiKey);
}
