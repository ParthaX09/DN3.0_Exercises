import java.util.Arrays;

public class SortingOrdersTest {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O003", "Alice", 350.50),
            new Order("O001", "Bob", 150.75),
            new Order("O002", "Charlie", 200.00)
        };

        System.out.println("Original Orders:");
        printOrders(orders);

        // Test Bubble Sort
        Order[] bubbleSortedOrders = Arrays.copyOf(orders, orders.length);
        BubbleSort.sortOrders(bubbleSortedOrders);
        System.out.println("Orders Sorted by Bubble Sort:");
        printOrders(bubbleSortedOrders);

        // Test Quick Sort
        Order[] quickSortedOrders = Arrays.copyOf(orders, orders.length);
        QuickSort.sortOrders(quickSortedOrders, 0, quickSortedOrders.length - 1);
        System.out.println("Orders Sorted by Quick Sort:");
        printOrders(quickSortedOrders);
    }

    private static void printOrders(Order[] orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}
