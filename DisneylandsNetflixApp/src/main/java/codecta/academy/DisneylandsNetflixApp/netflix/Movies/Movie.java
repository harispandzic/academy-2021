package codecta.academy.DisneylandsNetflixApp.netflix.Movies;

import codecta.academy.DisneylandsNetflixApp.netflix.Actors.Actor;
import codecta.academy.DisneylandsNetflixApp.netflix.Genres.Genre;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Movie {
    private static final Logger logger = LogManager.getLogger(Movie.class);

    private String movieTitle;
    private int relaseYear;
    private String directorName;
    private int ibdmRating;
    private int duration;//in minutes
    private String movieDescription;
    private List<Actor> actors;

    public Movie(){
        movieTitle = "";
        relaseYear = 0;
        directorName = "";
        ibdmRating = 0;
        duration = 0;
        movieDescription = "";
        actors = null;
    }
    public Movie(String movieTitle,int relaseYear, String directorName, int ibdmRating, int duration, String movieDescription,List<Actor> actors){
        this.movieTitle = movieTitle;
        this.relaseYear = relaseYear;
        this.directorName = directorName;
        this.ibdmRating = ibdmRating;
        this.duration = duration;
        this.movieDescription = movieDescription;
        this.actors = new ArrayList<Actor>();
    }

    public String getMovieTitle() {
        return movieTitle;
    }
    public  void setMovieTitle(String movieTitle){
        this.movieTitle = movieTitle;
    }

    public int getRelaseDay() {
        return relaseYear;
    }
    public  void setRelaseDay(int relaseDay){
        this.relaseYear = relaseDay;
    }

    public String getDirectorName() {
        return directorName;
    }
    public  void setDirectorName(String directorName){
        this.directorName = directorName;
    }

    public int getIbdmRating() {
        return ibdmRating;
    }
    public  void setIbdmRating(int ibdmRating){
        this.ibdmRating = ibdmRating;
    }

    public int getDuration() {
        return duration;
    }
    public  void setDuration(int duration){
        this.duration = duration;
    }

    public String getMovieDescription() {
        return movieDescription;
    }
    public  void setMovieDescription(String movieDescription){
        this.movieDescription = movieDescription;
    }

    public List<Actor> getActors(){
        return actors;
    }
    public void addActor(Actor actor){
        if(actors == null)
            actors = new ArrayList<Actor>();
        actors.add(actor);
    }

    public void generateMovie(String fileName) {
        BufferedReader reader;
        //Movie movie = new Movie();
        String movieTitle, directorName, movieDescription, year, rating, dur;
        int relaseYear,ibdmRating, duration;
        int yearOfBirth;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null){
                if(line.startsWith("Movie title")){
                    movieTitle = line.substring(line.indexOf(":")+1,line.length());
                    this.setMovieTitle(movieTitle);
                }
                if(line.startsWith("Relase year")){
                    year = line.substring(line.indexOf(":")+1,line.length());
                    relaseYear = Integer.parseInt(year);
                    this.setRelaseDay(relaseYear);
                }
                if(line.startsWith("Director name")){
                    directorName = line.substring(line.indexOf(":")+1,line.length());
                    this.setDirectorName(directorName);
                }
                if(line.startsWith("IBDM rating")){
                    rating = line.substring(line.indexOf(":")+1,line.length());
                    ibdmRating = Integer.parseInt(rating);
                    this.setIbdmRating(ibdmRating);
                }
                if(line.startsWith("Duration")){
                    dur = line.substring(line.indexOf(":")+1,line.length());
                    duration = Integer.parseInt(dur);
                    this.setDuration(duration);
                }
                if(line.startsWith("Movie description")){
                    movieDescription = line.substring(line.indexOf(":")+1,line.length());
                    this.setMovieDescription(movieDescription);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        logger.info("Iz fajla " + fileName + " izgenerisani podaci o filmu " + this.getMovieTitle() + ".");
    }
    public void present(String color) {
        String movieTitle = this.getMovieTitle();
        int relaseYear = this.getRelaseDay();
        String directorName = this.getDirectorName();
        int ibdmRating = this.getIbdmRating();
        int duration = this.getDuration();
        String movieDescription = this.getMovieDescription();
        List<Actor> actors = this.getActors();
        int actorNumber = actors.size();

        String resetColor = "\u001B[0m";

        System.out.printf("You have selected the %s%s%s movie. See information about the selected movie: \n",color,movieTitle,resetColor);
        System.out.printf("Movie title: %s%s%s\n",color,movieTitle,resetColor);
        System.out.printf("Relase day: %s%s%s\n",color,relaseYear,resetColor);
        System.out.printf("Director name: %s%s%s\n",color,directorName,resetColor);
        System.out.printf("IBDM Rating: %s%d%s\n",color,ibdmRating,resetColor);
        System.out.printf("Duration: %s%d%s\n",color,duration,resetColor);
        System.out.printf("Movie description: %s%s%s\n",color,movieDescription,resetColor);
        System.out.println("Actors: ");
        for(int i = 0;i<actorNumber;i++){
            System.out.printf("%d.",i+1);
            actors.get(i).present(color);
        }
        logger.info("Korisniku na ekran prikazani podaci o filmu " + this.getMovieTitle() + ".");
    }
}
