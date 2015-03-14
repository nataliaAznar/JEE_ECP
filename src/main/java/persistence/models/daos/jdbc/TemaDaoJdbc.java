package persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import persistence.jpa.Tema;
import persistence.models.daos.TemaDao;

public class TemaDaoJdbc extends GenericDaoJdbc<Tema,Integer>implements TemaDao {
	private Logger log = LogManager.getLogger(TemaDaoJdbc.class);
	
	 private Tema create(ResultSet resultSet) {
	        try {
	            if (resultSet != null && resultSet.next()) {
	                return new Tema(resultSet.getInt(Tema.ID),
	                        resultSet.getString(Tema.NOMBRE),
	                        resultSet.getString(Tema.PREGUNTA));
	            }
	        } catch (SQLException e) {
	            log.error("read: " + e.getMessage());
	        }
	        return null;
	    }
	
	
	@Override
	public void create(Tema entity) {
		try{
			
		}
		catch(SQLException e) {
			log.error("read: " + e.getMessage());
		}
		
	}

	@Override
	public Tema read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Tema entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Tema> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
