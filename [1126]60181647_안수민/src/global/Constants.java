package global;

public class Constants {
	public static enum GMainFrame{ //static  고정적으로 메모리를 초기화 해서 주소를 할 당 해서 만들어 놓는것
		
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
		tTitle("수강신청");
		
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
		tNameLable(" 아이디  "),
		tPasswordLable("비밀번호"),
		tOkButton("OK"),
		tCancleButton("cancle"),
		tFailMessage("틀렸습니다."),
		tFailTitle("로그인실패");
		
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
		tLbInsaPostfix("님 안녕하세요"),
		tBtnInfo("개인정보"),
		tBtnLogout("로그아웃");
		
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

