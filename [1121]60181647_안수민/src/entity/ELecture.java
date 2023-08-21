package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

import valueObject.VEDirectory;
import valueObject.VELecture;

public class ELecture {

	private Vector<VELecture> vELectures;
	
	public ELecture() {
		this.vELectures = new Vector<VELecture>();
	}
	
	public Vector<VELecture> getData(String filename) {
		try {
			this.vELectures.clear();
			
			File file = new File("data/"+filename);
			Scanner scanner = new Scanner(file);
			while(scanner.hasNext()) {
				VELecture vELecture = new VELecture();
				vELecture.readFromFile(scanner);
				this.vELectures.add(vELecture);				
			}
			scanner.close();	
			return this.vELectures;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
