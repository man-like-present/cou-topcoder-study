package topcoder.chapter08.auto.loan.mir;

public class AutoLoan {
    public double interestRate(double price, double monthlyPayment, int loanTerm) {
        double maxrate = 1.0;
        double rate = 0.5;
        double minrate = 0.0;

        while(true) {
            double calculatedPrice = price;
            for (int i = 0; i < loanTerm; i++) {
                calculatedPrice *= 1 + rate;
                calculatedPrice -= monthlyPayment;
            }
            if (Math.abs(calculatedPrice)< 1e-9) {
                return rate;
            } else {
                if(calculatedPrice > 0) {
                    maxrate = rate;
                } else {
                    minrate = rate;
                }
                rate = (maxrate+minrate)/2;
            }
        }
    }
}
