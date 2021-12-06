abstract class AbstractCharacter implements Turnable
{
    private String name;
    private boolean tieIfWin;

    public AbstractCharacter(String name, boolean tieIfWin)
    {
        this.name = name;
        this.tieIfWin = tieIfWin;
    }

    protected void sayPhrase(String phrase)
    {
        System.out.println(this.name + ": " + phrase + ";");
    }

    public String nameGetter()
    {
        return(this.name);
    }

    public boolean isTie()
    {
        return(this.tieIfWin);
    }

    @Override
    public boolean equals(Object obj)
    {
        AbstractCharacter objAC = (AbstractCharacter) obj;
        boolean b = true;
        if (!this.name.equals(objAC.name)) b = false;
        if (this.tieIfWin != objAC.tieIfWin) b = false;
        return(b);
    }

    @Override
    public String toString()
    {
        return("Character{" + "name=" + this.name + "; tieIfWin=" + this.tieIfWin + "}");
    }

    @Override
    public int hashCode()
    {
        if (this.tieIfWin) return(this.name.hashCode());
        else return(-this.name.hashCode());
    }
}