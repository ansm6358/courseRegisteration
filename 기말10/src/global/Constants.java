package global;

public class Constants {
	public static enum EDataFileName{
		path("data/"),
		root("root"),
		login("login"),
		personalInfo("student"),
		gap(" "),
		jump("\r\n"),
		basket("Basket"),
		result("Result");
		
		
		private String value;
		private EDataFileName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	public static enum EImageName{
		imageFile("image/"),
		ok("image/check.png"),
		cancel("image/cancel.png"),
		logout("image/logout.png"),
		change("image/change.png"),
		changePw("image/changePw.png"),
		info("image/info.png"),
		timeTable("image/timeTable.png"),
		clock("image/clock.png");
		
		
		private String value;
		private EImageName(String value) {this.value = value;}
		public String getString() {return this.value;}
	}
	public static enum EMainFrame{ //static  ���������� �޸𸮸� �ʱ�ȭ �ؼ� �ּҸ� �� �� �ؼ� ����� ���°�
		serialVersionUID("1"),
		Title("������û"),
		Width("1050"),
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
		NameLable(" ���̵�  "),
		NameTextSize("15"),
		PasswordLable("��й�ȣ"),
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
		LbInsaPostfix("�� �ȳ��ϼ���"),
		BtnInfo("��������"),
		BtnLogout("�α׾ƿ�"),
		name("�̸�: "),
		id("�й�: "),
		gap("   "),
		retext("�ǵ�����"),
		changePW("��й�ȣ ����"),
		timetable("�ð�ǥ"),
		credit("����"),
		creditText("����: ");	
		
		private String value;
		private EPersonalInfoPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EErrorDialog{
		serialVersionUID("1"),
		title("����"),
		message("�߸� �Է� �߽��ϴ�");
		
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
		id("���¹�ȣ"), 
		name("���¸�"),
		professorName("������"),
		credit("����"),
		time("�ð�");
		
		private String value;
		private ELecturePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}

	public static enum EBasketPanel{
		serialVersionUID("1"),
		
		num("���¹�ȣ"),
		name("���¸�");

		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum ETooltip{
		serialVersionUID("1"),
		
		time("���ǽð�: ");

		
		private String value;
		private ETooltip(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EFindData {
		serialVersionUID("1"),
		width("300"),
		height("200"),
		IdLable(" ���̵�  "),
		IdTextSize("15"),
		NameLable(" �̸�      "),
		NameTextSize("15"),
		PasswordLable("��й�ȣ"),
		PasswordTextSize("15"),
		OkButton("Ȯ��"),
		CheckId("findId"),
		CheckPw("findPw"),
		CancleButton("���"),
		findId("���̵� ã��"),
		findPw("��й�ȣ ã��");
		
		
		
		private String value;
		private EFindData(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	
	public static enum EFindResult{
		serialVersionUID("1"),
		error("����"),
		find("�߰�"),
		findMessage("����� ���̵�: "),
		errormessage("�Է��� ������ ���� �ʽ��ϴ�.");
		
		private String value;
		private EFindResult(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EChangePw {
		serialVersionUID("1"),
		width("300"),
		height("200"),
		passwordLable(" �� ��й�ȣ   "),
		passwordTextSize("15"),
		checkPWLable("��й�ȣ Ȯ��"),
		ckeckPWTextSize("15"),
		OkButton("OK"),
		CancleButton("cancle"),
		errormessage("�� ��й�ȣ�� ��й�ȣ Ȯ���� ���� �ʽ��ϴ�."),
		success("����"),
		successMessage("��й�ȣ�� ����Ǿ����ϴ�");
			
		private String value;
		private EChangePw(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
	public static enum EMovePanel{
		serialVersionUID("1"),
		leftButton("leftButton"),
		rightButton("rightButton"),
		left("<"),
		right(">");
		
		private String value;
		private EMovePanel(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}

