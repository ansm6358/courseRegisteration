import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ELogin {

	public boolean valudateUser(String textID, String textPW) throws FileNotFoundException {
		boolean check = false;
		File file = new File("data/login.txt");
		Scanner scanner = new Scanner(file);
		while(!check&&scanner.hasNext()) {
			String ID= scanner.next();
			String pw= scanner.next();
		if(textID.equals(ID)&&textPW.equals(pw)) {
			check = true;
		}
		else {
			check = false;
		}
	}
		return check;
}
}
