package com.edu;

public class MemDTO {
	
	private String id;		//아이디(이메일)
	private String passwd;	//비밀번호
	private String name;	//이름
	private String birth;	//생년월일
	private String phone;	//휴대폰번호
	
	MemDTO(){}
	
	public MemDTO(String id, String passwd, String name, String birth, String phone) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.birth = birth;
		this.phone = phone;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	

}
