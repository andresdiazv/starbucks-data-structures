public class Payment {
    private double total;
    private Prepare prepare;

    public Payment(double total, Prepare prepare) {
        this.total = total;
        this.prepare = prepare;
    }

    public double makePayment(double price, double customerBalance) throws InsufficientBalanceException {
        if (customerBalance >= price) {
            double newBalance = customerBalance - price;
            return newBalance;
        } else {
            throw new InsufficientBalanceException("Insufficient balance.");
        }
    }
}
