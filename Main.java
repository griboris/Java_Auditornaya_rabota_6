package rtu.mirea.gribunov.task2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
        // Инициализация ObjectMapper с JsonMapper
        ObjectMapper objectMapper = JsonMapper.builder().build();

        // Инициализация Retrofit с JacksonConverterFactory
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/")
                .addConverterFactory(JacksonConverterFactory.create(objectMapper))
                .build();

        // Создание экземпляра интерфейса
        MovieService movieService = retrofit.create(MovieService.class);

        // Выполнение запроса
        Call<List<MovieDTO>> call = movieService.getMovies();
        List<MovieDTO> movies = call.execute().body();

        // Найти фильм до 2000 года с самым большим количеством актеров
        MovieDTO topMovie = movies.stream()
                .filter(movie -> movie.getYear() <= 2000)
                .max((movie1, movie2) -> Integer.compare(movie1.getCast().size(), movie2.getCast().size()))
                .orElse(null);

        // Вывести информацию о фильме
        if (topMovie != null) {
            System.out.println("Название фильма: " + topMovie.getTitle());
            System.out.println("Год выпуска: " + topMovie.getYear());
            System.out.println("Количество актеров: " + topMovie.getCast().size());
        } else {
            System.out.println("Фильм не найден.");
        }
    }
}

