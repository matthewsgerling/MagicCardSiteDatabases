package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cardholder")
public class CardHolder {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="holderid")
	private int id;

	@Column(name="holdername")
	
	private String holderName;
	
	public CardHolder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CardHolder(int id, String shopperName) {
		super();
		this.id = id;
		this.holderName = shopperName;
	}
	
	public CardHolder(String shopperName) {
		super();
		this.holderName = shopperName;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getShopperName() {
		return holderName;
	}
	
	public void setShopperName(String shopperName) {
		this.holderName = shopperName;
	}
	
	@Override
	public String toString() {
		return "Holder [id=" + id + ", holderName=" + holderName + "]";
	}
}