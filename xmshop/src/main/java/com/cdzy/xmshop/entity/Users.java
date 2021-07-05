package com.cdzy.xmshop.entity;

public class Users {
    private int id;
    
    private String phone;
    
    private String username;

    private String password;

    private String address;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Users() {
		super();
	}

	public Users(int id, String phone, String username, String password, String address) {
		super();
		this.id = id;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", phone=" + phone + ", username=" + username + ", password=" + password
				+ ", address=" + address + "]";
	}

}