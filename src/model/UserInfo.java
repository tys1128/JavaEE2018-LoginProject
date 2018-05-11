package model;

public class UserInfo implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2140425592413767828L;
	int id;
	String name;
	String password;
	String major;
	public UserInfo() {}
	public UserInfo(int id, String name, String password, String major) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.major = major;
	}
	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", name=" + name + ", password=" + password + ", major=" + major + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}

	
}
