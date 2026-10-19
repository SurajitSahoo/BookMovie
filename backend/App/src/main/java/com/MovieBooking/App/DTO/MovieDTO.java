package com.MovieBooking.App.DTO;



import java.time.LocalDate;

public class MovieDTO {
    private String name;
    private String description;
    private String genre;
    private Integer duration;
    private LocalDate releaseDate;
    private String language;
    private String imageUrl;

    public MovieDTO(String name, String description, String genre, Integer duration, LocalDate releaseDate, String language, String imageUrl) {
        this.name = name;
        this.description = description;
        this.genre = genre;
        this.duration = duration;
        this.releaseDate = releaseDate;
        this.language = language;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "MovieDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", releaseDate=" + releaseDate +
                ", language='" + language + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
