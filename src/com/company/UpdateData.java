package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class UpdateData {
    String url = "jdbc:mysql://localhost:3306/database1";
    String username = "root";
    String pass = "shanmugi";

    public void update() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("enter user id for modification of data:");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String s = "select * from users where USER_ID=" + id;
            PreparedStatement my = conn.prepareStatement(s);
            ResultSet r = my.executeQuery();
            //my.setInt(1,id);
            //ResultSet r=my.executeQuery();
            if (r.next()) {
                System.out.println("USER EXISTS");
                System.out.println("enter field to be modified:\n" + "1.First name\n" + "2.Last name\n" + "3.Date of birth\n"+"4.Address\n"+"5.Pincode\n"+"6.State\n"+"7.Contact number\n"+"8.Email id");
                int choice = sc.nextInt();
                String str = null;
            //int p;
                switch (choice) {
                case 1:
                    System.out.println("enter new first name:");
                    sc.nextLine();
                    String fn = sc.nextLine();
                    str = "update users set FIRST_NAME=?where USER_ID=?";
                    PreparedStatement st = conn.prepareStatement(str);
                    st.setString(1, fn);
                    st.setInt(2, id);
                    st.executeUpdate();
                    break;
                case 2:
                    System.out.println("enter new last name:");
                    sc.nextLine();
                    String ln = sc.nextLine();
                    str = "update users set LAST_NAME=? where USER_ID=?";
                    PreparedStatement st1 = conn.prepareStatement(str);
                    st1.setString(1, ln);
                    st1.setInt(2, id);
                    st1.executeUpdate();
                    break;
                case 3:
                    BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("enter Date:");
                    String date=b.readLine();
                    Date d= Date.valueOf(date);
                    str = "update users set DOB=?where USER_ID=?";
                    PreparedStatement st2 = conn.prepareStatement(str);
                    //st.setString(a);
                    st2.setDate(1, d);
                    st2.setInt(2, id);
                    st2.executeUpdate();
                    break;
                case 4:
                    System.out.println("enter new address:");
                    sc.nextLine();
                    String add = sc.nextLine();
                    str = "update users set ADDRESS=?where USER_ID=?";
                    PreparedStatement st3 = conn.prepareStatement(str);
                    st3.setString(1, add);
                    st3.setInt(2, id);
                    st3.executeUpdate();
                    break;
                case 5:
                    System.out.println("enter new pincode:");
                    int p=sc.nextInt();
                    str = "update users set PINCODE=?where USER_ID=?";
                    PreparedStatement st4 = conn.prepareStatement(str);
                    st4.setInt(1, p);
                    st4.setInt(2, id);
                    st4.executeUpdate();
                    break;
                case 6:
                    System.out.println("enter new State:");
                    sc.nextLine();
                    String state = sc.nextLine();
                    str = "update users set STATE=? where USER_ID=?";
                    PreparedStatement st5 = conn.prepareStatement(str);
                    st5.setString(1, state);
                    st5.setInt(2, id);
                    st5.executeUpdate();
                    break;
                case 7:
                    System.out.println("enter new contact number:");
                    long l = sc.nextLong();
                    str = "update users set CONTACT_NUMBER=?where USER_ID=?";
                    PreparedStatement st6 = conn.prepareStatement(str);
                    st6.setLong(1, l);
                    st6.setInt(2, id);
                    st6.executeUpdate();
                    break;
                case 8:
                    System.out.println("enter new email id:");
                    sc.nextLine();
                    String eid = sc.nextLine();
                    str = "update users set EMAIL_ID=?where USER_ID=?";
                    PreparedStatement st7 = conn.prepareStatement(str);
                    st7.setString(1, eid);
                    st7.setInt(2, id);
                    st7.executeUpdate();
                    break;


            }
            System.out.println("Details updated successfully");
            } else {
                System.out.println("INVALID USER");
            }

        }catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
