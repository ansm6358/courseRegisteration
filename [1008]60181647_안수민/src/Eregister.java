import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Eregister {

	public static String detData(String ID) throws FileNotFoundException {
		File file = new File("data/student.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String sID = scanner.next();
			String name = scanner.next();
				if(ID.equals(sID)) {
					return name;
				}		
		}
		scanner.close();
		return null;
	}

}
