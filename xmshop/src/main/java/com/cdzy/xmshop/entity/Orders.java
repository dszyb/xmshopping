package com.cdzy.xmshop.entity;

import java.util.Date;
import java.util.List;

public class Orders {
    private String ordersId;

    private float total;

    private int status;
    
    private Date createTime;
    
    private int usersId;

    private int receiverId;
    
    private Receiver receiver;
    
    private List<Items> items;
    
	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}
	
	public Receiver getReceiver() {
		return receiver;
	}

	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public Orders() {
		super();
	}

	public Orders(String ordersId, float total, int status, Date createTime, int usersId, int receiverId,
			Receiver receiver) {
		super();
		this.ordersId = ordersId;
		this.total = total;
		this.status = status;
		this.createTime = createTime;
		this.usersId = usersId;
		this.receiverId = receiverId;
		this.receiver = receiver;
	}

	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", total=" + total + ", status=" + status + ", createTime=" + createTime
				+ ", usersId=" + usersId + ", receiverId=" + receiverId + ", receiver=" + receiver + ", items=" + items
				+ "]";
	}

}