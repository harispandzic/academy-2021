package codecta.academy.DisneylandsNetflixApp.netflix.Genres;

import codecta.academy.DisneylandsNetflixApp.netflix.Actors.Actor;
import codecta.academy.DisneylandsNetflixApp.netflix.Main;
import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Action implements Genre {

    @Override
    public String getName() {
        return "Action";
    }
    @Override
    public List<Movie> getMovies() {
        //Movies
        String movie1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Rambo\\Rambo.txt";
        String movie2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Terminator\\Terminator.txt";

        //Movie 1 actors
        String actor1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Rambo\\Actors\\Graham McTavish.txt";
        String actor2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Rambo\\Actors\\Julie Benz.txt";
        String actor3FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Rambo\\Actors\\Sylvester Stalone.txt";
        //Movie 2 actors
        String actor4FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Terminator\\Actors\\Arnold Schwarzenegger.txt";
        String actor5FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Terminator\\Actors\\Linda Hamilton.txt";
        String actor6FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Action\\Terminator\\Actors\\Mackenzie Davis.txt";

        List<Movie> movies = new ArrayList<Movie>();
        //movie Rambo
        Movie rambo = new Movie();
        rambo.generateMovie(movie1FileName);

        Actor actor1 = new Actor();
        actor1.generateActor(actor1FileName);
        rambo.addActor(actor1);

        Actor actor2 = new Actor();
        actor2.generateActor(actor2FileName);
        rambo.addActor(actor2);

        Actor actor3 = new Actor();
        actor3.generateActor(actor3FileName);
        rambo.addActor(actor3);

        //movie Terminator
        Movie terminator = new Movie();
        terminator.generateMovie(movie2FileName);

        Actor actor4 = new Actor();
        actor4.generateActor(actor4FileName);
        terminator.addActor(actor4);

        Actor actor5 = new Actor();
        actor5.generateActor(actor5FileName);
        terminator.addActor(actor5);

        Actor actor6 = new Actor();
        actor6.generateActor(actor6FileName);
        terminator.addActor(actor6);

        movies.add(rambo);
        movies.add(terminator);

        return movies;
    }
    @Override
    public String getColor() {
        return "\u001B[31m";//red
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
