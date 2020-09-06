package com.company;

import java.io.*;
import java.sql.*;
import java.util.Scanner;

public class InsertData {
    String url = "jdbc:mysql://localhost:3306/database1";
    String username = "root";
    String pass = "shanmugi";

    public void insert() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            String s = "INSERT INTO users VALUES(?,?,?,?,?,?,?,?,?);";
            PreparedStatement my = conn.prepareStatement(s);
            Scanner scan = new Scanner(System.in);

            System.out.println("enter User id:");
            int id = scan.nextInt();

            scan.nextLine();
            System.out.println("enter First name:");
            String f_name = scan.nextLine();

            System.out.println("enter Last name:");
            String s_name = scan.nextLine();

            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("enter Date:");
            String str=b.readLine();
            Date d= Date.valueOf(str);

            System.out.println("enter Address:");
            String add = scan.nextLine();

            System.out.println("enter Pincode:");
            int pc = scan.nextInt();

            scan.nextLine();
            System.out.println("enter State:");
            String state = scan.nextLine();

            System.out.println("enter Contact number:");
            long cn = scan.nextLong();

            scan.nextLine();
            System.out.println("enter Email id:");
            String email = scan.nextLine();

            my.setInt(1, id);
            my.setString(2, f_name);
            my.setString(3, s_name);
            my.setDate(4, d);
            my.setString(5, add);
            my.setInt(6, pc);
            my.setString(7, state);
            my.setLong(8,cn);
            my.setString(9, email);

            my.executeUpdate();
            System.out.println("Details inserted successfully");


        } catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}
