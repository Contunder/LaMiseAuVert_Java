package DAO;

public class AnimalDAO {
	
	private String url;
	private String dbName;
	private String userName;
	private String password;
	
	public AnimalDAO (String paramUrl, String paramDBName, String paramUserName, String paramPassword) {
		this.url = paramUrl;
		this.dbName = paramDBName;
		this.userName = paramUserName;
		this.password = paramPassword;
	}

}
