package global;

public class Constants {
	public static enum GMainFrame{ //static  ���������� �޸𸮸� �ʱ�ȭ �ؼ� �ּҸ� �� �� �ؼ� ����� ���°�
		
		gWidth("800"),
		gHeight("600");
		
		private String value;
		private GMainFrame(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}

	public static enum TMainFrame{
		tTitle("������û");
		
		private String value;
		private TMainFrame(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	
	public static enum GLoginDialog {
		
		gNameTextSize("15"),
		gPasswordTextSize("15"),
		gWidth("300"),
		gHeight("200");
		
		private String value;
		private GLoginDialog(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	
	public static enum TLoginDialog {
		tNameLable(" ���̵�  "),
		tPasswordLable("��й�ȣ"),
		tOkButton("OK"),
		tCancleButton("cancle"),
		tFailMessage("Ʋ�Ƚ��ϴ�."),
		tFailTitle("�α��ν���");
		
		private String value;
		private TLoginDialog(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	public static enum TPersonalInfo{
		tLbInsaPostfix("�� �ȳ��ϼ���"),
		tBtnInfo("��������"),
		tBtnLogout("�α׾ƿ�");
		
		private String value;
		private TPersonalInfo(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	
	public static enum DDirectoryPanel{
		dFileName("root");
		
		private String value;
		private DDirectoryPanel(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	public static enum DEDirectory{
		dFileName("data/");
		
		private String value;
		private DEDirectory(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	public static enum DEPersonalInfo{
		dFileName("data/student");
		
		private String value;
		private DEPersonalInfo(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	public static enum DELogin{
		dFileName("data/login");
		
		private String value;
		private DELogin(String value) {
			this.value = value;
		}
		public String getString() {
			return this.value;
		}
		public int getInt() {
			return Integer.parseInt(this.value);		
		}
	}
	}

