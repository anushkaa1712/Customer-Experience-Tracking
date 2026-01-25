import java.util.Scanner;
import admin.AdminModule;


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Customer Experience Tracking System =====");

        if (AdminModule.adminLogin()) {

            System.out.println("\nAdmin Login Successful");

            while (true) {
                System.out.println("\n1. View Complaints");
                System.out.println("2. Update Complaint Status");
                System.out.println("3. Logout");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        AdminModule.viewComplaints();
                        break;

                    case 2:
                        AdminModule.updateComplaintStatus();
                        break;

                    case 3:
                        System.out.println("Logged Out Successfully");
                        System.exit(0);

                    default:
                        System.out.println("Invalid Choice");
                }
            }

        } else {
            System.out.println("Invalid Admin Credentials");
        }
    }
}
