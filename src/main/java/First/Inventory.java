package First;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Inventory {
    private LinkedHashMap<Integer, Product> productList;

    public Inventory() {
        this.productList = new LinkedHashMap<>();
    }
    public void addProduct(Product product) {
        this.productList.put(product.getProductId(), product);
    }
    public boolean removeProduct(int productId) {
        try {
            this.productList.remove(productId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public Product findProductById(int productId) {
        try {
            return this.productList.get(productId);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Product> findProductsByCategory(String category) {
        try {
            List<Product> products = new ArrayList<>();
            for (Product product : this.productList.values()) {
                if (product.getCategory().equals(category.toLowerCase())) {
                    products.add(product);
                }
            }
            return products;
        } catch (Exception e) {
            return null;
        }
    }
    public List<Product> getAllProducts() {
        try {
            return (List<Product>) this.productList.values();
        } catch (Exception e) {
            return null;
        }
    }
    public void sortProductsByName() {
        TreeMap<String, Product> sortedMap = new TreeMap<>();
        for(Product product: this.productList.values()) {
            sortedMap.put(product.getName(), product);
        }
        this.productList.clear();
        for(Product product: sortedMap.values()) {
            this.productList.put(product.getProductId(), product);
        }
    }
    public void sortProductsByPrice() {
        TreeMap<Double, Product> sortedMap = new TreeMap<>();
        for(Product product: this.productList.values()) {
            sortedMap.put(product.getPrice(), product);
        }
        this.productList.clear();
        for(Product product: sortedMap.values()) {
            this.productList.put(product.getProductId(), product);
        }
    }
    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStockProducts = new ArrayList<Product>();
        for (Product product : this.productList.values()) {
            if (product.getQuantity() < threshold) {
                lowStockProducts.add(product);
            }
        }
        return lowStockProducts;
    }
    public List<Product> filterProducts(Predicate<Product> predicate) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : this.productList.values()) {
            if (predicate.test(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
    public void applyToProducts(Consumer<Product> consumer) {
        for (Product product : this.productList.values()) {
            consumer.accept(product);
        }
    }
}
