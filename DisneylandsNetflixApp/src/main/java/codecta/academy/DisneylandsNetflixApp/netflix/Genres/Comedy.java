package codecta.academy.DisneylandsNetflixApp.netflix.Genres;

import codecta.academy.DisneylandsNetflixApp.netflix.Actors.Actor;
import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Comedy implements Genre{
    @Override
    public String getName() { return "Comedy"; }

    @Override
    public List<Movie> getMovies() {
        //Movies
        String movie1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Dumb and dumber\\Dumb and dumber.txt";
        String movie2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Home Alone\\Home Alone.txt";

        //Movie 1 actors
        String actor1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Dumb and dumber\\Actors\\Jeff Daniels.txt";
        String actor2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Dumb and dumber\\Actors\\Jim Carrey.txt";
        //Movie 2 actors
        String actor3FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Home Alone\\Actors\\Daniel Stern.txt";
        String actor4FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Home Alone\\Actors\\Joe Pesci.txt";
        String actor5FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Comedy\\Home Alone\\Actors\\Macaulay Culkin.txt";

        List<Movie> movies = new ArrayList<Movie>();
        //movie Dumb and dumber
        Movie dumbAndDumber = new Movie();
        dumbAndDumber.generateMovie(movie1FileName);

        Actor actor1 = new Actor();
        actor1.generateActor(actor1FileName);
        dumbAndDumber.addActor(actor1);

        Actor actor2 = new Actor();
        actor2.generateActor(actor2FileName);
        dumbAndDumber.addActor(actor2);

        //movie Home Alone
        Movie homeAlone = new Movie();
        homeAlone.generateMovie(movie2FileName);

        Actor actor3 = new Actor();
        actor3.generateActor(actor3FileName);
        homeAlone.addActor(actor3);

        Actor actor4 = new Actor();
        actor4.generateActor(actor4FileName);
        homeAlone.addActor(actor4);

        Actor actor5 = new Actor();
        actor5.generateActor(actor5FileName);
        homeAlone.addActor(actor5);

        movies.add(dumbAndDumber);
        movies.add(homeAlone);

        return movies;
    }

    @Override
    public String getColor() {
        return "\u001B[34m";//blue
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
