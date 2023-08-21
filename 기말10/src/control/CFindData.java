package control;

import model.MFindData;

public class CFindData {
	private MFindData mFindData;
	public String findId(String password, String name) {
		this.mFindData = new MFindData();
		String id = this.mFindData.findId(password, name);	
		return id;
	}

	public String findPw(String id, String name) {
		this.mFindData = new MFindData();
		String pw = this.mFindData.findPw(id, name);
		return pw;
	}

}
