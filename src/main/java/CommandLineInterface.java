import java.util.Scanner;

public class CommandLineInterface {
    private Scanner scanner;
    private Inventory myInventory;
    public CommandLineInterface() {
         scanner = new Scanner(System.in);
         myInventory = new Inventory();
         start();
    }
    public void start() {
        System.out.println("Welcome to the Inventory Management System!");
        displayMenu();
    }
    public void displayMenu() {
        System.out.println(" Add Product -> 1.");
        System.out.println(" remove a Product -> 2. ");
        System.out.println(" look for a Product with an iD -> 3.");
        System.out.println(" Show Products after Category -> 4. ");
        System.out.println(" Show all Products -> 5.");
        System.out.println(" Sort Products with their name -> 6.");
        System.out.println(" Sort Products with their price -> 7. ");
        System.out.println(" Show Products with low Inventory amount -> 8. ");
        System.out.println(" Show Products with 9. Produkte nach benutzerdefiniertem Filter anzeigen");
        System.out.println( " raise prices of all products by X% -> 10.");
        System.out.println(" Quit this Application -> 11. ");
        System.out.println(" Choose wisely... :");

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
                //listAllProducts();
                displayMenu();
            case 6:
                //sortProductsByName();
                displayMenu();
            case 7:
                //sortProductsByPrice();
                displayMenu();
            case 8:
                //displayLowStockProducts();
                displayMenu();
            case 9:
                //displayProductsByCustomFilter();
                displayMenu();
            case 10:
                //increaseAllProductPrices();
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
        myInventory.displayProductsByCategory(category);
    }

}
