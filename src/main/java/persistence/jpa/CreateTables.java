package persistence.jpa;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.eclipse.persistence.config.PersistenceUnitProperties;


public class CreateTables {
	 public static void main(String[] args) {
	        //Se borrar y se crean las tablas
	        Map<String, String> properties = new HashMap<>();
	        properties.put(PersistenceUnitProperties.DDL_GENERATION,
	                PersistenceUnitProperties.DROP_AND_CREATE);
	        EntityManager em = Persistence.createEntityManagerFactory("miwjee", properties)
	                .createEntityManager();
	    }
}
