/* You have been billed $total. Your balance is $balance.
 * Customer:
 * calls getBalance and setBalance will be inside of a method for setting customer balance
 */
public class Payment {

    public static boolean sufficientFunds(Customers customers, String name, double total){
        if(customers.getCustomerBalance(name) >= total){
            return false;
        }
        return true;
    }

    public static void makePayment(Customers customers, String name, double total) {
        double balance = customers.getCustomerBalance(name);
        double newBalance = balance - total;
        customers.updateCustomerBalance(name, newBalance);
        System.out.println(name + ", your payment has processed. Your new balance is " + newBalance + ".");
    }
}
