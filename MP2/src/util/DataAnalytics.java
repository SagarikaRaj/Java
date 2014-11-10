package util;

import java.util.List;
import mp2.domain.DaylightRecord;

public class DataAnalytics
{
    public static String caculateWinterSolstice(List<DaylightRecord> dayList)
    { 
        DaylightRecord shortest=dayList.get(183);
        int i,result=0;
        ComparatorAndComparable shortestDay=new ComparatorAndComparable();  
        for(i=184;i< 364;i++)
        {
             result=shortestDay.compare(shortest.getDayLength(), dayList.get(i).getDayLength());
              if(result== -1)
                  shortest=dayList.get(i);
        }
        DaylightRecord temp =dayList.get(355);
        return shortest.getSunrise().toString();
    }
    
    public static String calculateSummerSolstice(List<DaylightRecord> dayList)
    {
        DaylightRecord longest = dayList.get(90);
        int i,result=0;
        ComparatorAndComparable longestDay = new ComparatorAndComparable(); 
        for(i = 90; i < 210; i++)
        {
           result = longestDay.compare(longest.getDayLength(), dayList.get(i).getDayLength());
           if(result == 1 )
           longest = dayList.get(i);
        }
        return longest.getSunset().toString();
    }
 
    public static String calculateVernalEquinox(List<DaylightRecord> dayList)
    {
    DaylightRecord equinox = null,almostSameDay = null;
    int i, result = 1,smallDifference,equinoxTime;
    ComparatorAndComparable equalDay=new ComparatorAndComparable(); 
    smallDifference = (int)(dayList.get(0).getDayLength() - dayList.get(0).getNightLength());
    almostSameDay = dayList.get(0);
    for(i=0;i<=183;i++)
    {
        result=equalDay.compare(dayList.get(i).getDayLength(),dayList.get(i).getNightLength());
        
        if(result == 0)
            equinox = dayList.get(i);
        equinoxTime = (int)dayList.get(i).getNightLength()- dayList.get(i).getDayLength();
        if(equinoxTime < smallDifference)
        smallDifference = equinoxTime;
        almostSameDay=dayList.get(i);
    }
    //System.out.println("The Small time difference is"+smallDifference);
    return almostSameDay.getSunrise().toString();
  }
    
    public static String calculateAutumnalEquinox(List<DaylightRecord> dayList)
    {
        DaylightRecord equinox=null,almostSameDay=null;
        int i, result = 1,smallDifference,equinoxTime;
        ComparatorAndComparable equalDay=new ComparatorAndComparable(); 
        smallDifference = (int)(dayList.get(182).getDayLength() - dayList.get(182).getNightLength());
        almostSameDay = dayList.get(182);
        for(i=183;i<=363;i++)
        {
            result=equalDay.compare(dayList.get(i).getDayLength(),dayList.get(i).getNightLength());
            if(result==0)
            equinox= dayList.get(i);
            equinoxTime = (int)dayList.get(i).getNightLength()- dayList.get(i).getDayLength();
            if(equinoxTime <smallDifference)
            smallDifference=equinoxTime; 
            almostSameDay=dayList.get(i);
        }
        return almostSameDay.getSunrise().toString();
   }
}
