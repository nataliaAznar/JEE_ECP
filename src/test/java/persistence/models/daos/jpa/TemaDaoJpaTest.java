package persistence.models.daos.jpa;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;

public class TemaDaoJpaTest {

	private TemaDao dao;
	private List<Tema> temas = new ArrayList<Tema>();
	
	@Before
	public void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
		dao = DaoJpaFactory.getFactory().getTemaDao();
		temas.add(new Tema("test", "test"));
		temas.add(new Tema("test1", "test1"));
		temas.add(new Tema("test2", "test2"));
	}
	
	@Test
	public void testCreate(){
		for( Tema tema : this.temas){
			dao.create(tema);
		}
		List<Tema> temas = dao.findAll();
        for (Tema tema : temas) {
            assertTrue(this.temas.contains(tema));
        }
        assertTrue(temas.size() == this.temas.size());
	}
	
}
