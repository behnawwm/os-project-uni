package model.secretary;

import model.customer.Customer;
import model.order.Coat;
import model.order.Order;
import model.order.Pants;
import model.order.Shirt;
import model.tailor.Tailor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Secretary extends Thread {
    ArrayList<Tailor> tailors;

    public Secretary(ArrayList<Tailor> tailors) {
        this.tailors = tailors;
    }

    @Override
    public synchronized void run() {
        //get customer count and update customer product list
        String filePath = "/home/behnam/IdeaProjects/OsProject1/src/sample_data/file.txt";  //todo make it relative path
        ArrayList<Customer> customers = readCustomersFromFile(filePath);

        for (int i = 0; i < customers.size(); i++) {
            giveCustomerToTailor(customers.get(i), tailors.get(i % tailors.size()));
        }
        System.out.println("Secretary completes his task.");

        for (Tailor tailor : tailors) {
            tailor.start();
        }

    }

    private ArrayList<Customer> readCustomersFromFile(String filePath) {
        ArrayList<Customer> customers = new ArrayList<>();

        try (Scanner in = new Scanner(new FileReader(filePath))) {
            while (in.hasNext()) {
                int count = in.nextInt();
                in.nextLine();
                for (int i = 0; i < count; i++) {
                    String customerName = "";
                    List<Order> customerOrders = new ArrayList<>();

                    String[] lineContents = in.nextLine().split(" ");
                    for (String t : lineContents) {
                        switch (t) {
                            case "shalvar": {
                                customerOrders.add(new Pants());
                                break;
                            }
                            case "pirahan": {
                                customerOrders.add(new Shirt());
                                break;
                            }
                            case "kot": {
                                customerOrders.add(new Coat());
                                break;
                            }
                            default: {  //name of the customer
                                customerName = t;
                            }
                        }
                    }
                    customers.add(new Customer(customerName, customerOrders));
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    public void giveCustomerToTailor(Customer customer, Tailor tailor) {
        tailor.addCustomer(customer);
    }

}
