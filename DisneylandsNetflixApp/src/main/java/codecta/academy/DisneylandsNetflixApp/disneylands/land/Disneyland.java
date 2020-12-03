package codecta.academy.DisneylandsNetflixApp.disneylands.land;

import codecta.academy.DisneylandsNetflixApp.disneylands.characters.DisneyCharacter;

import java.util.List;

public interface Disneyland {
    public String getName();
    public String getDescription();
    public String getColor();
    public List<DisneyCharacter> characters();
}
