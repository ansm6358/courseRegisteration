package control;

import java.io.FileNotFoundException;

import entity.EPersonalInfo;
import valueObject.VPersinalInfo;

public class CPersonalInfo {
	private EPersonalInfo ePersonalInfo;
	private String name;
	
	public VPersinalInfo getPersonalInfo(String id) throws FileNotFoundException {
		this.ePersonalInfo = new EPersonalInfo();
		VPersinalInfo vPersinalInfo = EPersonalInfo.getPersonalInfo(id);
		
		return vPersinalInfo;
	}

}
