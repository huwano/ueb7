package First;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Inventory {
    private HashMap<Integer, Product> productList;

    public Inventory() {
        this.productList = new HashMap<>();
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
    public Product searchProductById(int productId) {
        try {
            return this.productList.get(productId);
        } catch (Exception e) {
            return null;
        }
    }
    public List<Product> findProductsByCategory(String category) {
        try {
            //TODO bischen kormisch
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
        //TODo ist noch cursed
        for (Product product : this.productList.values()) {
            consumer.accept(product);
        }
    }
}
