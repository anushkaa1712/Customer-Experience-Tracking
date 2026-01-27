package CX;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

    static ArrayList<Customer> customers = new ArrayList<>();
    static Customer loggedInCustomer = null;

    // CREATE PROFILE (Registration)
    public static void register() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        System.out.print("Name: ");
        String name = sc.next();

        System.out.print("Email: ");
        String email = sc.next();

        System.out.print("Phone: ");
        String phone = sc.next();

        customers.add(new Customer(username, password, name, email, phone));
        System.out.println("Profile created successfully");
    }

    // LOGIN
    public static boolean login() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Username: ");
        String username = sc.next();

        System.out.print("Password: ");
        String password = sc.next();

        for (Customer c : customers) {
            if (c.username.equals(username) && c.password.equals(password)) {
                loggedInCustomer = c;
                System.out.println("Login successful");
                return true;
            }
        }
        System.out.println("Invalid login");
        return false;
    }

    // EDIT PROFILE
    public static void editProfile() {
        if (loggedInCustomer == null) {
            System.out.println("Please login first");
            return;
        }

        Scanner sc = new Scanner(System.in);

        System.out.print("New Name: ");
        loggedInCustomer.name = sc.next();

        System.out.print("New Email: ");
        loggedInCustomer.email = sc.next();

        System.out.print("New Phone: ");
        loggedInCustomer.phone = sc.next();

        System.out.println("Profile updated successfully");
    }
}
