/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.DayLightRecord;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class PersistantObject implements Serializable{
    public Date serilizedDate;
    public List<DayLightRecord> serializedData;

    public PersistantObject(Date serilizedDate, List<DayLightRecord> serializedData) {
        this.serilizedDate = serilizedDate;
        this.serializedData = serializedData;
    }
    public PersistantObject(){
    this.serializedData=null;
    this.serilizedDate=null;
    }

    public Date getSerilizedDate() {
        return serilizedDate;
    }

    public List<DayLightRecord> getSerializedData() {
        return serializedData;
    }

    public void setSerilizedDate(Date serilizedDate) {
        this.serilizedDate = serilizedDate;
    }

    
}
