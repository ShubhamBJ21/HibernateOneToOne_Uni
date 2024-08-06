package OneToOne_Uni.dao;

import OneToOne_Uni.dto.AdharCard; 
import OneToOne_Uni.dto.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class PersonDao {

	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("shubham");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}
	
	public void savePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		AdharCard adharCard = person.getAdharCard();
		
		entityManager.persist(adharCard);
		entityManager.persist(person);
		entityTransaction.commit();
		System.out.println("Person details inserted in database");
	}
	
	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		entityTransaction.begin();
		AdharCard adharcard = person.getAdharCard();
		entityManager.merge(adharcard);
		entityManager.merge(person);
		entityTransaction.commit();
	}
	
	public void removePerson(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		Person person = entityManager.find(Person.class, id);
		AdharCard adharCard = person.getAdharCard();
		
		if(adharCard!=null) {
			entityTransaction.begin();
			entityManager.remove(adharCard);
			entityManager.remove(person);
			entityTransaction.commit();
		}
	}
	
	public List<Person> getAllPerson(){
		EntityManager entityManager = getEntityManager();
		Query query = entityManager.createQuery("Select p from Person p");
		List<Person> list = query.getResultList();
		return list;
	}
	
	public Person findPerson(int id) {
		EntityManager entityManager = getEntityManager();
		return entityManager.find(Person.class, id);
	}
}
