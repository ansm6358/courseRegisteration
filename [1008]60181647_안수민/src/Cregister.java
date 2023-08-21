import java.io.FileNotFoundException;

public class Cregister {
	private Eregister eregister;
	
	public String getData(String ID) throws FileNotFoundException {
		this.eregister = new Eregister();
		String name = Eregister.detData(ID);
		return name;
	}

}
