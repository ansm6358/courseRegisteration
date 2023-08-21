package control;

import entity.EPersonalInfo;
import valueObject.VCPersonalInfo;
import valueObject.VEPersonalInfo;

public class CPersonalInfo {

	private EPersonalInfo ePersonalInfo;
	
	public CPersonalInfo() {
		this.ePersonalInfo = new EPersonalInfo();
	}
	
	public VCPersonalInfo getPersonalInfo(String id) {
		//get data from entity
		VEPersonalInfo vEPersonalInfo = this.ePersonalInfo.getPersonalInfo(id);
		
		//create control value object and set data from entity value object
		VCPersonalInfo vCPersonalInfo = new VCPersonalInfo();
		vCPersonalInfo.setId(vEPersonalInfo.getId());
		vCPersonalInfo.setName(vEPersonalInfo.getName());
		
		return vCPersonalInfo;
	}

}
