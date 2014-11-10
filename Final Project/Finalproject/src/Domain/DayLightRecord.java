
package Domain;

import Domain.Record;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sagarika
 */
public class DayLightRecord extends Record implements Serializable
{
  
    
    private    int dayLength;
    private    int nightLength;

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
   

    //no arg constructor
    public DayLightRecord() 
    {
        
    }
    
    //Full arg constructor
     public DayLightRecord(Date sunrise, Date sunset) 
    {
        this.sunrise = sunrise;
        this.sunset  = sunset;
    }
     
    
    public void DayLightRecord(java.sql.Date sunrise, java.sql.Date sunset) 
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
    public int calculateDay(java.util.Date Sunset,java.util.Date Sunrise)
    {   
        int dayLength = (int)( (Sunset.getTime() - Sunrise.getTime()) 
                 / (1000 * 60 ) ); 
        //System.out.println("dayLength = " +dayLength);
        return dayLength;
    }
    
    //calculating the length of night in minutes
    public int calculateNight(java.util.Date Sunrise,java.util.Date Sunset)
    {   
        int nightLength = (int)( (Sunrise.getTime() - Sunset.getTime()) 
                 / (1000 * 60 ) ); 
        //System.out.println("nightLength = " +nightLength);
        return nightLength;
    }

    @Override
    public String toString() 
    {
        return "DayLightRecord{" + "dayLength=" + dayLength + ", nightLength=" + nightLength + '}';
    }
}
