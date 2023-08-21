package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VEDirectory;

public class EDirectory {

	private Vector<VEDirectory> vEDirectories;
	
	public EDirectory() {
		this.vEDirectories = new Vector<VEDirectory>();
	}

	public Vector<VEDirectory> getData(String filename) {
		try {
			this.vEDirectories.clear();
			
			File file = new File("data/"+filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				VEDirectory vEDirectory = new VEDirectory();
				vEDirectory.readFromFile(scanner);
				this.vEDirectories.add(vEDirectory);				
			}
			scanner.close();	
			return this.vEDirectories;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
