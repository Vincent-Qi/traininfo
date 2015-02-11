package org.senssic.bean.login;

public class SelfContent {
	private String loginname;
	private String username;
	private String idtype;
	private String idnum;
	private String sex;
	private String country;
	private String birthday;
	private String phonenum;
	private String email;
	@Override
	public String toString() {
      String string=
    		  "用户名：--->"+this.loginname+"\n"+
	          "姓名：--->"+this.username+"\n"+
	          "证件类型：--->"+this.idtype+"\n"+
	          "证件号码：--->"+this.idnum+"\n"+
	          "性别：--->"+this.sex+"\n"+
	          "国家：--->"+this.country+"\n"+
	          "出生日期：--->"+this.birthday+"\n"+
	          "手机号码：--->"+this.phonenum+"\n"+
	          "电子邮件：--->"+this.email;
		return string;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIdtype() {
		return idtype;
	}

	public void setIdtype(String idtype) {
		this.idtype = idtype;
	}

	public String getIdnum() {
		return idnum;
	}

	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
