package CX;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Register (Create Profile)");
            System.out.println("2. Login");
            System.out.println("3. Edit Profile");
            System.out.println("4. Logout");
            System.out.println("5. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    CustomerService.register();
                    break;

                case 2:
                    CustomerService.login();
                    break;

                case 3:
                    CustomerService.editProfile();
                    break;

                case 4:
                    CustomerLogout.logout();
                    break;

                case 5:
                    System.out.println("System Exit");
                    return;
            }
        }
    }
}
