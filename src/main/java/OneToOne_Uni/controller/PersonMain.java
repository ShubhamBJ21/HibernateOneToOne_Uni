package OneToOne_Uni.controller;

import java.util.List;

import OneToOne_Uni.dao.PersonDao;
import OneToOne_Uni.dto.AdharCard;
import OneToOne_Uni.dto.Person;

public class PersonMain {

	public static void main(String[] args) {
		AdharCard aadharCard = new AdharCard();
		aadharCard.setId(103);
		aadharCard.setName("Dimple");
		aadharCard.setAddress("Banglore");

		Person person = new Person();
		person.setId(3);
		person.setName("Dimple.S");
		person.setPhone(9546566612l);
		person.setAddress("India");
		person.setAdharCard(aadharCard);
		
		PersonDao personDao = new PersonDao();
		
		// personDao.savePerson(person);
		Person p1 = personDao.findPerson(1);
		System.out.println(p1);
		
		//display all person 
		List<Person> list = personDao.getAllPerson();
		for(Person single : list) {
			System.out.println(single);
		}
		
		System.out.println("----------- Person details Before ---------------");
		System.out.println(person);
		
		System.out.println("----------- Person details After  ----------------");
		person.setAddress("UK");
		personDao.updatePerson(person);
		System.out.println(person);
		
		personDao.removePerson(3);     //when you remove person 3 it's also remove its adharcard details
	}
}
