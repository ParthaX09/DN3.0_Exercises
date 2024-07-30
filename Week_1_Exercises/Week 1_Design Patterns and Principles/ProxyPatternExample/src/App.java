import java.util.HashMap;
import java.util.Map;

interface Image{
    void display();
}

class RealImage implements Image {
    private String url;

    public RealImage(String url) {
        this.url = url;
        loadImage();
    }

    private void loadImage() {
        System.out.println("Loading image from " + url);
        // Simulate loading image from remote server
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying image from " + url);
    }
}
class ProxyImage implements Image {
    private String url;
    private static Map<String, RealImage> cache = new HashMap<>();

    public ProxyImage(String url) {
        this.url = url;
    }

    @Override
    public void display() {
        RealImage realImage = cache.get(url);
        if (realImage == null) {
            realImage = new RealImage(url);
            cache.put(url, realImage);
        }
        realImage.display();
    }
}


public class App {
    public static void main(String[] args){
        Image image1 = new ProxyImage("https://123.com/image1.jpg");
        Image image2 = new ProxyImage("https://123.com/image2.jpg");

        image1.display(); 
        image2.display();
        image1.display();
    }
}
