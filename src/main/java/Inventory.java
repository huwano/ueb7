import java.util.HashMap;

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
            if (product.getCategory().equals(category)) {
                System.out.println(product);
            }
        }
    }



}
