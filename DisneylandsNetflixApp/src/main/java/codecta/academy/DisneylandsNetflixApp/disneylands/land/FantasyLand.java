package codecta.academy.DisneylandsNetflixApp.disneylands.land;

import codecta.academy.DisneylandsNetflixApp.disneylands.characters.DisneyCharacter;

import java.util.List;

public class FantasyLand implements Disneyland{

    String resetColor = "\u001B[0m";
    @Override
    public String getName() {
        return getColor() + "Fantasy land" + resetColor;
    }

    @Override
    public String getDescription() {
        return getColor() + "Fantasyland is one of the \"themed lands\" at all of the Magic Kingdom-style parks run by The Walt Disney "
                + "Company around the world. Each Fantasyland has a castle, as well as several gentle rides themed after Disney movies." + resetColor;
    }

    @Override
    public String getColor() {
        return "\u001B[34m";//blue
    }
    @Override
    public List<DisneyCharacter> characters() {
        List<DisneyCharacter> characters = null;
        return characters;
    }
}
