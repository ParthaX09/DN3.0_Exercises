

interface PaymentProcessor {
    void processPayment(double amount);
}

class Paypal{
    void makepPayPalPayment(double amount){
        System.out.println("Making payment through paypal , amouting to rupees "+amount);
    }
}

class RazorPay{
    void makeRazorPayRayment(double amount){
        System.out.println("Making payment through Razorpay , amouting to rupees "+amount);
    }
}
class Stripe{
    void makeStripePayment(double amount){
        System.out.println("Making payment through Stripe , amouting to rupees "+amount);
    }
}
class PaypalAdapter implements PaymentProcessor{
    private Paypal paypalpayment;
    public PaypalAdapter(Paypal paypalpayment){
        this.paypalpayment=paypalpayment;
    }
    @Override
    public void processPayment(double amount){
        paypalpayment.makepPayPalPayment(amount);
    }
}
 
class StripeAdaptor implements PaymentProcessor{
    private Stripe stripepayment;
    public StripeAdaptor(Stripe stripepayment){
        this.stripepayment=stripepayment;
    }
    @Override
    public void processPayment(double amount){
        stripepayment.makeStripePayment(amount);
    }
}

class RazorPayAdaptor implements PaymentProcessor{
    private RazorPay razorpaypayment;
    public RazorPayAdaptor(RazorPay razorpaypayment){
        this.razorpaypayment=razorpaypayment;
    }
    @Override
    public void processPayment(double amount){
        razorpaypayment.makeRazorPayRayment(amount);
    }
}


public class App {
    public static void main(String[] args)  {
        //Test Case
        Paypal paypal=new Paypal();
        PaymentProcessor paypaladapter=new PaypalAdapter(paypal);
        paypaladapter.processPayment(499.00);
        Stripe stripe=new Stripe();
        PaymentProcessor stripeadaptor=new StripeAdaptor(stripe);
        stripeadaptor.processPayment(699.00);
        RazorPay razorpay=new RazorPay();
        PaymentProcessor razorpayadaptor=new RazorPayAdaptor(razorpay);
        razorpayadaptor.processPayment(1000.00);
    }
}
