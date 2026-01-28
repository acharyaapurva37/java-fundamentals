package collections.ProductManagementSystem;

public class Product {

    private static int idCounter = 1000;   // auto id generator

    private int productId;
    private int stockQuantity;
    private String name;
    private String category;
    private double price;
    private double rating;

    public Product(String name, String category, double price, double rating, int stockQuantity) {
        this.productId = ++idCounter;
        this.name = name;
        this.category = category;
        this.price = price;
        this.rating = rating;
        this.stockQuantity = stockQuantity;
    }

    public boolean isInStock() {
        return stockQuantity > 0;
    }

    public int getProductId() {
        return productId;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return productId == p.productId;
    }

    @Override
    public int hashCode() {
        return productId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", stock=" + stockQuantity +
                '}';
    }
}
