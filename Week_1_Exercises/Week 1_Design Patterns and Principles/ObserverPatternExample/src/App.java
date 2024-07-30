import java.util.ArrayList;
import java.util.List;

interface Stock{
    void register(Observer ob);
    void deregister(Observer ob);
    void notifyChanges();
}

interface Observer{
    void update();
}

class StockMarket implements Stock{
    List<Observer> observers=new ArrayList<>();

    @Override
    public void register(Observer ob) {
        System.out.println("New Observer Registerd");
        this.observers.add(ob);
    }

    @Override
    public void deregister(Observer ob) {
        System.out.println("Observer removed");
        this.observers.remove(ob);
    }

    @Override
    public void notifyChanges() {
        for(Observer ob:this.observers){
            ob.update();
        }
    }
}
class MobileApp implements Observer{
    String name;
    public MobileApp(String name){
        this.name=name;
    }
    @Override
    public void update() {
       System.out.println(this.name+"!!! Stock price changes detected : notification-mobileapp");
    }
    
}

class WebApp implements Observer{
    String name;
    public WebApp(String name){
        this.name=name;
    }
    @Override
    public void update() {
       System.out.println(this.name+"!!! Stock price changes detected : notification-webapp");
    }
    
}
public class App {
    public static void main(String[] args) throws Exception {
        //test cases
        StockMarket stockmarket=new StockMarket();
        MobileApp mobileobsever=new MobileApp("Avijoy");
        WebApp webobsever=new WebApp("Rishav");
        stockmarket.register(webobsever);
        stockmarket.register(mobileobsever);
        stockmarket.notifyChanges();
        stockmarket.deregister(webobsever);
        stockmarket.deregister(mobileobsever);
    }
}
