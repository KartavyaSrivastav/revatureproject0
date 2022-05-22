package project0;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCpostgreSql {
	private final String url ="jdbc:postgresql://localhost/bms";
	private final String user = "postgres";
	private final String password = "maakali111";
	
	private void connect() {
		try(Connection connection = DriverManager.getConnection(url,user,password);){
			if (connection!=null) {
				System.out.println("connected to postgresql sucessfully");
				
			}
			else {
				System.out.println("failed to connect");
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
				
				
	}
	public static void main(String[] args) {
		JDBCpostgreSql sqlconnect = new JDBCpostgreSql();
		sqlconnect.connect();
		
	}

}
