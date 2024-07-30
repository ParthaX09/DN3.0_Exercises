import java.util.Arrays;

public class ECommerceSearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P003", "Laptop", "Electronics"),
            new Product("P001", "Smartphone", "Electronics"),
            new Product("P002", "Headphones", "Accessories")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> p1.getProductId().compareTo(p2.getProductId()));

        // Test linear search
        Product result1 = SearchAlgorithms.linearSearch(products, "P001");
        System.out.println("Linear Search Result: " + (result1 != null ? result1 : "Not found"));

        // Test binary search
        Product result2 = BinarySearchAlgorithms.binarySearch(products, "P001");
        System.out.println("Binary Search Result: " + (result2 != null ? result2 : "Not found"));

        // Test not found case
        Product result3 = BinarySearchAlgorithms.binarySearch(products, "P999");
        System.out.println("Binary Search Result for P999: " + (result3 != null ? result3 : "Not found"));
    }
}
