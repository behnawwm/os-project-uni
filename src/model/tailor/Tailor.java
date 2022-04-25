package model.tailor;

import model.customer.Customer;
import model.order.Coat;
import model.order.Order;
import model.order.Pants;
import model.order.Shirt;

import java.util.ArrayList;

public abstract class Tailor extends Thread {
    String name;
    ArrayList<Customer> givenCustomers = new ArrayList<>();
    int kotSpeed;
    int pirahanSpeed;
    int shalvarSpeed;

    public Tailor(String name, int kotSpeed, int pirahanSpeed, int shalvarSpeed) {
        this.name = name;
        this.kotSpeed = kotSpeed;
        this.pirahanSpeed = pirahanSpeed;
        this.shalvarSpeed = shalvarSpeed;
    }

    @Override
    public synchronized void run() {
        try {
            if (name.equals("model.tailor.Firooz"))
                System.out.println("Haji model.tailor.Firooz gets orders.");
            else
                System.out.println("Tailor " + name + " gets orders.");

            for (Customer customer : givenCustomers) {
                for (Order order : customer.getOrders()) {
                    if (order instanceof Coat) {
                        Thread.sleep(kotSpeed);

                    } else if (order instanceof Shirt) {
                        Thread.sleep(pirahanSpeed);

                    } else if (order instanceof Pants) {
                        Thread.sleep(shalvarSpeed);

                    }
                }

                if (name.equals("model.tailor.Firooz"))
                    System.out.println("Haji model.tailor.Firooz prepares order of " + customer.getCustomerName());
                else
                    System.out.println("Tailor " + name + " model.tailor.Firooz prepares order of " + customer.getCustomerName());

                customer.start();
            }
            if (name.equals("model.tailor.Firooz"))
                System.out.println("Haji model.tailor.Firooz completes his task");
            else
                System.out.println("Tailor " + name + " completes his task");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        this.givenCustomers.add(customer);
    }
}
