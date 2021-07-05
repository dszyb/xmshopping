package com.cdzy.xmshop.entity;

public class Carts {
    private int id;
    
    private int amount;

    private int usersId;
    
    private int goodsId;
    
    private String cover;
    
    private String name;
    
    private float price;
    
    private Goods goods;
    
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Carts() {
		super();
	}

	public Carts(int id, int amount, int usersId, int goodsId, String cover, String name, float price) {
		super();
		this.id = id;
		this.amount = amount;
		this.usersId = usersId;
		this.goodsId = goodsId;
		this.cover = cover;
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Carts [id=" + id + ", amount=" + amount + ", usersId=" + usersId + ", goodsId=" + goodsId + ", cover="
				+ cover + ", name=" + name + ", price=" + price + "]";
	}
}