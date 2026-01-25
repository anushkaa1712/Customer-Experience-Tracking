package feedback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;
import db.DBConnection;

public class ViewFeedbackByCustomer {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer ID: ");
        int cid = sc.nextInt();

        Connection con = DBConnection.getConnection();

        PreparedStatement ps =
            con.prepareStatement(
                "SELECT * FROM feedback WHERE cust_id=?"
            );

        ps.setInt(1, cid);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(
                rs.getInt("fb_id") + " | " +
                rs.getInt("rating") + " | " +
                rs.getString("comments") + " | " +
                rs.getDate("fb_date")
            );
        }
    }
}
