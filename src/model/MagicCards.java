package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cardstats")
public class MagicCards {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	public int id;
	
	@Column(name="cardname")
	public String cardname;
	
	@Column(name="cardtype")
	public String cardtype;
	
	@Column(name="manacost")
	public int manaCost;
	
	public MagicCards() {
		super();
	}
	
	public MagicCards(String name, String type, int manacost) {
		super();
		this.cardname = name;
		this.cardtype = type;
		this.manaCost = manacost;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return cardname;
	}
	public void setName(String name) {
		this.cardname = name;
	}
	public String getType() {
		return cardtype;
	}
	public void setType(String type) {
		this.cardtype = type;
	}
	public int getManaCost() {
		return manaCost;
	}
	public void setManaCost(int manaCost) {
		this.manaCost = manaCost;
	}
	
	
	
	public String returnCardDetails() {
		return cardname + ": " + cardtype + ": " + manaCost;
	}

}
