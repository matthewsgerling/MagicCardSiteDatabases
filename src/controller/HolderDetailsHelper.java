package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.HolderDetails;

public class HolderDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MagicCardDatabase");
	
	public void insertNewListDetails(HolderDetailsHelper hdh) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hdh);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<HolderDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<HolderDetails> allDetails = em.createQuery("SELECT i FROM HolderDetails i").getResultList();
		return allDetails;
	}
	
	public HolderDetails searchForListById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		HolderDetails found = em.find(HolderDetails.class, tempId);
		em.close();
		return found;
	}

	public void deleteItem(HolderDetails HandToDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<HolderDetails> typedQuery = em.createQuery("select d from HolderDetails d where d.id = :selectedid", HolderDetails.class);
		typedQuery.setParameter("selectedid", HandToDelete.getId());
		typedQuery.setMaxResults(1);
		HolderDetails result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	public void updateList(HolderDetails toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

}