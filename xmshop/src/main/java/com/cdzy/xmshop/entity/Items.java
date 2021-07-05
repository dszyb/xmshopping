package com.cdzy.xmshop.entity;

public class Items {
    private int itemsId;
    
    private float price;
    
    private int amount;

    private String ordersId;

    private int goodsId;
    
    private Goods goods;
    
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getItemsId() {
		return itemsId;
	}

	public void setItemsId(int itemsId) {
		this.itemsId = itemsId;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(String ordersId) {
		this.ordersId = ordersId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public Items() {
		super();
	}

	public Items(int itemsId, float price, int amount, String ordersId, int goodsId, Goods goods) {
		super();
		this.itemsId = itemsId;
		this.price = price;
		this.amount = amount;
		this.ordersId = ordersId;
		this.goodsId = goodsId;
		this.goods = goods;
	}

	@Override
	public String toString() {
		return "Items [itemsId=" + itemsId + ", price=" + price + ", amount=" + amount + ", ordersId=" + ordersId
				+ ", goodsId=" + goodsId + ", goods=" + goods + "]";
	}

}