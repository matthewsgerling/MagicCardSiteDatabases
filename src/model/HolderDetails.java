package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="holdershanddetails")
public class HolderDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="handid")
	private int id;
	@Column(name="handname")
	private String handName;
	@Column(name="handcreated")
	private LocalDate handCreated;
	@ManyToOne
	private CardHolder holder;
	@OneToMany(cascade=CascadeType.PERSIST, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="holdershanddetails",
	 joinColumns={ @JoinColumn(name="handid",
	referencedColumnName="handid") },
	 inverseJoinColumns={ @JoinColumn(name="handid",
	referencedColumnName="ID", unique=true) }
	 )
	private List<MagicCards> listOfCards;
	
	public HolderDetails() {
		
	}
	
	public HolderDetails(int id, String handName, LocalDate handCreated, CardHolder holder, List<MagicCards> listOfCards) {
	
	}
	
	public HolderDetails(String handName, LocalDate handCreated, CardHolder holder, List<MagicCards> listOfCards) {
				
	}
	
	public HolderDetails(String handName, LocalDate handCreated, CardHolder holder) {
				
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHandName() {
		return handName;
	}

	public void setHandName(String handName) {
		this.handName = handName;
	}

	public LocalDate getHandCreated() {
		return handCreated;
	}

	public void setHandCreated(LocalDate handCreated) {
		this.handCreated = handCreated;
	}

	public CardHolder getHolder() {
		return holder;
	}

	public void setHolder(CardHolder holder) {
		this.holder = holder;
	}

	public List<MagicCards> getListOfCards() {
		return listOfCards;
	}

	public void setListOfCards(List<MagicCards> listOfCards) {
		this.listOfCards = listOfCards;
	}

	
}
