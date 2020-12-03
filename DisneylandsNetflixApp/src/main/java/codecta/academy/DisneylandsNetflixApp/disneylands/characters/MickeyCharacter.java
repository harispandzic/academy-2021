package codecta.academy.DisneylandsNetflixApp.disneylands.characters;

public class MickeyCharacter extends DisneyCharacter{

    public MickeyCharacter(){
        imageFileName = "mickey.png";
    }
    @Override
    public String getName() {
        return "Mickey";
    }

    @Override
    public String welcomes() {
        return super.welcomes() + " Welcome to " + this.getName() +"' world! Happy you choose me to play! Let's start...";
    }
}
