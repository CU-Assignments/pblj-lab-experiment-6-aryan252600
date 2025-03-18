import java.util.*;
import java.util.stream.Collectors;

class Product {
    String name;
    String category;
    double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + category + ", " + price + ")";
    }
}

public class ProductProcessor {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", "Electronics", 1200),
            new Product("Phone", "Electronics", 800),
            new Product("T-shirt", "Clothing", 25),
            new Product("Jeans", "Clothing", 50),
            new Product("Sneakers", "Footwear", 100),
            new Product("Boots", "Footwear", 100),
            new Product("Jacket", "Clothing", 120)
        );

        System.out.println("Grouped by Category:");
        Map<String, List<Product>> groupedByCategory = products.stream()
            .collect(Collectors.groupingBy(p -> p.category));
        groupedByCategory.forEach((category, productList) -> {
            System.out.println(category + ": " + productList);
        });

        System.out.println("\nMost Expensive Product per Category:");
        Map<String, Optional<Product>> mostExpensiveProduct = products.stream()
            .collect(Collectors.groupingBy(
                p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
            ));
        mostExpensiveProduct.forEach((category, product) -> 
            System.out.println(category + ": " + product.map(Product::toString).orElse("None"))
        );

        System.out.println("\nAverage Price of All Products:");
        double averagePrice = products.stream()
            .collect(Collectors.averagingDouble(p -> p.price));
        System.out.println("Average Price: " + averagePrice);
    }
}
