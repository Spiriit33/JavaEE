package cours.model;

import java.sql.Connection;
import java.sql.*;
public class DatabaseManager {
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/javaproject";
//  Database credentials
    static final String USER = "root";
    static final String PASS = "corleone";

    public static Connection getConnection() { 
        Connection conn1 = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); 
        	 conn1 = DriverManager.getConnection(DB_URL,USER,PASS);
        } catch (Exception e) {
        	e.printStackTrace();
        }
        return conn1;
    }
}
