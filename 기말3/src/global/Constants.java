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
	public static enum EMainFrame{ //static  ���������� �޸𸮸� �ʱ�ȭ �ؼ� �ּҸ� �� �� �ؼ� ����� ���°�
		serialVersionUID("1"),
		Title("������û"),
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
		retext("�ǵ�����");	
		
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
 
		name("���¸�");

		
		private String value;
		private EBasketPanel(String value) {this.value = value;}
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
		CancleButton("���");
		
		
		
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
		errormessage("�� ��й�ȣ�� ��й�ȣ Ȯ���� ���� �ʽ��ϴ�.");
		
		
		private String value;
		private EChangePw(String value) {this.value = value;}
		public String getString() {return this.value;}
		public int getInt() {return Integer.parseInt(this.value);}
	}
}

