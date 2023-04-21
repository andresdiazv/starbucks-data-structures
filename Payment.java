/* You have been billed $total. Your balance is $balance.
 * Customer:
 * calls getBalance and setBalance will be inside of a method for setting customer balance
 */
public class Payment {

    public static boolean sufficientFunds(Customers customers, String name, double total){
        if(customers.getCustomerBalance(name) <= total){
            return true;
        }
        return false;
    }

    public static void makePayment(Customers customers, String name, double total) {
        customers.updateCustomerBalance(name, total);
        double newBalance = customers.getCustomerBalance(name);
        System.out.println(name + ", your payment has processed. Your new balance is " + newBalance + ".");
    }
}