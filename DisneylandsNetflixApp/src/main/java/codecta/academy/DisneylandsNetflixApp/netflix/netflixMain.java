package codecta.academy.DisneylandsNetflixApp.netflix;

import codecta.academy.DisneylandsNetflixApp.netflix.Genres.*;
import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class netflixMain {

    public static String crt = "\n--------------------------------------------------------------------------------------------------------\n";
    public static String resetColor = "\u001B[0m";

    private static final Logger logger = LogManager.getLogger(netflixMain.class);

    public static void main(String args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, visitor. Welcome to my little cinema. Please enter your name: ");
        String name = scanner.next();

        logger.info("Korisnik " + name + " je pokrenuo aplikaciju.");

        boolean intro = true;
        do{
            System.out.printf("%sHello, %s. Please select one of the following movie genres!\n",crt,name);

            List<Genre> genres = new ArrayList<>();

            Genre genre1 = new Action();
            Genre genre2 = new Adventure();
            Genre genre3 = new Comedy();
            Genre genre4 = new Thriller();

            if(genre1.getName() != args || args == ""){
                genres.add(genre1);
            }
            if(genre2.getName() != args || args == ""){
                genres.add(genre2);
            }
            if(genre3.getName() != args || args == ""){
                genres.add(genre3);
            }
            if(genre4.getName() != args || args == ""){
                genres.add(genre4);
            }

            logger.info("Kreirana lista žanrova, dodani žanrovi. Izostavljen zanr " + args + ".");

            if(genres.size() != 0){
                for(int i = 0;i < genres.size();i++) {
                    String currentColor = genres.get(i).getColor();
                    System.out.printf("%d.%s%s%s\n", i + 1,currentColor, genres.get(i).getName(),resetColor);
                }
                logger.info("Korisniku ispisani svi žanrovi na ekran.");
            }
            else {
                System.out.printf("An error has occurred. There is currently no genres available.");
                logger.warn("Žanrovi su pobrisani.");
                intro = false;
                break;
            }
            System.out.println("Your choise is: ");
            int genreSelection = scanner.nextInt();

            logger.info("Korisnik " + name + " unio broj " + genreSelection + ".");

            System.out.println();

            if(genreSelection > genres.size()){
                intro = false;
                System.out.println("You have finished visiting my little cinema. Visit us again.");
                logger.info("Korisnik " + name + " izašao iz aplikacije.");
                break;
            }

            Genre selectedGenre = genres.get(genreSelection-1);
            logger.info("Korisnik " + name + " odabrao žanr " + selectedGenre.getName() + ".");
            selectedGenre.present();

            int movieSelection;

            do{
                System.out.printf("I want to see details for the movie number:  ");
                movieSelection = scanner.nextInt();
                if(movieSelection > selectedGenre.getMovies().size()) {
                    System.out.printf("Number is incorrect. Please, enter the number again.");
                }
                logger.info("Korisnik " + name + " unio broj " + movieSelection + ".");
            }while (movieSelection > selectedGenre.getMovies().size());

            System.out.printf(crt);

            Movie selectedMovie = selectedGenre.getMovies().get(movieSelection-1);
            logger.info("Korisnik " + name + " u žanru " + selectedGenre.getName() + " odabrao film " + selectedMovie.getMovieTitle() + ".");
            String selectedMovieColor = selectedGenre.getColor();
            selectedMovie.present(selectedMovieColor);
        }while (intro);
    }
}
