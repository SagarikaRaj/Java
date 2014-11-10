
package domain;

import java.io.Serializable;
import java.util.Date;

//class to encapsulate product, current time stamp and region
public class ProductMessage implements Serializable
{
    protected Product productObject;
    protected Date timestamp;
    protected String region;
    
    // No-Args

    public ProductMessage()
    {
    }
    
    // Full-Args

    public ProductMessage(Product productObject, Date timestamp, String region)
    {
        this.productObject = productObject;
        this.timestamp = timestamp;
        this.region = region;
       
    }
    
    // Accessors & Mutators

    public Product getProductObject() 
    {
        return productObject;
    }

    public void setProductObject(Product productObject)
    {
        this.productObject = productObject;
    }

    public Date getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(Date timestamp)
    {
        this.timestamp = timestamp;
    }

    public String getRegion() 
    {
        return region;
    }

    public void setRegion(String region)
    {
        this.region = region;
    }
    
    // toString()

    @Override
    public String toString() 
    {
        return "ProductMessage{" + "productObject=" + productObject + ", timestamp=" + timestamp + ", region=" + region + '}';
    }    
}
