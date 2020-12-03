package codecta.academy.DisneylandsNetflixApp.disneylands.characters;

public class MinnieCharacter extends DisneyCharacter {
    public MinnieCharacter(){
        imageFileName = "minnie.png";
    }
    @Override
    public String getName() {
        return "Minnie";
    }

    @Override
    public String welcomes() {
        return super.welcomes() + " Hello my beautiful girl! Happy you have choose " + this.getName() + " to play with! Let's start...!";
    }
}
