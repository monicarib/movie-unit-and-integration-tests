package com.example.movieunitandintegrationtests.api;

public class MovieResponse {
    private String title;
    private String released;
    private String runtime;
    private String genre;
    private String director;
    private String plot;
    private String imdbRating;
    private Boolean isRecommended;

    public MovieResponse(String title, String released, String runtime, String genre, String director, String plot, String imdbRating, Boolean isRecommended) {
        this.title = title;
        this.released = released;
        this.runtime = runtime;
        this.genre = genre;
        this.director = director;
        this.plot = plot;
        this.imdbRating = imdbRating;
        this.isRecommended = isRecommended;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReleased() {
        return released;
    }

    public void setReleased(String released) {
        this.released = released;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Boolean getRecommended() {
        return isRecommended;
    }

    public void setRecommended(Boolean recommended) {
        isRecommended = recommended;
    }
}
