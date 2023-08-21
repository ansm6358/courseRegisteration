package control;

import java.util.Vector;

import entity.EDirectory;
import valueObject.VCDirectory;
import valueObject.VEDirectory;

public class CDirectory {

	private EDirectory eDirectory;
	private Vector<VEDirectory> vEVector;
	private Vector<VCDirectory> vCVector;
	
	public CDirectory() {
		this.eDirectory = new EDirectory();
		this.vEVector = new Vector<VEDirectory>();
	}
	
	public Vector<VCDirectory> getData(String filename) {
		this.vEVector = this.eDirectory.getDirectory(filename);
		this.vCVector = new Vector<VCDirectory>();

		
		for(VEDirectory vEDirectory: this.vEVector) {
		VCDirectory vCDirectory  = new VCDirectory();			
		vCDirectory.setData(vEDirectory);

		this.vCVector.add(vCDirectory);
		}
		return this.vCVector;
	}

}
