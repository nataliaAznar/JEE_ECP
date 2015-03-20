package controllers;

import java.util.ArrayList;
import java.util.List;

import com.mysql.fabric.xmlrpc.base.Array;

import persistence.jpa.Tema;
import persistence.jpa.Voto;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class VotacionesController {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	private static final int NUMERO_VOTOS = 0;
	private static final int ESTUDIOS_BAJOS = 1;
	private static final int ESTUDIOS_MEDIOS= 2;
	private static final int ESTUDIOS_ALTOS = 3;
	
	
	public VotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoJpaFactory.getFactory().getTemaDao();
		daoVoto = DaoJpaFactory.getFactory().getVotoDao();
	}

	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public List<double[]> getVotaciones(){
		List<Voto> votos = daoVoto.findAll();
		List<double[]> votaciones = new ArrayList();
		for(Voto voto: votos){
			int idTema = voto.getTema().getId();
			try{
				double[] votacion = votaciones.get(idTema);
				votacion[NUMERO_VOTOS] = votacion[NUMERO_VOTOS]++;
				votacion[voto.getEstudios()] = (votacion[voto.getEstudios()] + voto.getPuntuacion()) /2;
				votaciones.set(idTema, votacion);
			}
			catch (Exception e ){
				double[] votacion = new double[4];
				votacion[NUMERO_VOTOS] = 1;
				votacion[ESTUDIOS_BAJOS] = 0;
				votacion[ESTUDIOS_MEDIOS] = 0;
				votacion[ESTUDIOS_ALTOS] = 0;
				votacion[voto.getEstudios()] = voto.getPuntuacion();
				votaciones.add(idTema, votacion);
			}
			
		}
		return votaciones;
	}

}
