package persistence.models.daos.jpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import persistence.jpa.Tema;
import persistence.models.daos.TemaDao;

public class TemaDaoJpaTest {

	private TemaDao dao = DaoJpaFactory.getFactory().getTemaDao();
	private List<Tema> temas = new ArrayList();
	
	@Before
	public void init(){
		Tema t = new Tema();
	}
	
	@Test
	public void testCreate(){
		
		
	}
	
}
