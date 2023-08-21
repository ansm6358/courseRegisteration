package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EDataFileName;
import valueObject.VMChangePw;

public class MChangePw {
	
	private Vector<VMChangePw> vMChangePws;

	public MChangePw() {
		this.vMChangePws = new Vector<VMChangePw>();
	}
	
	public Vector<VMChangePw> getData(String passWord, String id) throws FileNotFoundException {
		this.vMChangePws.clear();
		
		File file = new File(EDataFileName.path.getString()+EDataFileName.login.getString());
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			VMChangePw vMChangePw = new VMChangePw();
			vMChangePw.readFromFile(scanner);
			if(vMChangePw.getId().equals(id)) {
				vMChangePw.setPassword(passWord);
			}
			this.vMChangePws.add(vMChangePw);
		}
		scanner.close();
		return this.vMChangePws;
	}

	public void change(Vector<VMChangePw> vMChangePws) throws IOException {
		File file = new File(EDataFileName.path.getString()+EDataFileName.login.getString());
		FileWriter writer = new FileWriter(file, false);
		for(VMChangePw vMChangePw: vMChangePws) {
			writer.write(vMChangePw.getId()+EDataFileName.gap.getString());
			  writer.write(vMChangePw.getPassword()+EDataFileName.jump.getString());
		}
		writer.flush();
		writer.close();
	}

}
