package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.HolderDetails;

public class HolderDetailsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MagicCardsDetails");
	
	public void insertNewListDetails(HolderDetailsHelper hdh) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(hdh);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<HolderDetails> getLists() {
		EntityManager em = emfactory.createEntityManager();
		List<HolderDetails> allDetails = em.createQuery("SELECT d FROM holdershanddetails d").getResultList();
		return allDetails;
	}
}