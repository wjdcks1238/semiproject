package kr.common.member.model.vo;

public class MemberVo {
//	tb_user-------- ------------ 
//	ID     NOT NULL VARCHAR2(25) 
//	PASSWD NOT NULL VARCHAR2(30) 
//	NAME   NOT NULL VARCHAR2(20) 
//	EMAIL  NOT NULL VARCHAR2(50) 
	
	private String id;
	private String passwd;
	private String name;
	private String email;
	
	@Override
	public String toString() {
		return "MemberVo [id=" + id + ", passwd=" + passwd + ", name=" + name + ", email=" + email + "]";
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPasswd() {
		return passwd;
	}
	
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
