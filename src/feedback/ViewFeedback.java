package feedback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import db.DBConnection;

public class ViewFeedback {

    public static void main(String[] args) throws Exception {

        Connection con = DBConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM feedback");

        while (rs.next()) {
            System.out.println(
                rs.getInt("fb_id") + " | " +
                rs.getInt("cust_id") + " | " +
                rs.getInt("rating") + " | " +
                rs.getString("comments") + " | " +
                rs.getDate("fb_date")
            );
        }
    }
}
