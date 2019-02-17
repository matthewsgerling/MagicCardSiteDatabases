package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.MagicCards;

public class MagicCardHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MagicCards");
	
	public void insertItem(MagicCards mc) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(mc);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<MagicCards> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<MagicCards> allItems = em.createQuery("SELECT i FROM MagicCards i").getResultList();
		return allItems;
	}

	public void deleteItem(MagicCards toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MagicCards> typedQuery = em.createQuery(
				"select mc from MagicCards mc where mc.cardname = :selectedName and mc.cardtype = :selectedType",
				MagicCards.class);
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedType", toDelete.getType());
		typedQuery.setMaxResults(1);
		MagicCards result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public List<MagicCards> searchForItemByType(String findType) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MagicCards> typedQuery = em.createQuery("select mc from MagicCards mc where mc.cardtype = :selectedType", MagicCards.class);
		typedQuery.setParameter("selectedType", findType);

		List<MagicCards> foundType = typedQuery.getResultList();
		em.close();
		return foundType;
	}

	public List<MagicCards> searchForItemByName(String findName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<MagicCards> typedQuery = em.createQuery("select mc from MagicCards mc where mc.cardname = :selectedName", MagicCards.class);
		typedQuery.setParameter("selectedName", findName);

		List<MagicCards> foundName = typedQuery.getResultList();
		em.close();
		return foundName;
	}

	public MagicCards searchForItemByID(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		MagicCards found = em.find(MagicCards.class, idToEdit);
		em.close();
		return found;
	}
	
	public void updateItem(MagicCards toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}