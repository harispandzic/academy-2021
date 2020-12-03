package codecta.academy.DisneylandsNetflixApp;
import codecta.academy.DisneylandsNetflixApp.disneylands.disneylandsMain;
import codecta.academy.DisneylandsNetflixApp.netflix.netflixMain;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static final Logger logger = LogManager.getLogger(netflixMain.class);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to my Java program. Please select one of two following catalogs: ");
        System.out.printf("1.Disyneylands\n2.Netflix\nYour choise: ");
        int catalog = scanner.nextInt();

        if(catalog == 1){
            System.out.printf("You have selected Disneyland catalog!\n");
            logger.info("Odabran Disneyland catalog!");
            disneylandsMain disneyland = new disneylandsMain();
            disneyland.main(null);
        }
        else if(catalog == 2){
            System.out.printf("You have selected Netflix catalog!\n");
            logger.info("Odabran Netflix catalog!");
            netflixMain netflix = new netflixMain();
            netflix.main("");
        }
    }
}
