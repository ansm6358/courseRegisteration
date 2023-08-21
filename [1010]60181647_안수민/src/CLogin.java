
public class CLogin {
	private ELogin eLogin;
	
	public boolean valudateUser(String ID, String password) {
		this.eLogin = new ELogin();		
		boolean result = this.eLogin.valudateUser(ID, password);
		return result;
	}

}
