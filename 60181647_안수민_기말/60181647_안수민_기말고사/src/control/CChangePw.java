package control;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import model.MChangePw;
import valueObject.VMChangePw;

public class CChangePw {

	private MChangePw mChangePw;
	
	public CChangePw() {
		this.mChangePw = new MChangePw();
	}
	public void Change(String passWord, String id) throws FileNotFoundException {
		try {
			Vector<VMChangePw> vMChangePws = this.mChangePw.getData(passWord,id);
		
			this.mChangePw.change(vMChangePws);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
