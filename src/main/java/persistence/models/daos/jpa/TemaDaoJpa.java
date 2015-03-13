package persistence.models.daos.jpa;

import persistence.jpa.Tema;
import persistence.models.daos.TemaDao;


public class TemaDaoJpa extends GenericDaoJpa<Tema, Integer> implements TemaDao {

	public TemaDaoJpa() {
		super(Tema.class);
	}
	 
}
