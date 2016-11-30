package ht.tm.dev.currys.showhow.db.dto;

public class UserDTO {

	int id;
	String username;
	String name;
	String password;
	
	public UserDTO(int id, String username, String name, String password) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.password = password;
	}
	
	
}
