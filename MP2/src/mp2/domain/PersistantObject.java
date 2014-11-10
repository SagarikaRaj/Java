
package mp2.domain;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PersistantObject implements Serializable
{
    public Date serializedDate;
    public List<DaylightRecord> serializedData;

    public PersistantObject(Date serilizedDate, List<DaylightRecord> serializedData) 
    {
        this.serializedDate = serializedDate;
        this.serializedData = serializedData;
    }
    public PersistantObject()
    {
    this.serializedData=null;
    this.serializedDate=null;
    }

    public Date getSerializedDate() 
    {
        return serializedDate;
    }

    public List<DaylightRecord> getSerializedData() 
    {
        return serializedData;
    }

    public void setSerializedDate(Date serializedDate)
    {
        this.serializedDate = serializedDate;
    }

    
}
