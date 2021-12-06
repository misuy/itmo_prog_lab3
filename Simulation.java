import java.lang.Math;

public class Simulation implements Runable
{
    private int length;
    private final String pilulkinName = "Пилюлькин";
    private final String neznaikaName = "Незнайка";
    private final String friendName = "Друг Незнайки";

    public Simulation(int length)
    {
        this.length = length;
    }

    public void run()
    {
        AbstractCharacter neznaika = new NotTieCharacter(neznaikaName);
        AbstractCharacter friend = new NotTieCharacter(friendName);
        AbstractCharacter pilulkin = new TieCharacter(pilulkinName);

        AbstractDay earthDay = new EarthDay();
        AbstractDay moonDay = new MoonDay();

        AbstractCharacter dayWinner = null;

        for (int i=0; i<this.length; i++)
        {
            System.out.println("Земной день " + i);
            boolean neznaikaRes = neznaika.makeTurn();
            boolean friendRes = friend.makeTurn();
            boolean pilulkinRes = pilulkin.makeTurn();

            double randomDigit = Math.random();
            if (pilulkinRes)
            {
                dayWinner = pilulkin;
            }
            else
            {
                if (neznaikaRes)
                {
                    if (friendRes)
                    {
                        if (randomDigit < 0.5)
                        {
                            dayWinner = neznaika;
                        }
                        else
                        {
                            dayWinner = friend;
                        }
                    }
                    else
                    {
                        dayWinner = neznaika;
                    }
                }
                else
                {
                    if (friendRes)
                    {
                        dayWinner = friend;
                    }
                    else
                    {
                        if (randomDigit < 0.5)
                        {
                            dayWinner = neznaika;
                        }
                        else
                        {
                            dayWinner = friend;
                        }
                    }
                }
            }

            if (earthDay.addResultPerEarthDay(dayWinner))
            {
                earthDay = new EarthDay();
            }

            if (moonDay.addResultPerEarthDay(dayWinner))
            {
                moonDay = new MoonDay();
            }
        }
    }

    @Override
    public boolean equals(Object obj)
    {
        Simulation objS = (Simulation) obj;
        boolean b = true;
        if (this.length != objS.length) b = false;
        return(b);
    }

    @Override
    public String toString()
    {
        return("Simulation{" + "length=" + this.length + "}");
    }

    @Override
    public int hashCode()
    {
        return(this.length);
    }
}