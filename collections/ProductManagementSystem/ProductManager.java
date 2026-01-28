package collections.ProductManagementSystem;

import java.util.List;
import java.util.Scanner;

public class ProductManager {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductService service = new ProductService();
        boolean shouldContinue = true;

        while (shouldContinue) {

            System.out.println("\n--- PRODUCT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search by Name");
            System.out.println("3. Search by Category");
            System.out.println("4. Find by ID");
            System.out.println("5. Search by Price Range");
            System.out.println("6. View In-Stock Products");
            System.out.println("7. Sort by Price (Low to High)");
            System.out.println("8. Sort by Rating (High to Low)" ;
            System.out.println("9. Search by productId (Binary Search) ");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Price: ");
                    double price = sc.nextDouble();
                    System.out.print("Rating: ");
                    double rating = sc.nextDouble();
                    System.out.print("Stock Quantity: ");
                    int stock = sc.nextInt();

                    service.addProduct(new Product(name, category, price, rating, stock));
                    break;

                case 2:
                    System.out.print("Enter product name: ");
                    String searchName = sc.nextLine();
                    printList(service.searchByName(searchName));
                    break;

                case 3:
                    System.out.print("Enter category: ");
                    String searchCategory = sc.nextLine();
                    printList(service.searchByCategory(searchCategory));
                    break;

                case 4:
                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();
                    Product p = service.findProductById(id);
                    System.out.println(p != null ? p : "Product not found.");
                    break;

                case 5:
                    System.out.print("Low price: ");
                    double low = sc.nextDouble();
                    System.out.print("High price: ");
                    double high = sc.nextDouble();
                    printList(service.findProductsInPriceRange(low, high));
                    break;

                case 6:
                    printList(service.findInStockProducts());
                    break;

                case 7:
                    printList(service.sortByPriceLowToHigh());
                    break;

                case 8:
                    printList(service.sortByRatingHighToLow());
                    break;

                case 9:
                    System.out.print("Enter product ID: ");
                    int pId = sc.nextInt();
                    p = service.findProductById(pId);
                    System.out.println(p != null ? p : "Product not found.");
                    break;

                case 10:
                    shouldContinue = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }

    private static void printList(List<Product> list) {
        if (list.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Product p : list) {
                System.out.println(p);
            }
        }
    }
}
