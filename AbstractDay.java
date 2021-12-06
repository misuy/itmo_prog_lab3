import java.util.HashMap;

abstract class AbstractDay
{
    private int lenInEarthDays;
    private AbstractCharacter[] results;
    private int passedEarthDays;
    private String dayName;

    public AbstractDay(DayType dayType)
    {
        this.passedEarthDays = 0;
        this.lenInEarthDays = dayType.lenInEarthDaysGetter();
        this.dayName = dayType.dayNameGetter();
        this.results = new AbstractCharacter[lenInEarthDays];
    }

    public boolean addResultPerEarthDay(AbstractCharacter character)
    {
        results[passedEarthDays] = character;
        passedEarthDays++;
        if (passedEarthDays == lenInEarthDays)
        {
            this.printResults();
            return(true);
        }
        else return(false);
    }

    protected void printResults()
    {
        System.out.println();
        System.out.println("---");

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int tieCounter = 0;
        for (AbstractCharacter character: this.results)
        {
            if (character.isTie())
            {
                tieCounter++;
            }
            else
            {
                String characterName = character.nameGetter();
                if (map.get(characterName) == null)
                {
                    map.put(characterName, 1);
                }
                else
                {
                    map.put(characterName, map.get(characterName) + 1);
                }
            }
        }

        System.out.println("За прошедший " + dayName + " день:");
        for (String characterName: map.keySet())
        {
            System.out.println(characterName + " победил раз: " + map.get(characterName).toString() + ";");
        }
        if (tieCounter != 0)
        {
            System.out.println("Пилюлькин вмешался в спор раз: " + tieCounter + ";");
        }

        System.out.println("---");
        System.out.println();
    }

    @Override
    public boolean equals(Object obj)
    {
        AbstractDay objAD = (AbstractDay) obj;
        boolean b = true;
        if (this.lenInEarthDays != objAD.lenInEarthDays) b = false;
        if (this.passedEarthDays != objAD.passedEarthDays) b = false;
        if (!this.results.equals(objAD.results)) b = false;
        if (!this.dayName.equals(objAD.dayName)) b = false;
        return(b);
    }

    @Override
    public String toString()
    {
        return("Day{" + "lenInEarthDays=" + this.lenInEarthDays + "; results=" + this.results.toString() + "; passedEarthDays=" + this.passedEarthDays + "; dayName=" + this.dayName + "}");
    }

    @Override
    public int hashCode()
    {
        return(this.lenInEarthDays*this.passedEarthDays*this.dayName.hashCode()*this.results.hashCode());
    }
}