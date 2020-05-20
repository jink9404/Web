package info.beans;

public class InfoBean {
	private String name;
	private String id;
	
	private int getsu;
	private boolean flag;
	
	
	
	public int getGetsu() {
		return getsu;
	}
	public void setGetsu(int getsu) {
		this.getsu = getsu;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public String getGender() {
		char sex = id.charAt(7);
		if (sex == '1'||sex =='3')return "남자";
		else return "여자";
	}
}
