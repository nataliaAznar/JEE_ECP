package persistence.models.daos.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import es.art83.persistence.models.entities.Category;
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
	 
	 private static final String SQL_CREATE_TABLE = "CREATE TABLE %s (%s INT NOT NULL, %s VARCHAR(255), "
	            + "%s VARCHAR(255), PRIMARY KEY (%s))";

	    public static String sqlToCreateTable() {
	        return String.format(SQL_CREATE_TABLE, Tema.TABLE, Tema.ID, Tema.PREGUNTA,
	                Tema.NOMBRE, Tema.ID);
	    }

	    private static final String SQL_INSERT = "INSERT INTO %s (%s,%s,%s) VALUES (%d,'%s','%s')";

	
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
