package codecta.academy.DisneylandsNetflixApp.disneylands;


import codecta.academy.DisneylandsNetflixApp.disneylands.land.AdventureLand;
import codecta.academy.DisneylandsNetflixApp.disneylands.land.Disneyland;
import codecta.academy.DisneylandsNetflixApp.disneylands.land.FantasyLand;
import codecta.academy.DisneylandsNetflixApp.disneylands.land.MickeyTown;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static String crt = "\n------------------------------------------\n";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, visitor. Enter your name: ");
        String name = scanner.next();

        boolean intro = true;

        do{
            System.out.printf("Welcome, %s. Please select fun park.\n",name);
            List<Disneyland> disneylands = new ArrayList<Disneyland>();
            disneylands.add(new AdventureLand());
            disneylands.add(new FantasyLand());
            disneylands.add(new MickeyTown());

            if(disneylands.size()!=0){
                for (int i = 0;i<disneylands.size();i++){
                    System.out.printf("%d. %s\n",i+1,disneylands.get(i).getName());
                }
            }
            else {
                System.out.printf("An error has occurred. There is currently no fun park available.");
                intro = false;
                break;
            }

            System.out.printf("Your choise is: ");
            int selection = scanner.nextInt();

            if(selection > disneylands.size()){
                intro = false;
                System.out.println("You have finished this journey! Visit us again!" + crt);
                break;
            }

            Disneyland selectedDisneyland = disneylands.get(selection-1);

            System.out.printf("Welcome to " + selectedDisneyland.getName() + " fun park.\n");
            System.out.printf("Name: %s\nDescription: %s\n",selectedDisneyland.getName(),selectedDisneyland.getDescription());
            System.out.printf("Here are our characters in %s: \n",selectedDisneyland.getName());
            if(selectedDisneyland.characters() != null){
                characterPresent(selectedDisneyland);
            }
            else{
                System.out.printf("Unfortunately, fun park " + selectedDisneyland.getName() + " has no character.\n");
            }
        }while (intro);
    }

    private static void characterPresent(Disneyland selectedDisneyland) {
        String name,
                welcome,
                picture,
                color,
                resetColor = "\u001B[0m";
        for(int i = 0;i<selectedDisneyland.characters().size();i++){
            name = selectedDisneyland.characters().get(i).getName();
            welcome = selectedDisneyland.characters().get(i).welcomes();
            color = selectedDisneyland.getColor();
            picture = selectedDisneyland.characters().get(i).picture();
            System.out.printf("%d.character: %s%s\n%s%s's  welcome message: %s%s%s\nMy picture is: \n%s\n%s",i+1,color,name,name,resetColor,color,welcome,resetColor,picture,crt);
        }
        System.out.println("You have finished this journey! Visit us again!" + crt);
    }
}

