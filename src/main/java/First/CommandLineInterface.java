package First;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class CommandLineInterface {
    private Scanner scanner;
    private Inventory myInventory;
    public CommandLineInterface() {
         scanner = new Scanner(System.in);
         myInventory = new Inventory();
         start();
    }
    public void start() {
        System.out.println("Welcome to the First.Inventory Management System!");
        displayMenu();
    }
    public void displayMenu() {
        System.out.println(" 1. -> Add First.Product ");
        System.out.println(" 2. -> remove a First.Product  ");
        System.out.println(" 3. -> look for a First.Product with an iD ");
        System.out.println(" 4. -> Show Products after Category  ");
        System.out.println(" 5. -> Show all Products ");
        System.out.println(" 6. -> Sort Products with their name ");
        System.out.println(" 7. -> Sort Products with their price ");
        System.out.println(" 8. -> Show Products with low First.Inventory amount ");
        System.out.println(" 9. -> Show Products with a custom filter ");
        System.out.println("10. ->  raise prices of all products by X% ");
        System.out.println("11. ->  Quit this Application ");
        System.out.println("    ->  Choose wisely... :");

        int choice = scanner.nextInt();
        switch(choice) {
            case 1:
                addProduct();
                displayMenu();
            case 2:
                removeProduct();
                displayMenu();
            case 3:
                searchProductById();
                displayMenu();
            case 4:
                displayProductsByCategory();
                displayMenu();
            case 5:
                listAllProducts();
                displayMenu();
            case 6:
                sortProductsByName();
                displayMenu();
            case 7:
                sortProductsByPrice();
                displayMenu();
            case 8:
                displayLowStockProducts();
                displayMenu();
            case 9:
                displayProductsByCustomFilter();
                displayMenu();
            case 10:
                increaseAllProductPrices();
                displayMenu();
            case 11:
                System.exit(0);
                break;
            default:
                System.out.println("Please choose something else ! Something valid !");
                displayMenu();
        }
    }
    public void addProduct() {
        System.out.println("Geben Sie die Produkt-ID ein:");
        int productId = scanner.nextInt();
        System.out.println("Geben Sie den Produktnamen ein:");
        String name = scanner.next();
        System.out.println("Geben Sie die Kategorie des Produkts ein:");
        String category = scanner.next();
        System.out.println("Geben Sie den Preis des Produkts ein:");
        double price = scanner.nextDouble();
        System.out.println("Geben Sie die Menge des Produkts ein:");
        int quantity = scanner.nextInt();
        Product product = new Product(productId, name, category, price, quantity);
        myInventory.addProduct(product);
        System.out.println("Produkt hinzugefügt!");
        displayMenu();
    }
    public void removeProduct() {
        System.out.println("Geben Sie die Produkt-ID ein:");
        int productId = scanner.nextInt();
        myInventory.removeProduct(productId);
        System.out.println("Produkt entfernt!");
    }
    public void searchProductById() {
        System.out.println("Geben Sie die Produkt-ID ein:");
        int productId = scanner.nextInt();
        Product product = myInventory.searchProductById(productId);
        if(product != null) {
            System.out.println("Produkt gefunden:");
            System.out.println("Produkt-ID: " + product.getProductId());
            System.out.println("Produktname: " + product.getName());
            System.out.println("Produktkategorie: " + product.getCategory());
            System.out.println("Produktpreis: " + product.getPrice());
            System.out.println("Produktmenge: " + product.getQuantity());
        } else {
            System.out.println("Produkt nicht gefunden!");
        }
    }
    public void displayProductsByCategory() {
        System.out.println("Geben Sie die Kategorie ein:");
        String category = scanner.next();
        System.out.println(myInventory.findProductsByCategory(category));
    }
    public void listAllProducts(){
        myInventory.getAllProducts().forEach(System.out::println);
    }
    public void sortProductsByName() {
        myInventory.sortProductsByName();
        System.out.println("Produkte sortiert nach Namen:");
        listAllProducts();
    }
    public void sortProductsByPrice() {
        myInventory.sortProductsByPrice();
        System.out.println("Produkte sortiert nach Preis:");
        listAllProducts();
    }
    public void displayLowStockProducts() {
        System.out.println("Enter a threshold for low stock products:");
        int threshold = scanner.nextInt();
        myInventory.getLowStockProducts(threshold).forEach(System.out::println);
    }
    public void displayProductsByCustomFilter() {
        System.out.println("Enter filter type (name, category, price, quantity):");
        String filterType = scanner.next();

        switch (filterType.toLowerCase()) {
            case "name":
                System.out.println("Enter product name:");
                String name = scanner.next();
                myInventory.filterProducts(product -> product.getName().equals(name));
                break;
            case "category":
                System.out.println("Enter product category:");
                String category = scanner.next();
                myInventory.filterProducts(product -> product.getCategory().equals(category));
                break;
            case "price":
                System.out.println("Enter product price:");
                double price = scanner.nextDouble();
                myInventory.filterProducts(product -> product.getPrice() == price);
                break;
            case "quantity":
                System.out.println("Enter product quantity:");
                int quantity = scanner.nextInt();
                myInventory.filterProducts(product -> product.getQuantity() == quantity);
                break;
            default:
                System.out.println("Invalid filter type.");
                return;
        }
    }
    public void increaseAllProductPrices() {
        System.out.println("Enter a percentage: ");
        double percentage = scanner.nextDouble();
        myInventory.applyToProducts(product -> product.setPrice(product.getPrice() * (1 + percentage / 100)));
    }


}
