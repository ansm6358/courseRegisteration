package valueObject;

import java.util.Scanner;

public class VEDirectory {
	private String SubjectId;
	private String SubjectName;
	private String Filename;
	
	public String getSubjectId() {return SubjectId;}
	public void setSubjectId(String subjectId) {SubjectId = subjectId;}
	
	public String getSubjectName() {return SubjectName;}
	public void setSubjectName(String subjectName) {SubjectName = subjectName;}
	
	public String getFilename() {return Filename;}
	public void setFilename(String filename) {Filename = filename;}
	
	public void readFromFile(Scanner scanner) {
		this.SubjectId = scanner.next();
		this.SubjectName = scanner.next();
		this.Filename = scanner.next();
		
	}
	
}
