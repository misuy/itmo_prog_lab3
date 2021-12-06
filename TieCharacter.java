import java.lang.Math;

public class TieCharacter extends AbstractCharacter
{
    private final String phrase = "Не спорьте!";

    public TieCharacter(String name)
    {
        super(name, true);
    }

    @Override
    public boolean makeTurn()
    {
        double randomDigit = Math.random();
        if (randomDigit < 0.25)
        {
            this.sayPhrase(phrase);
            return(true);
        }
        else
        {
            return(false);
        }
    }
    
}