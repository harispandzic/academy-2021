package codecta.academy.DisneylandsNetflixApp.disneylands.land;

import codecta.academy.DisneylandsNetflixApp.disneylands.characters.DisneyCharacter;
import codecta.academy.DisneylandsNetflixApp.disneylands.characters.DummyCharacter;
import codecta.academy.DisneylandsNetflixApp.disneylands.characters.MickeyCharacter;
import codecta.academy.DisneylandsNetflixApp.disneylands.characters.MinnieCharacter;

import java.util.*;

public class AdventureLand implements Disneyland{

    String resetColor = "\u001B[0m";
    @Override
    public String getName() {
        return getColor() +  "Adventure land" + resetColor;
    }
    @Override
    public String getDescription() {
        return getColor() + "Adventureland is one of the \"themed lands\" at the many Disneyland-style theme parks run by the Walt Disney Company around the world."
                + " It is themed to resemble the remote jungles in Africa, Asia, South America, the South Pacific and the Caribbean." + resetColor;
    }

    @Override
    public String getColor() {
        return "\u001B[32m";//green
    }

    @Override
    public List<DisneyCharacter> characters() {
        List<DisneyCharacter> characters = new ArrayList<DisneyCharacter>();
        DisneyCharacter mickey = new MickeyCharacter();
        DisneyCharacter minnie = new MinnieCharacter();
        DisneyCharacter dummy = new DummyCharacter();
        characters.add(mickey);
        characters.add(minnie);
        characters.add(dummy);
        return  characters;
    }
}
