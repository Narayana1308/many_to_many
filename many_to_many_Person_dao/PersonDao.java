package com.ty.many_to_many_Person_dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_many_Person_dto.Language;
import com.ty.many_to_many_Person_dto.Person;

public class PersonDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vinod");
		return entityManagerFactory.createEntityManager();
	}
	public void savePerson(List<Person> list) {
		EntityManager entityManager=getEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		for(Person person:list) {
			entityTransaction.begin();
			entityManager.persist(person);
			entityTransaction.commit();
			
		}
		
	}
	public void updatePerson(Person person) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person p2=entityManager.find(Person.class, person.getId());
		p2.setName(person.getName());
		entityTransaction.begin();
		entityManager.merge(p2);
		entityTransaction.commit();
	}
	
	public void deletePerson(int p_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Person p2=entityManager.find(Person.class, p_id);
		entityTransaction.begin();
		entityManager.remove(p2);
		entityTransaction.commit();
	}
	
	public void getPersonById(int p_id) {
		EntityManager entityManager = getEntityManager();
	
		Person p2=entityManager.find(Person.class, p_id);
		System.out.println(p2);
	}
	public void getAllPersonDetails() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select com from Person com");
		List<Person> list=query.getResultList();
		System.out.println(list);
	}

}
