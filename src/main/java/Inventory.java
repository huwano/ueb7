import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Inventory {
    private HashMap<Integer, Product> productList;

    public Inventory() {
        this.productList = new HashMap<>();
    }
    public void addProduct(Product product) {
        this.productList.put(product.getProductId(), product);
    }
    public void removeProduct(int productId) {
        this.productList.remove(productId);
    }
    public Product searchProductById(int productId) {
        return this.productList.get(productId);
    }
    public void displayProductsByCategory(String category) {
        for (Product product : this.productList.values()) {
            if (product.getCategory().equals(category.toLowerCase())) {
                System.out.println(product);
            }
        }
    }
    public void displayAllProducts() {
        for (Product product : this.productList.values()) {
            System.out.println(product);
        }
    }
    public void sortProductsByName() {
        TreeMap<String, Product> sortedProducts = new TreeMap<>();
        for (Product product : this.productList.values()) {
            sortedProducts.put(product.getName(), product);
        }
        this.productList.clear();
        for (Map.Entry<String, Product> entry : sortedProducts.entrySet()) {
            this.productList.put(entry.getValue().getProductId(), entry.getValue());
        }
    }
    public void sortProductsByPrice() {
        TreeMap<Double, Product> sortedProducts = new TreeMap<>();
        for (Product product : this.productList.values()) {
            sortedProducts.put(product.getPrice(), product);
        }
        this.productList.clear();
        for (Map.Entry<Double, Product> entry : sortedProducts.entrySet()) {
            this.productList.put(entry.getValue().getProductId(), entry.getValue());
        }
    }
    public void displayLowStockProducts() {
        for (Product product : this.productList.values()) {
            if (product.getQuantity() < 5) {
                System.out.println(product);
            }
        }
    }
    public void displayProductsByCustomFilter() {
        // Implement your custom filter here
    }
    public void increaseAllProductPrices(double percentage) {
        for (Product product : this.productList.values()) {
            double newPrice = product.getPrice() + (product.getPrice() * percentage / 100);
            product.setPrice(newPrice);
        }
    }
}
