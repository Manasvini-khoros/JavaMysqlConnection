package com.company;

import java.sql.*;
import java.util.Scanner;

public class DeleteData {
    String url = "jdbc:mysql://localhost:3306/database1";
    String username = "root";
    String pass = "shanmugi";

    public void delete() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("enter user id for deletion of data:");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String s = "select * from users where USER_ID=" + id;
            PreparedStatement my = conn.prepareStatement(s);
            ResultSet r = my.executeQuery();
            if (r.next()) {
                String str = "delete from users where USER_ID="+id;
            PreparedStatement st = conn.prepareStatement(str);
            st.executeUpdate();
            System.out.println("deleted successfully");
            } else {
                System.out.println("Invalid user");
            }
        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
