package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import global.Constants.EDataFileName;

public class MFindData {

	public String findId(String password, String name) {
		String DataId = checkId(name);
		if(DataId != null) {
		String DataPw = checkPw(DataId);
		
		if(password.equals(DataPw)) {
			return DataId;
		}
		}
			return null;
	}


	public String findPw(String id, String name) {
		String DataId = checkId(name);
		if(id.equals(DataId)) {
			String DataPw = checkPw(id);
			return DataPw;
		}
		
		return null;
	}
	private String checkId(String name) {
		try {
			File file = new File(EDataFileName.path.getString()+EDataFileName.personalInfo.getString());
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
			String DataId = scanner.next();
			String DataName = scanner.next();
			if(name.equals(DataName)) {
				scanner.close();
				return DataId;
			}
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	private String checkPw(String id) {
		try {
			File file = new File(EDataFileName.path.getString()+EDataFileName.login.getString());		
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
			String DataId = scanner.next();
			String DataPw = scanner.next();
			if(id.equals(DataId)) {
				scanner.close();
				return DataPw;
			}			
			}scanner.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
