//Product object to hold in data read from the input file PRODUCT_data.txt
package domain;

import java.io.Serializable;

public class Product implements Serializable 
{
    protected int product_id ;
    protected int manufacturer_id;
    protected String product_code;
    protected double purchase_cost;
    protected  int quantity_on_hand;
    protected  double markup ;
    protected boolean available;
    protected String description;
    
    //No arg constructor
    public Product()
    {
        
    }
    
    //Full arg constructor
    /**
     *
     * @param product_id
     * @param manufacturer_id
     * @param product_code
     * @param purchase_cost
     * @param quantity_on_hand
     * @param markup
     * @param available
     * @param description
     */
    public Product(int product_id, int manufacturer_id, String product_code, double purchase_cost, int quantity_on_hand, 
            double markup, boolean available,String description)
    {
        this.product_id = product_id;
        this.manufacturer_id = manufacturer_id;
        this.product_code = product_code;
        this.purchase_cost = purchase_cost;
        this.quantity_on_hand = quantity_on_hand;
        this.markup = markup;
        this.available = available;
        this.description = description;
    }
       
    //accessors and mutators
    
    public int getProduct_id()
    {
        return product_id;
    }

    public void setProduct_id(int product_id) 
    {
        this.product_id = product_id;
    }

    public int getManufacturer_id() 
    {
        return manufacturer_id;
    }

    public void setManufacturer_id(int manufacturer_id)
    {
        this.manufacturer_id = manufacturer_id;
    }

    public String getProduct_code() 
    {
        return product_code;
    }

    public void setProduct_code(String product_code) 
    {
        this.product_code = product_code;
    }

    public double getPurchase_cost() 
    {
        return purchase_cost;
    }

    public void setPurchase_cost(double purchase_cost)
    {
        this.purchase_cost = purchase_cost;
    }

    public int getQuantity_on_hand() 
    {
        return quantity_on_hand;
    }

    public void setQuantity_on_hand(int quantity_on_hand)
    {
        this.quantity_on_hand = quantity_on_hand;
    }

    public double getMarkup()
    {
        return markup;
    }

    public void setMarkup(double markup)
    {
        this.markup = markup;
    }

    public boolean isAvailable() 
    {
        return available;
    }

    public void setAvailable(boolean available)
    {
        this.available = available;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    //toString method
    @Override
    public String toString() 
    {
        return "Product{" + "product_id=" + product_id + ", manufacturer_id=" + manufacturer_id 
                + ", product_code=" + product_code + ", purchase_cost=" + purchase_cost 
                + ", quantity_on_hand=" + quantity_on_hand + ", markup=" + markup 
                + ", available=" + available + ", description=" + description + '}';
    }
  
}
