package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.DeckDetails;

public class DeckDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MagicCardDatabase");
	
	public void insertNewDeckDetails(DeckDetails dd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(dd);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<DeckDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<DeckDetails> allDetails = em.createQuery("SELECT i FROM DeckDetails i").getResultList();
		return allDetails;
	}
	
	public DeckDetails searchForListById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		DeckDetails found = em.find(DeckDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(DeckDetails DeckToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<DeckDetails> typedQuery = em.createQuery("select d from DeckDetails d where d.id = :selectedid", DeckDetails.class);
		typedQuery.setParameter("selectedid", DeckToDelete.getId());
		typedQuery.setMaxResults(1);
		DeckDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public void updateList(DeckDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}