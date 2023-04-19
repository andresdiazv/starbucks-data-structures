/*
 * Prints: [Customer name] your order is [drinks array].
 * Payment:
 * 
 * 
 * Customer:
 * getBalance()
 * setBalance()
 *
 * 
 */

import java.util.ArrayList;
public class Order {
    private String customerName;
    private ArrayList<Drink> drinks;
    private float orderPrice;
    private Prepare ordersList = new Prepare();

    public Order(String name, Drink[] items) {
        this.customerName = name;
        this.drinks = new ArrayList<>();
        this.orderPrice = calculateTotal();
    }

    private float calculateTotal() {
        double total = 0;
        double tax = 0.07;

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        total *= (1 + tax);

        return (float) total;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public float getOrderPrice() {
        return this.orderPrice;
    }

    private void chargeCustomer() {
        Payment payment = new Payment(this.customerName, this.orderPrice);
        payment.makePayment();
    }

    private void pushOrder() {
        ordersList.add();
    }
}