package jpa;

import javax.persistence.*;


public class TestJpa {
	
	 public static void main(String[] args)
	  {
		 EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		 EntityManager em = entityManagerFactory.createEntityManager();
		 em.close();
		 entityManagerFactory.close();
	  }  
}
