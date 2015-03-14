package persistence.models.daos.jpa;

import static org.junit.Assert.assertEquals;

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
		this.voto = new Voto( 3, 1, "127.0.0.1", this.tema);
		this.tema = new Tema("test", "test");
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
	}
	
	@Test
	public void testRead(){
		Voto v = dao.read(this.voto.getId());
		System.out.println(v);
		System.out.println(v.getId());
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
