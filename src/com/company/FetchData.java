package com.company;

import java.sql.*;

public class FetchData {
        String url="jdbc:mysql://localhost:3306/database1";
        String username="root";
        String password="shanmugi";
        public void select(){
            try  {
                Connection con = DriverManager.getConnection(url, username, password);
                Statement st = con.createStatement();
                String s="select * from database1.users";
                ResultSet rs = st.executeQuery(s);
                if (rs.next()){
                    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                            " "+rs.getDate(4)+" "+rs.getString(5)+" "+rs.getInt(6)+
                            " "+rs.getString(7)+" "+rs.getLong(8)+" "+rs.getString(9));
                }else{
                    System.out.println("no records available");
                }
            }
            catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
    }


