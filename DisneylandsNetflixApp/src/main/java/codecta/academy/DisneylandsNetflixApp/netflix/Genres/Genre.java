package codecta.academy.DisneylandsNetflixApp.netflix.Genres;

import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.util.List;

public interface Genre {
    public String getName();
    public List<Movie> getMovies();
    public String getColor();
    public void present();
}
