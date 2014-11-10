package mp2.domain;

import java.util.Date;

public class DaylightRecord extends Record
{   
    
    private    int dayLength;

    public int getDayLength()
    {
        return dayLength;
    }

    public void setDayLength(int dayLength)
    {
        this.dayLength = dayLength;
    }

    public int getNightLength()
    {
        return nightLength;
    }

    public void setNightLength(int nightLength) 
    {
        this.nightLength = nightLength;
    }
    private    int nightLength;

    //no arg constructor
    public DaylightRecord() 
    {
        
    }
    
    //Full arg constructor
     public DaylightRecord(Date sunrise, Date sunset) 
    {
        this.sunrise = sunrise;
        this.sunset  = sunset;
    }
    
    //Mutators for inherited variables from Record
    public void setSunrise(Date sunrise) 
    {
        this.sunrise = sunrise;
    }

    public void setSunset(Date sunset) 
    {
        this.sunset = sunset;
    }

    //accessors for the variables inherited from Abstract Record
    public Date getSunrise() 
    {
        return sunrise;
    }

    public Date getSunset() 
    {
        return sunset;
    }
    
    //calculating the length of a day in minutes
    public int calculateDay(Date Sunset,Date Sunrise)
    {   
        dayLength = (int)( (Sunset.getTime() - Sunrise.getTime()) 
                 / (1000 * 60 ) ); 
        //System.out.println("dayLength = " +dayLength);
        return dayLength;
    }
    
    //calculating the length of night in minutes
    public int calculateNight(Date Sunrise,Date Sunset)
    {   
        nightLength = (int)( (Sunrise.getTime() - Sunset.getTime()) 
                 / (1000 * 60 ) ); 
        //System.out.println("nightLength = " +nightLength);
        return nightLength;
    }

}
