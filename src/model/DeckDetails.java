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
@Table(name="deck_details")
public class DeckDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="deck_details_id")
	private int id;
	
	@Column(name="deck_name")
	private String deckName;
	
	@Column(name="deck_created")
	private LocalDate deckCreated;
	
	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="card_holder_id")
	private CardHolder holder;
	
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	@JoinTable
	 (
	 name="list_of_cards",
	 joinColumns={ @JoinColumn(name="deck_details_id", referencedColumnName="deck_details_id") },
	 inverseJoinColumns={ @JoinColumn(name="card_stats_id", referencedColumnName="card_stats_id", unique=true) }
	 )
	private List<MagicCards> listOfCards;
	
	public DeckDetails() {
		super();
	}
	
	public DeckDetails(int id, String deckName, LocalDate deckCreated, CardHolder holder, List<MagicCards> listOfCards) {
		super();
		this.id = id;
		this.listOfCards = listOfCards;
		this.deckName = deckName;
		this.deckCreated = deckCreated;
		this.holder = holder;
	}
	
	public DeckDetails(String deckName, LocalDate deckCreated, CardHolder holder, List<MagicCards> listOfCards) {
		super();
		this.listOfCards = listOfCards;
		this.deckName = deckName;
		this.deckCreated = deckCreated;
		this.holder = holder;
	}
	
	public DeckDetails(String deckName, LocalDate deckCreated, CardHolder holder) {
		super();
		this.deckName = deckName;
		this.deckCreated = deckCreated;
		this.holder = holder;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeckName() {
		return deckName;
	}

	public void setDeckName(String deckName) {
		this.deckName = deckName;
	}

	public LocalDate getDeckCreated() {
		return deckCreated;
	}

	public void setDeckCreated(LocalDate deckCreated) {
		this.deckCreated = deckCreated;
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

	@Override
	public String toString() {
		return "Deck Details [id=" + id + ", DeckName=" + deckName + ", Date Created=" + deckCreated + ", Holder=" + holder + ", listOfCards=" + listOfCards + "]";
	}
}
