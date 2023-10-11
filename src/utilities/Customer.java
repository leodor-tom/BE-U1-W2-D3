package utilities;

import java.util.Random;

public class Customer {
    private final Long id;
    private String name;
    private Integer tier;
    private Integer orderCount;

    public Customer(String name) {
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be null or empty");
        Random rndm = new Random();
        this.name = name;
        this.tier = 1;
        this.orderCount = 0;
        this.id = rndm.nextLong();
    }

    public void placeOrder(Order order) {
        this.orderCount++;
        updateTier();
    }

    private void updateTier() {
        if (orderCount % 5 == 0) {
            this.tier = Math.min(this.tier + 1, 8);
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                ", orderCount=" + orderCount +
                '}';
    }
}
