package codecta.academy.DisneylandsNetflixApp.netflix.Actors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import codecta.academy.DisneylandsNetflixApp.netflix.Movies.Movie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Actor {
    private static final Logger logger = LogManager.getLogger(Actor.class);
    private String name;
    private String surname;
    private int yearOfBirth;

    public Actor(){
        name = "";
        surname = "";
        yearOfBirth = 0;
    }
    public Actor(String name, String surname,int yearOfBirth){
        this.name = "";
        this.surname = "";
        this.yearOfBirth = 0;
    }

    public String getName(){
        return this.name;
    }
    public void  setName(String name){
        this.name = name;
    }
    public String getSurname(){
        return this.surname;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public int getYearOfBirth(){
        return this.yearOfBirth;
    }
    public void setYearOfBirth(int yearOfBirth){
        this.yearOfBirth = yearOfBirth;
    }
    public String getNameAndSurname(){
        return name + " " + surname;
    }

    public void generateActor(String fileName) {
        BufferedReader reader;
        String name, surname, year;
        int yearOfBirth;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null){
                if(line.startsWith("Name")){
                    name = line.substring(line.indexOf(":")+1,line.length());
                    this.setName(name);
                }
                if(line.startsWith("Surname")){
                    surname = line.substring(line.indexOf(":")+1,line.length());
                    this.setSurname(surname);
                }
                if(line.startsWith("Year of birth")){
                    year = line.substring(line.indexOf(":")+1,line.length());
                    yearOfBirth = Integer.parseInt(year);
                    this.setYearOfBirth(yearOfBirth);
                }
                line = reader.readLine();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        logger.info("Iz fajla " + fileName + " izgenerisani podaci o glumcu " + this.getNameAndSurname() + ".");
    }
    public void present(String color){
        String name = this.name;
        String surname = this.surname;
        int yearOfBirth = this.yearOfBirth;
        String resetColor = "\u001B[0m";
        System.out.printf("%s%s %S, (%d)%s\n",color,name,surname,yearOfBirth,resetColor);
        logger.info("Korisniku na ekran prikazani podaci o glumcu " + this.getNameAndSurname() + ".");
    }
}
