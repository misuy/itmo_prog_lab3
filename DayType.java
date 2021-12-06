enum DayType {
    EARTH(1, "Земной"), MOON(14, "Лунный");
    
    private int lenInEarthDays;
    private String dayName;

    DayType(int lenInEarthDays, String dayName)
    {
        this.lenInEarthDays = lenInEarthDays;
        this.dayName = dayName;
    }
    public int lenInEarthDaysGetter()
    {
        return(this.lenInEarthDays);
    }
    public String dayNameGetter()
    {
        return(this.dayName);
    }
}
