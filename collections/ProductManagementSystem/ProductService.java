package collections.ProductManagementSystem;

import java.util.*;

public class ProductService {

    private Map<Integer, Product> productMap = new HashMap<>();
    private List<Product> productList = new ArrayList<>();
    private Set<Product> productSet = new HashSet<>();

    public void addProduct(Product p) {

        // Duplicate by ID (safety, though auto-generated)
        if (productMap.containsKey(p.getProductId())) {
            System.out.println("Product with this ID already exists.");
            return;
        }

        // Duplicate by name + category (business rule)
        for (Product existing : productList) {
            if (existing.getName().equalsIgnoreCase(p.getName()) &&
                    existing.getCategory().equalsIgnoreCase(p.getCategory())) {
                System.out.println("Product with same name and category already exists.");
                return;
            }
        }

        productMap.put(p.getProductId(), p);
        productList.add(p);
        productSet.add(p);

        System.out.println("Product added successfully.");
    }

    public void removeProduct(int id) {
        Product p = productMap.get(id);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        productMap.remove(id);
        productList.remove(p);
        productSet.remove(p);

        System.out.println("Product removed successfully.");
    }

    public Product findProductById(int id) {
        return productMap.get(id);
    }

    public List<Product> searchByName(String name) {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.getName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> searchByCategory(String category) {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> findInStockProducts() {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.isInStock()) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> findProductsInPriceRange(double low, double high) {
        List<Product> result = new ArrayList<>();

        for (Product p : productList) {
            if (p.getPrice() >= low && p.getPrice() <= high) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> sortByPriceLowToHigh() {
        List<Product> copy = new ArrayList<>(productList);
        copy.sort(Comparator.comparingDouble(Product::getPrice));
        return copy;
    }

    public List<Product> sortByPriceHighToLow() {
        List<Product> copy = new ArrayList<>(productList);
        copy.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
        return copy;
    }

    public List<Product> sortByRatingHighToLow() {
        List<Product> copy = new ArrayList<>(productList);
        copy.sort((p1, p2) -> Double.compare(p2.getRating(), p1.getRating()));
        return copy;
    }

    public List<Product> sortInStockByPrice() {
        List<Product> inStock = findInStockProducts();
        inStock.sort(Comparator.comparingDouble(Product::getPrice));
        return inStock;
    }
    public Product binarySearchByProductId(int targetId){
        List<Product> productListCopy = new ArrayList<>(productList);
        int low =0 ;
        int high = productListCopy.size()-1;
        Product p=null;
        Collections.sort(productListCopy, (n1,n2)-> Integer.compare(n1.getProductId(),n2.getProductId()));
        while(low<=high) {
            int mid = (high+low)/2;
            Product midProd = productListCopy.get(mid);
            if (midProd.getProductId() == targetId) {
                p = midProd;
                break;
            } else if (midProd.getProductId() < targetId) {
                low= mid+1;
            } else {
               high= mid-1;
            }
        }
        return p;
    }
}
