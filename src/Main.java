import utilities.Product;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product toy = new Product("plane", "Toy", 35);
        Product phone = new Product("pear", "Electronics", 1000);
        Product book = new Product("Big Brother", "Books", 35);
        Product book2 = new Product("The Show of Records, DELUXE", "Books", 100);
        Product book3 = new Product("Divina Commedia", "Books", 99.99);
        Product book4 = new Product("Clean code", "Books", 27);
        Product babyBottle = new Product("Baby Bottle", "Baby", 5.99);
        Product diapers = new Product("Diapers", "Baby", 29.99);
        Product stroller = new Product("Stroller", "Baby", 199.99);


        List<Product> products = Arrays.asList(book, book2, book3, book4, toy, phone, babyBottle, diapers, stroller);
        List<Product> booksProductsLessThan100 = products.stream()
                .filter(product -> "Books".equalsIgnoreCase(product.getCategory()) && product.getPrice() < 100)
                .toList();
        List<Product> babyProducts = products.stream()
                .filter(product -> "baby".equalsIgnoreCase(product.getCategory()))
                .toList();


        System.out.println("booksProductsLessThan100:");
        booksProductsLessThan100.forEach(System.out::println);
        System.out.println("babyProducts:");
        babyProducts.forEach(System.out::println);
    }
}