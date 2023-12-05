package rtu.mirea.gribunov.task2;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
class MovieDTO {
    @JsonProperty("title")
    private String title;

    @JsonProperty("year")
    private int year;

    @JsonProperty("cast")
    private List<String> cast;

    @JsonIgnore
    private List<String> genres;


    MovieDTO() {
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public List<String> getCast() {
        return cast;
    }

    public List<String> getGenres() {
        return genres;
    }

}