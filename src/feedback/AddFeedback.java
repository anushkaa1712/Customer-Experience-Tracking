package feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import db.DBConnection;

public class AddFeedback {  //Feedback Module

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();

        System.out.print("Enter Rating: ");
        int rating = sc.nextInt();

        sc.nextLine();
        System.out.print("Enter Comments: ");
        String comments = sc.nextLine();

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
            con.prepareStatement(
                "INSERT INTO feedback(cust_id, rating, comments, fb_date) VALUES (?, ?, ?, CURDATE())"
            );

        ps.setInt(1, cid);
        ps.setInt(2, rating);
        ps.setString(3, comments);

        ps.executeUpdate();

        System.out.println("Feedback Added Successfully");
    }
}
