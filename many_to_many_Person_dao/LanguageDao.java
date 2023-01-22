package com.ty.many_to_many_Person_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.many_to_many_Person_dto.Language;
import com.ty.many_to_many_Person_dto.Person;


public class LanguageDao {
	public EntityManager getEntityManager() {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vinod");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		return entityManager;
	}

	public void saveLanguage(Language language ,int p_id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
        Person person=entityManager.find(Person.class, p_id);
       
        if(person!=null) {
        	
        	List<Language> list=person.getList();
        	list.add(language);
        	person.setList(list);
        	entityTransaction.begin();
            //entityManager.merge(person);
            entityManager.persist(language);
            
		
		entityTransaction.commit();
        }

	}

	public void updateLanguage(Language lang) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Language p2 = entityManager.find(Language.class, lang.getId());
		p2.setName(lang.getName());
		entityTransaction.begin();
		entityManager.merge(p2);
		entityTransaction.commit();
	}
	
	
	public void removeLanguage(int id) {
		EntityManager entityManager = getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		Language p2=entityManager.find(Language.class, id);
		entityTransaction.begin();
		
		entityManager.remove(p2);
		entityTransaction.commit();
	}
	public void get_Language_DetailsOn_id(int l_id){
		EntityManager entityManager=getEntityManager();
		Language language=entityManager.find(Language.class,l_id);
		System.out.println(language);
	}
	public void getAll_LanguageDetails() {
		EntityManager entityManager=getEntityManager();
		Query query=entityManager.createQuery("Select com from Language com");
		List<Language> list=query.getResultList();
		System.out.println(list);
	}
}