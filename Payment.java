/* You have been billed $total. Your balancer is $balance.
 * Customer:
 * calls getBalance and setBalance will be inside of a method for setting customer balance
 */
public class Payment {
    private double total;
    private Customer customer;

    public Payment(double t, Customer c) {
        this.total = t;
        this.customer = c;
    }

    public boolean makePayment() {
        System.out.println("Payment of $" + total + " processed successfully.");
        prepare.executeOrder();

    }
}
