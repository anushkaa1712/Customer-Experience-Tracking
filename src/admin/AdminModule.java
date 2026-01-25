package admin;

import java.sql.*;
import java.util.Scanner;
import db.DBConnection;

public class AdminModule 
 {

    public static boolean adminLogin() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Admin Username: ");
        String uname = sc.next();
        System.out.print("Enter Admin Password: ");
        String pass = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "SELECT * FROM admin WHERE username=? AND password=?"
                );

            ps.setString(1, uname);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            return rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void viewComplaints() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM complaint");

            while (rs.next()) {
                System.out.println(
                    rs.getInt("com_id") + " | " +
                    rs.getString("description") + " | " +
                    rs.getString("status")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void updateComplaintStatus() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Complaint ID: ");
        int id = sc.nextInt();

        System.out.print("Enter New Status: ");
        String status = sc.next();

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps =
                con.prepareStatement(
                    "UPDATE complaint SET status=? WHERE com_id=?"
                );

            ps.setString(1, status);
            ps.setInt(2, id);
            ps.executeUpdate();

            System.out.println("Status Updated");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
