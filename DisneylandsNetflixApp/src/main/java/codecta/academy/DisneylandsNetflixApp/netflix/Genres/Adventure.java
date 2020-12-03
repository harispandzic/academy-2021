package codecta.academy.DisneylandsNetflixApp.netflix.Genres;

import codecta.academy.DisneylandsNetflixApp.netflix.Actors.Actor;
import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.util.ArrayList;
import java.util.List;

public class Adventure implements Genre {
    @Override
    public String getName() {
        return "Adventure";
    }
    @Override
    public List<Movie> getMovies() {
        //Movies
        String movie1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\Mr. Bean's Holiday\\Mr. Bean's Holiday.txt";
        String movie2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\The Call of the Wild\\The Call of the Wild.txt";

        //Movie 1 actors
        String actor1FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\Mr. Bean's Holiday\\Actors\\Emma de Caunes.txt";
        String actor2FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\Mr. Bean's Holiday\\Actors\\Preston Nyman.txt";
        String actor3FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\Mr. Bean's Holiday\\Actors\\Rowan Atkinson.txt";
        //Movie 2 actors
        String actor4FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\The Call of the Wild\\Actors\\Harrison Ford.txt";
        String actor5FileName = "C:\\Users\\Haris\\Desktop\\DisneylandsNetflixApp\\src\\main\\resources\\Genres\\Adventure\\The Call of the Wild\\Actors\\Omar Sy.txt";


        List<Movie> movies = new ArrayList<Movie>();
        //movie Mr. Bean's Holiday\Actors
        Movie mrBeansHoliday = new Movie();
        mrBeansHoliday.generateMovie(movie1FileName);

        Actor actor1 = new Actor();
        actor1.generateActor(actor1FileName);
        mrBeansHoliday.addActor(actor1);

        Actor actor2 = new Actor();
        actor2.generateActor(actor2FileName);
        mrBeansHoliday.addActor(actor2);

        Actor actor3 = new Actor();
        actor3.generateActor(actor3FileName);
        mrBeansHoliday.addActor(actor3);

        //movie The Call of the Wild
        Movie theCallOfTheWild = new Movie();
        theCallOfTheWild.generateMovie(movie2FileName);

        Actor actor4 = new Actor();
        actor4.generateActor(actor4FileName);
        theCallOfTheWild.addActor(actor4);

        Actor actor5 = new Actor();
        actor5.generateActor(actor5FileName);
        theCallOfTheWild.addActor(actor5);

        movies.add(mrBeansHoliday);
        movies.add(theCallOfTheWild);

        return movies;
    }

    @Override
    public String getColor() {
        return "\u001B[33m";
    }//yellow

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
