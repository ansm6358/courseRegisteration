package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import model.MDirectory;
import model.MLecture;
import valueObject.VCDirectory;
import valueObject.VCLecture;
import valueObject.VMDirectory;
import valueObject.VMLecture;

public class CLecture {

	private MLecture mLecture;
	
	public CLecture() {
		this.mLecture = new MLecture();
	}

	public Vector<VCLecture> getData(String filename) throws FileNotFoundException {
		Vector<VMLecture> vMLectures = this.mLecture.getData(filename);
		Vector<VCLecture> vCLectures = new Vector<VCLecture>();
		
		for (VMLecture vMLecture: vMLectures) {
			VCLecture  vCLecture = new VCLecture();
			vCLecture.setId(vMLecture.getId());
			vCLecture.setName(vMLecture.getName());
			vCLecture.setProfessorName(vMLecture.getProfessorName());
			vCLecture.setCredit(vMLecture.getCredit());
			vCLecture.setTime(vMLecture.getTime());
			vCLectures.add(vCLecture);
		}
		return vCLectures;
	}
	public void setData(String fileName, Vector<VCLecture> vCLectures) throws IOException {
		Vector<VMLecture> vMLectures = new Vector<VMLecture>();
		for (VCLecture vCLecture: vCLectures) {
			VMLecture vMLecture = new VMLecture();
			vMLecture.setId(vCLecture.getId());
			vMLecture.setName(vCLecture.getName());
			vMLecture.setProfessorName(vCLecture.getProfessorName());
			vMLecture.setCredit(vCLecture.getCredit());
			vMLecture.setTime(vCLecture.getTime());
			vMLectures.add(vMLecture);
		}
		this.mLecture.setData(fileName, vMLectures);
	}
}
