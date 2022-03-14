package Controller;

public class DBConnect {
	
	static String url="jdbc:mysql://127.0.0.1:8889/";
	static String dbName = "lamiseauvert";
	static String userName = "valentin";
	static String password = "kilabilon";
	
	public static String getUrl() {
		return url;
	}
	
	public static String getDbName() {
		return dbName;
	}
	
	public static String getUserName() {
		return userName;
	}

	public static String getPassword() {
		return password;
	}
	

}
