package codecta.academy.DisneylandsNetflixApp.netflix.Genres;

import codecta.academy.DisneylandsNetflixApp.netflix.Actors.Actor;
import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Thriller implements Genre{

    @Override
    public String getName() { return "Thriller"; }

    @Override
    public List<Movie> getMovies() {
        //Movies
        String movie1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Snowden\\Snowden.txt";
        String movie2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Unfriended - Dark Web\\Unfriended - Dark Web.txt";

        //Movie 1 actors
        String actor1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Snowden\\Actors\\Joseph Gordon-Levitt.txt";
        String actor2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Snowden\\Actors\\Melissa Leo.txt";
        //Movie 2 actors
        String actor3FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Unfriended - Dark Web\\Actors\\Heather Sossaman.txt";
        String actor4FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Thriller\\Unfriended - Dark Web\\Actors\\Matthew Bohrer.txt";

        List<Movie> movies = new ArrayList<Movie>();
        //movie Snowden
        Movie snowden = new Movie();
        snowden.generateMovie(movie1FileName);

        Actor actor1 = new Actor();
        actor1.generateActor(actor1FileName);
        snowden.addActor(actor1);

        Actor actor2 = new Actor();
        actor2.generateActor(actor2FileName);
        snowden.addActor(actor2);

        //movie Unfriended - Dark Web
        Movie unfriendedDarkWeb = new Movie();
        unfriendedDarkWeb.generateMovie(movie2FileName);

        Actor actor3 = new Actor();
        actor3.generateActor(actor3FileName);
        unfriendedDarkWeb.addActor(actor3);

        Actor actor4 = new Actor();
        actor4.generateActor(actor4FileName);
        unfriendedDarkWeb.addActor(actor4);

        movies.add(snowden);
        movies.add(unfriendedDarkWeb);

        return movies;
    }

    @Override
    public String getColor() {
        return "\u001B[35m";//purple
    }

    @Override
    public void present() {
        String name = this.getName();

        String color = this.getColor();
        String resetColor = "\u001B[0m";

        List<Movie> movies = this.getMovies();
        System.out.printf("You have selected the %s%S%s genre. Currently available movies in %s%S%s genre are: \n",color,name,resetColor,color, name,resetColor);
        for (int i = 0;i < movies.size();i++){
            System.out.printf("%d.%s%s%s\n",i+1,color, movies.get(i).getMovieTitle(),resetColor);
        }
    }
}
