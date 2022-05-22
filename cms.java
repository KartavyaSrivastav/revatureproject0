package project0;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class cms {
	public static void main(String[] args) {
		System.out.println("Bank Management System");
		System.out.println("1. New Account");
		System.out.println("2. Show All Accounts");
		System.out.println("3. Delete a specific Account");
		System.out.println("4. Update Account");
		System.out.println("5. Search Details");
		System.out.println("Choose Option");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		switch (choice) {
		case 1:
			cms.insertCustomer();
			break;
		case 2:
			cms.getAllCustomer();;
			break;
		case 3:
			cms.deleteCustomer();
			break;
		case 4:
			cms.updateCustomer();;
			break;
		case 5:
			cms.getCustomerById();
			break;
		default:
			System.out.println("choose  a choice 1-5 ");


		}

	}

	public static void getCustomerById() {
		String url = "jdbc:postgresql://localhost:5432/bank";
		String user = "postgres";
		String password = "maakali111";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Account ID to be searched");
		int cId = s.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from newbank where cId=" + cId + "");
			if (rs.next()) {
				System.out.println(rs.getInt("cId"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("phone"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("amount"));
			} else {
				System.out.println("There is no Customer id existing in the table");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updateCustomer() {

		// get newname,newphone,newaddress
		// load the driver
		// connect to db

		String url = "jdbc:postgresql://localhost:5432/bank";
		String user = "postgres";
		String password = "maakali111";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Account ID to be updated");
		int cId = s.nextInt();
		s.nextLine();
		System.out.println("Enter the new Account name ");
		String name = s.nextLine();
		System.out.println("Enter the new Account phone ");
		String phone = s.nextLine();
		System.out.println("Enter the new address ");
		String address = s.nextLine();
		System.out.println("Enter the amount to be deposited ");
		int amount = s.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int no = stmt.executeUpdate("update newbank set name='" + name + "',phone='" + phone + "',address='"
					+ address + "',amount='"+amount+"' where cId=" + cId + "");
			if (no != 0) {
				System.out.println("customer details updated");
			} else {
				System.out.println("customer details not updated");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void deleteCustomer() {
		// delete
		// scanner get the customer id wanted to delete
		// load the driver
		// connect
		// statement
		// executeUpdate(delete query with where clause)
		String url = "jdbc:postgresql://localhost:5432/bank";
		String user = "postgres";
		String password = "maakali111";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Customer ID you want to delete");
		int cId = s.nextInt();
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int no = stmt.executeUpdate("delete from newbank where cId=" + cId + "");
			if (no != 0) {
				System.out.println("The customer ID:" + cId + " " + "Deleted:" + no);
			} else {
				System.out.println("The customer ID:" + cId + " " + "is not existing");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getAllCustomer() {
		// select query -> resultSet from the db--> process the resultset need to get my
		// data
		// load the driver
		// connect to db
		// statement
		// executeQuery
		// process the resultset
		String url = "jdbc:postgresql://localhost:5432/bank";
		String user = "postgres";
		String password = "maakali111";
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from newbank;");
			while (rs.next()) {// true
				System.out.println(rs.getString("name"));
				System.out.println(rs.getInt("cId"));
				System.out.println(rs.getString("phone"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("amount"));
				System.out.println("******************************");
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insertCustomer() {
		String url = "jdbc:postgresql://localhost:5432/bank";
		String user = "postgres";
		String password = "maakali111";
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the Account ID:");
		int cId = s.nextInt();
		s.nextLine();
		System.out.println("Enter the name");
		String name = s.next();
		s.nextLine();
		System.out.println("Enter the phone");
		String phone = s.nextLine();
		System.out.println("Enter the address");
		String address = s.nextLine();
		System.out.println("Enter the Initial Amount to be submitted");
		int amount = s.nextInt();

		// ********JDBC Code Starts here***********

		try {
			// step 1 Load the Driver class from postgres jdbc driver lib line30
			Class.forName("org.postgresql.Driver");
			// step 2 create a connection to the database line 32
			Connection con = DriverManager.getConnection(url, user, password);
			Statement stmt = con.createStatement();
			int no = stmt.executeUpdate(
					"insert into newbank values('" + name + "'," + cId + ",'" + phone + "','" + address + "'," + amount +")");
			System.out.println("Insert is done" + no);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ********JDBC Code Ends here***********
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		s.close();
	}

}
