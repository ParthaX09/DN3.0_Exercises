import java.util.Arrays;

public class BinarySearchAlgorithms {

    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            Product midProduct = products[mid];

            if (midProduct.getProductId().equals(targetId)) {
                return midProduct;
            } else if (targetId.compareTo(midProduct.getProductId()) < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return null; // Not found
    }
}
