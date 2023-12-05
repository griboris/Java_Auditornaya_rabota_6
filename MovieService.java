package rtu.mirea.gribunov.task2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public interface MovieService {
    @GET("https://raw.githubusercontent.com/prust/wikipedia-movie-data/master/movies.json")
    Call<List<MovieDTO>> getMovies();
}
