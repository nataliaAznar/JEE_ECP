package persistence.jpa;

import javax.persistence.EntityManagerFactory;


public class CreateTables {
	 public static void main(String[] args) {
	        //Se borrar y se crean las tabla        
		 JpaFactory.dropAndCreateTables();
		 EntityManagerFactory em = JpaFactory.getEntityManagerFactory();
		 em.createEntityManager();
	    }
}
