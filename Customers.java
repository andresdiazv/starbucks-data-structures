import java.util.Hashtable;
/*
 * Stores customers using a Hashtable.
 */

public class Customers{
    private Hashtable<String, Double> customers = new Hashtable<String, Double>();
    
    public void addCustomer(String name, double balance){
        customers.put(name, balance); 
    }

    public void updateCustomerBalance(String name, double newBalance){
        customers.put(name, newBalance);
    }

    public double getCustomerBalance(String name){
        double customerBalance;
        customerBalance = customers.get(name);        
        return customerBalance;
    }
}