package model.customer;

import model.order.Coat;
import model.order.Order;
import model.order.Pants;
import model.order.Shirt;

import java.util.List;

public class Customer extends Thread {
    private String customerName;
    private List<Order> orders;

    private final int kotDressingSpeed = 500;
    private final int shalvarDressingSpeed = 400;
    private final int pirahanDressingSpeed = 500;

    private final int pirahanPrice = 17000;
    private final int shalvarPrice = 23000;
    private final int kotPrice = 30000;

    public Customer(String customerName, List<Order> orders) {
        this.customerName = customerName;
        this.orders = orders;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public synchronized void run() {
        try {
            int priceSum = 0;
            for (Order order : orders) {
                if (order instanceof Coat) {
                    Thread.sleep(kotDressingSpeed);
                    priceSum += kotPrice;

                } else if (order instanceof Shirt) {
                    Thread.sleep(pirahanDressingSpeed);
                    priceSum += pirahanPrice;

                } else if (order instanceof Pants) {
                    Thread.sleep(shalvarDressingSpeed);
                    priceSum += shalvarPrice;

                }

            }

            System.out.println(customerName + " puts " + priceSum + " in dressing room and Exit.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
