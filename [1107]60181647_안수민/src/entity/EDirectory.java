package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VEDirectory;

public class EDirectory {
	private Vector<VEDirectory> vEVector;
	
	public Vector<VEDirectory> getDirectory(String filename) {
		
		this.vEVector = new Vector<VEDirectory>();
		
		try {
			File file = new File(filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				VEDirectory vEDirectory = new VEDirectory();
				vEDirectory.readFromFile(scanner);
				this.vEVector.add(vEDirectory);

			}
			scanner.close();
			return this.vEVector;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
