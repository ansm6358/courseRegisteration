package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

import global.Constants.EDataFileName;
import valueObject.VMDirectory;
import valueObject.VMLecture;

public class MLecture {

	private Vector<VMLecture> vMLectures;
	
	public MLecture() {
		this.vMLectures = new Vector<VMLecture>();
	}

	public Vector<VMLecture> getData(String filename) throws FileNotFoundException {
		this.vMLectures.clear();
		
		File file = new File(EDataFileName.path.getString()+filename);
		if(file.exists()) {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			VMLecture vELecture = new VMLecture();
			vELecture.readFromFile(scanner);
			this.vMLectures.add(vELecture);				
		}
		scanner.close();	
		return this.vMLectures;}
		else {return null;}
}
	public void setData(String fileName, Vector<VMLecture> vMLectures) throws IOException {
		File file = new File(EDataFileName.path.getString()+fileName);
		
		FileWriter fileWriter = new FileWriter(file, false);
		for(VMLecture vMLecture: vMLectures){
			vMLecture.writeToFile(fileWriter);
		}
		fileWriter.close();
	}
}
