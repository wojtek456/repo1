package pl.straszewski;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.jpa.internal.metamodel.EmbeddableTypeImpl;

import domain.Employee;
import domain.Phone;



public class Main {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		List<Phone> phones = new ArrayList<Phone>();
		employee.setFirstName("Wojciech");
		employee.setLastName("Straszewski");
		employee.setSalary(12345);
		
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		phone1.setNumber("123456789");
		phone1.setType("home");
		phone2.setNumber("987654321");
		phone2.setType("work");
		//phone1.setEmployee(employee);
		//phone2.setEmployee(employee);
		phones.add(phone1);
		phones.add(phone2);
		employee.setPhones(phones);
		
		
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		entityManager.persist(employee);
		


		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		
		System.out.println("done");
	}
}
