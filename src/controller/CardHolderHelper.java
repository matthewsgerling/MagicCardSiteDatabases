package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.CardHolder;


public class CardHolderHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MagicCardDatabase");
	
	public void insertHolder(CardHolder h) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(h);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<CardHolder> showAllHolders() {
		EntityManager em = emfactory.createEntityManager();
		List<CardHolder> allHolders = em.createQuery("SELECT i FROM CardHolder i").getResultList();
		return allHolders;
	}
	
	public CardHolder searchForHolderByName(String HolderName) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<CardHolder> typedQuery = em.createQuery("select s from CardHolder s where s.holderName = :selectedName", CardHolder.class);
		typedQuery.setParameter("selectedName", HolderName);
		typedQuery.setMaxResults(1);
		CardHolder found = typedQuery.getSingleResult();
		em.close();
		return found;
	}
}