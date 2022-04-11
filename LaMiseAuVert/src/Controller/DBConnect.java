package Controller;

public class DBConnect {
	
	static String url="jdbc:mysql://172.29.106.49:3306/";
	static String dbName = "LaMiseAuVert";
	static String userName = "prof1234";
	static String password = "prof_1234!";
	
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
