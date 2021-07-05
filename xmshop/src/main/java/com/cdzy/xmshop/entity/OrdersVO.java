package com.cdzy.xmshop.entity;

import java.util.Date;

public class OrdersVO {
	private String ordersId;

    private float total;

    private int status;
    
    private String receiverName;

    private String receiverPhone;
    
    private Date createTime;

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

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public OrdersVO(String ordersId, float total, int status, String receiverName, String receiverPhone,
			Date createTime) {
		super();
		this.ordersId = ordersId;
		this.total = total;
		this.status = status;
		this.receiverName = receiverName;
		this.receiverPhone = receiverPhone;
		this.createTime = createTime;
	}

	public OrdersVO() {
		super();
	}

	@Override
	public String toString() {
		return "OrdersVO [ordersId=" + ordersId + ", total=" + total + ", status=" + status + ", receiverName="
				+ receiverName + ", receiverPhone=" + receiverPhone + ", createTime=" + createTime + "]";
	}
    
}
