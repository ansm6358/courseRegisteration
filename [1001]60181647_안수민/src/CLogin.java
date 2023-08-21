import java.io.FileNotFoundException;

public class CLogin {
	private ELogin eLogin;
	
	public boolean valudateUser(String textID, String textPW) throws FileNotFoundException {
		this.eLogin = new ELogin();		
		return this.eLogin.valudateUser(textID, textPW);
	}

}
