package valueObject;

import java.util.Scanner;

public class VMChangePw {
	private String id;
	private String password;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void readFromFile(Scanner scanner) {
		this.id = scanner.next();
		this.password = scanner.next();		
	}
	
}
