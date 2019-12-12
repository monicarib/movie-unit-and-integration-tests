package com.example.movieunitandintegrationtests.integration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRatingResponse {

    @JsonProperty("Source")
    public String source;

    @JsonProperty("Value")
    public String value;

}
