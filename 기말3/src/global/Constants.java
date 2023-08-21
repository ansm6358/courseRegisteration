package global;

public class Constants {
	public static enum EDataFileName{
		path("data/"),
		root("root"),
		login("login"),
		personalInfo("student"),
		gap(" "),
		jump("\r\n");
		
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	public static enum EMainFrame{ //static  고정적으로 메모리를 초기화 해서 주소를 할 당 해서 만들어 놓는것
		serialVersionUID("1"),
		Title("수강신청"),
		Width("800"),
		Height("600");
		
		private String value;
		private EMainFrame(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum ELoginDialog {
		serialVersionUID("1"),
		width("300"),
		height("200"),
		NameLable(" 아이디  "),
		NameTextSize("15"),
		PasswordLable("비밀번호"),
		PasswordTextSize("15"),
		OkButton("OK"),
		CancleButton("cancle");
		
		
		
		private String value;
		private ELoginDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EPersonalInfoPanel{
		serialVersionUID("1"),
		LbInsaPostfix("님 안녕하세요"),
		BtnInfo("개인정보"),
		BtnLogout("로그아웃"),
		name("이름: "),
		id("학번: "),
		gap("   "),
		retext("되돌리기");	
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog{
		serialVersionUID("1"),
		title("오류"),
		message("잘못 입력 했습니다");
		
		private String value;
		private EErrorDialog(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EDirectoryPanel{
		serialVersionUID("1");
		
		private String value;
		private EDirectoryPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum ELecturePanel{
		serialVersionUID("1"),
		id("강좌번호"), 
		name("강좌명"),
		professorName("교수명"),
		credit("학점"),
		time("시간");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}

	public static enum EBasketPanel{
		serialVersionUID("1"),
 
		name("강좌명");

		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EFindData {
		serialVersionUID("1"),
		width("300"),
		height("200"),
		IdLable(" 아이디  "),
		IdTextSize("15"),
		NameLable(" 이름      "),
		NameTextSize("15"),
		PasswordLable("비밀번호"),
		PasswordTextSize("15"),
		OkButton("확인"),
		CheckId("findId"),
		CheckPw("findPw"),
		CancleButton("취소");
		
		
		
		private String value;
		private EFindData(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EFindResult{
		serialVersionUID("1"),
		error("오류"),
		find("발견"),
		findMessage("당신의 아이디: "),
		errormessage("입력한 정보가 맞지 않습니다.");
		
		private String value;
		private EFindResult(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EChangePw {
		serialVersionUID("1"),
		width("300"),
		height("200"),
		passwordLable(" 새 비밀번호   "),
		passwordTextSize("15"),
		checkPWLable("비밀번호 확인"),
		ckeckPWTextSize("15"),
		OkButton("OK"),
		CancleButton("cancle"),
		errormessage("새 비밀번호와 비밀번호 확인이 같지 않습니다.");
		
		
		private String value;
		private EChangePw(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}

