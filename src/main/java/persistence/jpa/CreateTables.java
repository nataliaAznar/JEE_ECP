package persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;


public class CreateTables {
	 public static void main(String[] args) {
	        //Se borrar y se crean las tabla        
		 JpaFactory.dropAndCreateTables();
		 EntityManagerFactory em = JpaFactory.getEntityManagerFactory();
		 em.createEntityManager();
	    }
}
