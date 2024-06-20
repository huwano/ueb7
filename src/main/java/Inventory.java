import java.util.HashMap;

public class Inventory {
    private HashMap<Integer, Product> productList;

    public Inventory() {
        this.productList = new HashMap<>();
    }

    public void addProduct(Product product) {
        this.productList.put(product.getProductId(), product);
    }

}
