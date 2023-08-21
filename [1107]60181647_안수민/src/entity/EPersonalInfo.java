package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VEPersonalInfo;

public class EPersonalInfo {

	public VEPersonalInfo getPersonalInfo(String id) {
		VEPersonalInfo vEPersonalInfo = new VEPersonalInfo();
		try {
			File file = new File("data/student");
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				vEPersonalInfo.readFromFile(scanner);
				if(vEPersonalInfo.getId().equals(id)) {
					return vEPersonalInfo;
				}
				
			}
			scanner.close();	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
