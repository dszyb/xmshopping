package com.cdzy.xmshop.entity;

public class Receiver {
    private int receiverId;

    private int usersId;

    private String receiverName;

    private String receiverPhone;

    private String receiverProvince;

    private String receiverCity;

    private String receiverDistrict;

    private String receiverAddress;
    
	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverPhone() {
		return receiverPhone;
	}

	public void setReceiverPhone(String receiverPhone) {
		this.receiverPhone = receiverPhone;
	}

	public String getReceiverProvince() {
		return receiverProvince;
	}

	public void setReceiverProvince(String receiverProvince) {
		this.receiverProvince = receiverProvince;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverDistrict() {
		return receiverDistrict;
	}

	public void setReceiverDistrict(String receiverDistrict) {
		this.receiverDistrict = receiverDistrict;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public Receiver() {
		super();
	}

	public Receiver(int receiverId, int usersId, String receiverName, String receiverPhone, String receiverProvince,
			String receiverCity, String receiverDistrict, String receiverAddress) {
		super();
		this.receiverId = receiverId;
		this.usersId = usersId;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.receiverProvince = receiverProvince;
		this.receiverCity = receiverCity;
		this.receiverDistrict = receiverDistrict;
		this.receiverAddress = receiverAddress;
	}

	@Override
	public String toString() {
		return "Receiver [receiverId=" + receiverId + ", usersId=" + usersId + ", receiverName=" + receiverName
				+ ", receiverPhone=" + receiverPhone + ", receiverProvince=" + receiverProvince + ", receiverCity="
				+ receiverCity + ", receiverDistrict=" + receiverDistrict + ", receiverAddress=" + receiverAddress
				+ "]";
	}

}