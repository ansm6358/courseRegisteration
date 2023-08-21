package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import valueObject.VPersinalInfo;

public class EPersonalInfo {
	private String sID;
	private String name;
	private VPersinalInfo vPersonalInfo;
	
	public static VPersinalInfo getPersonalInfo(String id) throws FileNotFoundException {
		File file = new File("data/student.txt");
		Scanner scanner = new Scanner(file);
		VPersinalInfo vPersonalInfo = new VPersinalInfo();
		
		while(scanner.hasNext()) {
			String sID = scanner.next();
			String name = scanner.next();
				if(id.equals(sID)) {
					vPersonalInfo.setId(sID);
					vPersonalInfo.setName(name);
					return vPersonalInfo;
				}		
		}
		scanner.close();
		return null;

	}

}
