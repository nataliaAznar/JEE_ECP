package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persistence.jpa.Tema;
import persistence.jpa.Voto;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;

public class VotoDaoJpaTest {
	
	private VotoDao dao;
	private TemaDao daoTema;
	private Voto voto;
	private Tema tema;
	
	@BeforeClass
	public static void beforeClass(){
		DaoFactory.setFactory(new DaoJpaFactory());
	}
	
	@Before
	public void before(){
		this.tema = new Tema("test", "test");
		this.voto = new Voto( 3, 1, "127.0.0.1", this.tema);
		dao = DaoJpaFactory.getFactory().getVotoDao();
		daoTema = DaoJpaFactory.getFactory().getTemaDao();
		daoTema.create(this.tema);
		dao.create(this.voto);
	}
	
	@Test
	public void testCreate(){
		Tema tema1 = new Tema("test2", "test2");
		daoTema.create(tema1);
		Voto voto1 = new Voto(1, 7, 2, "127.0.0.1", tema1);
		dao.create(voto1);
		Voto voto2 = dao.read(voto1.getId());
		assertEquals(voto1, voto2);
		dao.deleteById(voto1.getId());
		daoTema.deleteById(tema1.getId());
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
	
	@Test
	public void testDelete(){
		dao.deleteById(this.voto.getId());
		assertNull(dao.read(this.voto.getId()));
	}
	
	@Test
	public void testFindAll(){
		Voto v = new Voto( 6, 1, "127.0.0.1", this.tema);
		dao.create(v);
		assertEquals(2, dao.findAll().size());
		dao.deleteById(v.getId());
	}
	
	@After
	public void after(){
		dao.deleteById(this.voto.getId());
		daoTema.deleteById(this.voto.getTema().getId());
	}

}
