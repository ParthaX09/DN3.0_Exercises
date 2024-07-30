public class InventoryManagementSystemTest {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        // Add products
        Product product1 = new Product("P001", "Laptop", 10, 1000.00);
        Product product2 = new Product("P002", "Smartphone", 25, 499.99);

        manager.addProduct(product1);
        manager.addProduct(product2);

        // Retrieve and display products
        displayProduct(manager.getProduct("P001"));
        displayProduct(manager.getProduct("P002"));

        // Update a product
        product1.setPrice(800.00);
        manager.updateProduct(product1);

        // Display updated product
        displayProduct(manager.getProduct("P001"));

        // Delete a product
        manager.deleteProduct("P002");

        // Try to display deleted product
        displayProduct(manager.getProduct("P002"));
    }

    private static void displayProduct(Product product) {
        if (product != null) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        } else {
            System.out.println("Product not found.");
        }
    }
}
