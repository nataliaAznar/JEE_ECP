package persistence.models.daos.jpa;

import org.junit.Before;

import persistence.models.daos.TemaDao;

public class TemaDaoJpaTest {

	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	
	@Before
	public void init(){
		
	}
	
}
