package com.company;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
		System.out.println("enter process to be done:\n"+"1.insert data\n"+"2.update existing data\n"+"3.fetch data\n"+"4.delete existing data");
		Scanner s=new Scanner(System.in);
		int option=s.nextInt();
		switch(option){
			case 1:
				InsertData i=new InsertData();
				i.insert();
				break;
			case 2:
				UpdateData u=new UpdateData();
				u.update();
				break;
			case 3:
				FetchData f=new FetchData();
				f.select();
				break;
			case 4:
				DeleteData d=new DeleteData();
				d.delete();
				break;
		}
	}
}

