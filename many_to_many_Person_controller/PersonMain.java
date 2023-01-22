package com.ty.many_to_many_Person_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.ty.many_to_many_Person_dao.PersonDao;
import com.ty.many_to_many_Person_dto.Language;
import com.ty.many_to_many_Person_dto.Person;
import com.ty.many_to_many_school_dao.StudentDao;


public class PersonMain {

	public static void main(String[] args) {
		Language language = new Language();
		language.setId(200);
		language.setCountry("INDIA");
		language.setName("telugu");
		language.setOrigin("south");
		Language language2 =new Language();
		language2.setId(2001);
		language2.setName("HINDHI");
		language2.setCountry("INDIA");
		language2.setOrigin("north");
		Language language3 =new Language();
		language3.setId(1002);
		language3.setName("Tamil");
		language3.setCountry("INDIA");
		language3.setOrigin("south");
		
		Person person=new Person();
		person.setId(201);
		person.setName("prabha");
		person.setPhone(9898989);
		person.setAddress("hyd");
		
		Person person1=new Person();
		person1.setId(202);
		person1.setName("rayudu");
		person1.setPhone(888889);
		person1.setAddress("kerala");
		Person person2=new Person();
		person2.setId(203);
		person2.setName("srinu");
		person2.setPhone(8878889);
		person2.setAddress("vizag");
		List<Person> list=new ArrayList<Person>();
		list.add(person);
		list.add(person2);
		List<Language> list1=new ArrayList<Language>();
		list1.add(language);
		list1.add(language3);
		
	//	person.setList(list);
		//person1.setList(list);
		person2.setList(list1);
		PersonDao dao=new PersonDao();
		
		//dao.savePerson(list, list1);
		
//		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
//		EntityManager entityManager=entityManagerFactory.createEntityManager();
//		EntityTransaction entityTransaction=entityManager.getTransaction();
//		entityTransaction.begin();
//		entityManager.persist(person);
//		entityManager.persist(person1);
//		entityManager.persist(person2);
//		entityManager.persist(language);
//		entityManager.persist(language2);
//		entityManager.persist(language3);
	//	entityTransaction.commit();
	  

	}

}
