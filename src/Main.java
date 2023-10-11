import utilities.Customer;
import utilities.Order;
import utilities.Product;

import java.time.LocalDate;
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
        Product toyCar = new Product("toy car", "Boys", 40);
        Product actionFigure = new Product("action figure", "Boys", 15);
        Product legoSet = new Product("Lego set", "Boys", 100);

        Customer aldo = new Customer("Aldo");
        Customer giovanni = new Customer("Giovanni");
        Customer giacomo = new Customer("Giacomo");

        List<Product> products = Arrays.asList(book, book2, book3, book4, toy, phone, babyBottle, diapers, stroller, toyCar, actionFigure, legoSet);
        Order orderAldo = new Order(aldo, products);
        Order orderAldo2 = new Order(aldo, products);
        Order orderAldo3 = new Order(aldo, products);
        Order orderAldo4 = new Order(aldo, products);
        Order orderAldo5 = new Order(aldo, products);
        Order orderGiovanni = new Order(giovanni, products);
        Order orderGiovanni2 = new Order(giovanni, products);
        Order orderGiovanni3 = new Order(giovanni, products);
        Order orderGiovanni4 = new Order(giovanni, products);
        Order orderGiovanni5 = new Order(giovanni, products);
        Order prderGiacomo = new Order(giacomo, products);
        Order orderGiacomo2 = new Order(giacomo, products);


        List<Product> booksProductsLessThan100 = products.stream()
                .filter(product -> "Books".equalsIgnoreCase(product.getCategory()) && product.getPrice() < 100)
                .toList();
        List<Product> babyProducts = products.stream()
                .filter(product -> "baby".equalsIgnoreCase(product.getCategory()))
                .toList();
        List<Product> boysProducts = products.stream()
                .filter(product -> "boys".equalsIgnoreCase(product.getCategory()))
                .toList();
        boysProducts.forEach(product -> product.setPrice(product.getPrice() * 0.9));

        List<Customer> customers = Arrays.asList(aldo, giacomo, giovanni);

        LocalDate startDate = LocalDate.of(2021, 2, 1);
        LocalDate endDate = LocalDate.of(2021, 4, 1);

        List<Product> productsOrderedInDateRangeByTier2 = customers.stream()
                .filter(customer -> customer.getTier() == 2)
                .flatMap(customer -> customer.getOrder().stream())
                .filter(order ->
                        !order.getOrderDate().isBefore(startDate) &&
                                !order.getOrderDate().isAfter(endDate))
                .flatMap(order -> order.getProducts().stream())
                .toList();


        System.out.println("booksProductsLessThan100:");
        booksProductsLessThan100.forEach(System.out::println);
        System.out.println("babyProducts:");
        babyProducts.forEach(System.out::println);
        System.out.println("boysProducts");
        boysProducts.forEach(System.out::println);
        System.out.println("productsOrderedInDateRangeByTier2");
        productsOrderedInDateRangeByTier2.forEach(product -> System.out.println(product.toString()));
    }
}