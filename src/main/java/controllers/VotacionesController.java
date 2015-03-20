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
	private static final int ESTUDIOS_BAJOS_CONT = 4;
	private static final int ESTUDIOS_MEDIOS_CONT = 5;
	private static final int ESTUDIOS_ALTOS_CONT = 6;
	private static final int NUM_ESTUDIOS = 3;
	
	
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
		List<Integer> ids = new ArrayList();
		for(Voto voto: votos){
			int idTema = voto.getTema().getId();
			if ( !ids.contains(idTema))
				ids.add(idTema);
			
			try{
				double[] votacion = votaciones.get(idTema);
				votacion[NUMERO_VOTOS] = votacion[NUMERO_VOTOS] + 1;
				votacion[voto.getEstudios()] = (votacion[voto.getEstudios()] + voto.getPuntuacion());
				votacion[voto.getEstudios() + NUM_ESTUDIOS] = votacion[voto.getEstudios() + NUM_ESTUDIOS] + 1;
				votaciones.set(idTema, votacion);
			}
			catch (Exception e ){
				double[] votacion = new double[7];
				votacion[NUMERO_VOTOS] = 1;
				votacion[ESTUDIOS_BAJOS] = 0;
				votacion[ESTUDIOS_MEDIOS] = 0;
				votacion[ESTUDIOS_ALTOS] = 0;
				votacion[ESTUDIOS_BAJOS_CONT] = 0;
				votacion[ESTUDIOS_MEDIOS_CONT] = 0;
				votacion[ESTUDIOS_ALTOS_CONT] = 0;
				votacion[voto.getEstudios()] = voto.getPuntuacion();
				votacion[voto.getEstudios() + NUM_ESTUDIOS] = 1;
				votaciones.add(idTema, votacion);
			}
			
		}
		
		for(Integer id: ids){
			try{
				double[] votacion = votaciones.get(id);
				if (votacion[ESTUDIOS_BAJOS_CONT] != 0)
				votacion[ESTUDIOS_BAJOS] = votacion[ESTUDIOS_BAJOS] / votacion[ESTUDIOS_BAJOS_CONT];
				if (votacion[ESTUDIOS_MEDIOS_CONT] != 0)
				votacion[ESTUDIOS_MEDIOS] = votacion[ESTUDIOS_MEDIOS] / votacion[ESTUDIOS_MEDIOS_CONT];
				if (votacion[ESTUDIOS_ALTOS_CONT] != 0)
				votacion[ESTUDIOS_ALTOS] = votacion[ESTUDIOS_ALTOS] / votacion[ESTUDIOS_ALTOS_CONT];
				votaciones.add(id, votacion);
			}
			catch(Exception e){
				
			}
		}
		return votaciones;
	}

}
