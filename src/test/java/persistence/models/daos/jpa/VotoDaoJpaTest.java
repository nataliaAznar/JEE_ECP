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
	private Tema tema = new Tema("test", "test");
	
	@BeforeClass
	public static void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
	}
	
	@Before
	public void before(){
		this.voto = new Voto( 3, 1, "127.0.0.1", this.tema);
		dao = DaoJpaFactory.getFactory().getVotoDao();
		dao.create(this.voto);
	}
	
	@Test
	public void testCreate(){
		Voto voto1 = new Voto(1, 7, 2, "127.0.0.1", new Tema("test2", "test2"));
		dao.create(voto1);
		Voto voto2 = dao.read(voto1.getId());
		assertEquals(voto1, voto2);
	}
	
	@Test
	public void testRead(){
		assertEquals(this.voto, dao.read(this.voto.getId()));
	}
	
	@Test
	public void testUpdate(){
		this.voto.setEstudios(3);
		this.voto.setPuntuacion(8);
		dao.update(this.voto);
		assertEquals(this.voto, dao.read(this.voto.getId()));
	}
	
	@After
	public void after(){
//		dao.deleteById(this.voto.getId());
	}

}
