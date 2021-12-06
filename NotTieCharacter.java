import java.lang.Math;

public class NotTieCharacter extends AbstractCharacter
{
    private final String phrase1 = "Да.";
    private final String phrase2 = "бла-бла-бла";

    public NotTieCharacter(String name)
    {
        super(name, false);
    }

    @Override
    public boolean makeTurn()
    {
        double randomDigit = Math.random();
        if (randomDigit < 0.5)
        {
            sayPhrase(phrase1);
            return(true);
        }
        else
        {
            sayPhrase(phrase2);
            return(false);
        }
    }
}