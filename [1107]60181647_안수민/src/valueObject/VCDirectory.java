package valueObject;

public class VCDirectory {
	private String SubjectId;
	private String SubjectName;
	private String Filename;
	
	public String getSubjectId() {return SubjectId;}
	public void setSubjectId(String subjectId) {SubjectId = subjectId;}
	
	public String getSubjectName() {return SubjectName;}
	public void setSubjectName(String subjectName) {SubjectName = subjectName;}
	
	public String getFilename() {return Filename;}
	public void setFilename(String filename) {Filename = filename;}

	public void setData(VEDirectory vEDirectory) {
		this.SubjectId =vEDirectory.getSubjectId();
		this.SubjectName =vEDirectory.getSubjectName();
		this.Filename = vEDirectory.getFilename();

	}
	
	
}
