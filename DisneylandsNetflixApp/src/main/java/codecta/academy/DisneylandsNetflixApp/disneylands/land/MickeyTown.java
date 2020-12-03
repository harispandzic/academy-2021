package codecta.academy.DisneylandsNetflixApp.disneylands.land;

import codecta.academy.DisneylandsNetflixApp.disneylands.characters.DisneyCharacter;
import codecta.academy.DisneylandsNetflixApp.disneylands.characters.MickeyCharacter;
import codecta.academy.DisneylandsNetflixApp.disneylands.characters.MinnieCharacter;

import java.util.ArrayList;
import java.util.List;

public class MickeyTown implements Disneyland{

    String resetColor = "\u001B[0m";
    @Override
    public String getName() {
        return getColor() + "Mickey town" + resetColor;
    }

    @Override
    public String getDescription() {
        return getColor() + "Mickey's Toontown is a themed land at Disneyland and Tokyo Disneyland, two theme parks operated by Walt Disney Parks & Resorts."
                + " At Tokyo Disneyland, this land is named Toontown" + resetColor;
    }

    @Override
    public String getColor() {
        return "\u001B[31m";//red
    }
    @Override
    public List<DisneyCharacter> characters() {
        List<DisneyCharacter> characters = new ArrayList<DisneyCharacter>();
        DisneyCharacter mickey = new MickeyCharacter();
        DisneyCharacter minnie = new MinnieCharacter();
        characters.add(mickey);
        characters.add(minnie);
        return  characters;
    }
}
