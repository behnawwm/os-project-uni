
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
            if (name.equals("Firooz"))
                System.out.println("Haji Firooz gets orders.");
            else
                System.out.println("Tailor " + name + " gets orders.");

            for (Customer customer : givenCustomers) {
                for (Order order : customer.orders) {
                    if (order instanceof Coat) {
                        Thread.sleep(kotSpeed);

                    } else if (order instanceof Shirt) {
                        Thread.sleep(pirahanSpeed);

                    } else if (order instanceof Pants) {
                        Thread.sleep(shalvarSpeed);

                    }
                }

                if (name.equals("Firooz"))
                    System.out.println("Haji Firooz prepares order of " + customer.name);
                else
                    System.out.println("Tailor " + name + " Firooz prepares order of " + customer.name);

                customer.start();
            }
            if (name.equals("Firooz"))
                System.out.println("Haji Firooz completes his task");
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
