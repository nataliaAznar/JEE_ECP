package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.jpa.Tema;
import persistence.jpa.Voto;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.VotoDao;

public class VotoDaoJpaTest {
	
	private VotoDao dao;
	private Voto voto;
	
	@BeforeClass
	public static void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
	}
	
	@Before
	public void before(){
		this.voto = new Voto( 3, 1, "127.0.0.1", new Tema("test", "test"));
		dao = DaoJpaFactory.getFactory().getVotoDao();
		dao.create(this.voto);
	}
	
	@Test
	public void testCreate(){
		Voto voto = new Voto(1, 7, 2, "127.0.0.1", new Tema("test", "test"));
		dao.create(voto);
		Voto voto1 = dao.read(1);
		assertEquals(voto, voto1);
	}
	
	@After
	public void after(){
		dao.deleteById(this.voto.getId());
	}

}
