package com.cdzy.xmshop.entity;

public class Goods {
    private int id;

    private String cover;

    private String name;

    private Float price;

    private String intro;

    private String color;

    private String edition;
    
    private int quantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Goods() {
		super();
	}

	public Goods(int id, String cover, String name, Float price, String intro, String color, String edition,
			int quantity) {
		super();
		this.id = id;
		this.cover = cover;
		this.name = name;
		this.price = price;
		this.intro = intro;
		this.color = color;
		this.edition = edition;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", cover=" + cover + ", name=" + name + ", price=" + price + ", intro=" + intro
				+ ", color=" + color + ", edition=" + edition + ", quantity=" + quantity + "]";
	}
    
}