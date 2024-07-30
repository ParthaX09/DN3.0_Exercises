interface Notifier {
    void send(String messege);
}

class EmailNotifier implements Notifier {

    @Override
    public void send(String messege) {
        System.out.println("Email Notification : "+messege);
    }
}

abstract class NotifierDecorator implements Notifier {
    protected Notifier notifier;
    public NotifierDecorator(Notifier notifier){
        this.notifier=notifier;
    }
    @Override
    public void send(String messege){
        notifier.send(messege);
    }

}
class SMSNotifierDecorator extends NotifierDecorator{

    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }
    @Override
    public void send(String messege)
    {
        super.send(messege);
        System.out.println("SMS Notification : "+messege);
    
    }
}
class SlackNotifierDecorator extends NotifierDecorator{
    public SlackNotifierDecorator(Notifier notifier){
        super(notifier);
    }
    @Override
    public void send(String messege)
    {
        super.send(messege);
        System.out.println("Slack Notification : "+messege);
    
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Notifier emailNotifier=new EmailNotifier();
        Notifier smsNotifier=new SMSNotifierDecorator(emailNotifier);
        Notifier slackkNotifier=new SlackNotifierDecorator(smsNotifier);
        slackkNotifier.send("!!This is a test notification");
    }

    
}
