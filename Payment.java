public class Payment {
    private double total;
    private Prepare prepare;

    public Payment(double total, Prepare prepare) {
        this.total = total;
        this.prepare = prepare;
    }

    public void makePayment() {
        System.out.println("Payment of $" + total + " processed successfully.");
        prepare.executeOrder();
    }
}
