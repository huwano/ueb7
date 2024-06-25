package First;

public class Product {
    private int productId;
    private String name;
    private String category;
    private double price;
    private int quantity;

    public Product(int productId, String name, String category, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }


    public String getName() {
        return name;
    }


    public String getCategory() {
        return category.toLowerCase();
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String toString() {
        return "First.Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
