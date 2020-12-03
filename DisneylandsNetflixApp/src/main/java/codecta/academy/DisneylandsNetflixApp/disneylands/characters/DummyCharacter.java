package codecta.academy.DisneylandsNetflixApp.disneylands.characters;

public class DummyCharacter extends DisneyCharacter {

    @Override
    public String getName() {
        return "Dummy";
    }

    @Override
    public String welcomes() {
        return super.welcomes() + " " + this.getName() + " welcomes you. It's pleasure to spend time with you!";
    }
}
