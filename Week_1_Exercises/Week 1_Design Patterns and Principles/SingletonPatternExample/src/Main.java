class Logger{
    private static Logger logger;
    private Logger(){

    }
    public static Logger getLogger()
    {
        if(logger==null){
            //Thread safe
            synchronized (Logger.class){
                logger=new Logger();
            }
        }
        return logger;
    }
}

public class Main {
    public static void main(String[] args) {
    Logger log1=Logger.getLogger();
    Logger log2=Logger.getLogger();
    //Test case
        //Let us check whether only both the object has same hashcode or not if same then
        //only a single object of the logger class been created
        if(log1.hashCode()==log2.hashCode()){
            System.out.println("Only a single instance of logger class has been created with hashcode : "+log1.hashCode());
        }
        else {
            System.out.println("Error Two different instances has been created");
        }
        
    }
}
