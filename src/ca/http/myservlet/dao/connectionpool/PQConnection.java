package ca.http.myservlet.dao.connectionpool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ca.http.myservlet.config.ConfigLoader;

class PQConnection {

	private String driverName;
	private String url;
	private String user;
	private String password;
	private int poolSize;
	private  static PQConnection instance ;

	{
		try {
			ConfigLoader configLoader = ConfigLoader.getInstance();
			this.driverName = configLoader.getValue(DBParameter.DB_DRIVER);
			this.url = configLoader.getValue(DBParameter.DB_URL);
			this.user = configLoader.getValue(DBParameter.DB_USER);
			this.password = configLoader.getValue(DBParameter.DB_PASSWORD);
			this.poolSize = Integer.parseInt(configLoader.getValue(DBParameter.DB_POOL_SIZE));
			System.out.println("Initialization PQConnection");
		} catch (Exception e) {
			System.out.println("Initialization PQConnection is faild");
		}

	}
	
	private PQConnection () {}
	
	public static PQConnection getInstance() {
		if (instance == null) {
	        synchronized (PQConnection.class) {
	            if (instance == null) {
	                instance = new PQConnection();
	            }
	        }
	    }
	    return instance;
	}

	public Connection createConnection() {
		Connection connection = null;
		try {
			Class.forName(driverName);
			connection = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Didn't get connection - ClassNotFoundException");
		} catch (SQLException e) {
			System.out.println("Didn't get connection - SQLException");
		}
		return connection;
	}
	
	public int getPoolSize() {
		return poolSize;
	}

}
