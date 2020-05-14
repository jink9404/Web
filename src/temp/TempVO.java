package temp;

public class TempVO {
	private String id;
	private String pass;
	private String name;
	private String tel;
	private String addr;
	private TempVO() {}
	private static TempVO tempvo=null;
	public static TempVO getInstance() {
		if(tempvo==null)
			tempvo = new TempVO();
		return tempvo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
