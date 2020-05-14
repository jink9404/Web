package info.beans;

public class InfoBean {
	private String name;
	private String id;
	
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
