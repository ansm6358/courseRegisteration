package control;

import java.util.Vector;

import entity.EDirectory;
import entity.ELecture;
import valueObject.VCDirectory;
import valueObject.VCLecture;
import valueObject.VELecture;

public class CLecture {

	private ELecture eLecture;
	private Vector<VCLecture> vCLectures;
	
	public CLecture () {
		this.eLecture = new ELecture();
	}
	
	public Vector<VCLecture> getData(String filename) {
		Vector<VELecture> vELectures = this.eLecture.getData(filename);
		this.vCLectures = new Vector<VCLecture>();
		for(VELecture vELecture: vELectures) {
			VCLecture vCLecture = new VCLecture();
			vCLecture.setId(vELecture.getId());
			vCLecture.setClassName(vELecture.getClassName());
			vCLecture.setProfessor(vELecture.getProfessor());
			vCLecture.setCredit(vELecture.getCredit());
			vCLecture.setTime(vELecture.getTime());		
			this.vCLectures.add(vCLecture);
		}
		return this.vCLectures;
	}

}
