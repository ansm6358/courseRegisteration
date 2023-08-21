package control;

import java.util.Vector;

import entity.EDirectory;
import valueObject.VCDirectory;
import valueObject.VEDirectory;

public class CDirectory {

	private EDirectory eDirectory;
	private  Vector<VCDirectory> vCDirectories;
	
	public CDirectory() {
		this.eDirectory = new EDirectory();
	}

	public Vector<VCDirectory> getData(String filename) {
		Vector<VEDirectory> vEDirectories = this.eDirectory.getData(filename);
		this.vCDirectories = new Vector<VCDirectory>();
		for (VEDirectory vEDirectory: vEDirectories) {
			VCDirectory  vCDirectory = new VCDirectory();
			vCDirectory.setId(vEDirectory.getId());
			vCDirectory.setText(vEDirectory.getText());
			vCDirectory.setFilename(vEDirectory.getFilename());
			this.vCDirectories.add(vCDirectory);
		}
		
		
		
		
		return this.vCDirectories;
	}

}
