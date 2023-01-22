package com.ty.many_to_many_Person_controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.criteria.CriteriaBuilder.Case;

import org.hibernate.boot.jaxb.hbm.spi.JaxbHbmNativeQueryJoinReturnType;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import com.ty.many_to_many_Person_dao.LanguageDao;
import com.ty.many_to_many_Person_dao.PersonDao;
import com.ty.many_to_many_Person_dto.Language;
import com.ty.many_to_many_Person_dto.Person;

public class PersonController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean flag = true;
		PersonDao dao = new PersonDao();
		LanguageDao languageDao = new LanguageDao();
		Person person1 = new Person();
		Person person2 = new Person();
		Language language1 = new Language();
		do {
			System.out.println("enter to \n1 save \n2 update \n3 delete \n4 details on id \n5 all details\n6 exit");
			int key = scanner.nextInt();
			switch (key) {
			case 1: {
				System.out.println("Enter the choice \n1 person \n2 language");
				int key1 = scanner.nextInt();
				switch (key1) {
				case 1: {
					
					System.out.println("Enter the person details");
					System.out.println("Enter person id");
					int p_id = scanner.nextInt();
					System.out.println("Enter person name");
					String p_name = scanner.next();
					System.out.println("Enter the Address");
					String address = scanner.next();
					System.out.println("enter the phone");
					long phone = scanner.nextLong();
					person1.setId(p_id);
					person1.setName(p_name);
					person1.setPhone(phone);
					person1.setAddress(address);
					System.out.println("Enter the person details");
					System.out.println("Enter person id");
					int p_id1 = scanner.nextInt();
					System.out.println("Enter person name");
					String p_name1 = scanner.next();
					System.out.println("Enter the Address");
					String address1 = scanner.next();
					System.out.println("enter the phone");
					long phone1 = scanner.nextLong();
					person2.setId(p_id1);
					person2.setName(p_name1);
					person2.setPhone(phone1);
					person2.setAddress(address1);
					List<Person> list = new ArrayList<Person>();
					list.add(person1);
					list.add(person2);
					dao.savePerson(list);

				}
					break;
				case 2: {
					System.out.println("Enter the person id ");
					int p_id = scanner.nextInt();

					System.out.println("Enter language details");
					System.out.println("Enter the language id");
					int l_id = scanner.nextInt();
					System.out.println("Enter language name");
					String l_name = scanner.next();
					System.out.println("Enetr country name");
					String c_name = scanner.next();
					System.out.println("Enter origin");
					String originString = scanner.next();
				
					language1.setId(l_id);
					language1.setName(l_name);
					language1.setCountry(c_name);
					language1.setOrigin(originString);
				
					languageDao.saveLanguage(language1, p_id);

				}
				default:
					break;
				}

			}
				break;
			case 2: {
				System.out.println("enter to update\n1 person\n2 language");
				int key2 = scanner.nextInt();
				switch (key2) {
				case 1: {
					System.out.println("enter person id");
					int p_id=scanner.nextInt();
					person1.setId(p_id);
					System.out.println("enter person name");
					String name=scanner.next();
					person1.setName(name);
					dao.updatePerson(person1);

				}
					break;
				case 2: {
                 System.out.println("enter language id");
                 int l_id=scanner.nextInt();
                 System.out.println("ENter the language name to be update");
                 String l_nameString=scanner.next();
                 language1.setId(l_id);
                 language1.setName(l_nameString);
                 languageDao.updateLanguage(language1);
                 
				}
					break;
				default:
					break;
				}
			}
				break;
			case 3: {
				System.out.println("enter to delete\n1 person\n2 language");
				int key2 = scanner.nextInt();
				switch (key2) {
				case 1: {
					System.out.println("enter person id");
					int p_id=scanner.nextInt();
					dao.deletePerson(p_id);

				}
					break;
				case 2: {
					System.out.println("enter language id");
					int id=scanner.nextInt();
					languageDao.removeLanguage(id);

				}
					break;
				default:
					break;
				}
			}
				break;
			case 4: {
				System.out.println("enter to get details on id\n1 person\n2 language");
				int key2 = scanner.nextInt();
				switch (key2) {
				case 1: {
					System.out.println("Enter the person id");
					int p_id=scanner.nextInt();
					dao.getPersonById(p_id);

				}
					break;
				case 2: {
					System.out.println("enter language id");
					int l_id=scanner.nextInt();
					languageDao.get_Language_DetailsOn_id(l_id);

				}
					break;
				default:
					break;
				}
			}
				break;
			case 5: {
				System.out.println("enter to get all details\n1 person\n2 language");
				int key2 = scanner.nextInt();
				switch (key2) {
				case 1: {
                   dao.getAllPersonDetails();
				}
					break;
				case 2: {
                    languageDao.getAll_LanguageDetails();
				}
					break;
				default:
					break;
				}
			}
				break;
			case 6: {
				flag = false;
			}
				break;
			default: {
				System.out.println("invalid choice");
			}
			}

		} while (flag);
		System.out.println("thank you");
	}

}