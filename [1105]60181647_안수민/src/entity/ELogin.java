package entity;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ELogin {

	public boolean valudateUser(String ID, String password) {
		try {
			File file = new File("data/login.txt");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				String sID = scanner.next();
				String sPassword = scanner.next();
				if(ID.equals(sID) && password.equals(sPassword)) {									
					scanner.close();
					return true;
				}
			}
			scanner.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
