package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;

public class TemaDaoJpaTest {

	private TemaDao dao;
	private Tema tema;
	
	@BeforeClass
	public static void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
	}
	@Before
	public void before(){
		this.tema = new Tema("test", "test");
		dao = DaoJpaFactory.getFactory().getTemaDao();
		dao.create(this.tema);
	}
	
	@Test
	public void testCreate(){
		List<Tema> temas = dao.findAll();
		assertEquals(temas.get(0), this.tema);
	}
	
	@Test
	public void testRead(){
		assertEquals(this.tema, dao.read(this.tema.getId()));
	}
	
	@Test
	public void testUpdate(){
		this.tema.setNombre("test2");
		this.tema.setPregunta("test2");
		dao.update(this.tema);
		assertEquals(this.tema, dao.read(this.tema.getId()));
	}
	
	@Test
	public void testDelete(){
		dao.deleteById(this.tema.getId());
		assertNull(dao.read(this.tema.getId()));
	}
	
	@Test
	public void testFindAll(){
		dao.create(new Tema(2,"test2", "test2"));
		assertEquals(2, dao.findAll().size());
		dao.deleteById(2);
	}
	
	@After
    public void after() {
        dao.deleteById(this.tema.getId());
    }
}
