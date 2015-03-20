package controllers;

import java.util.ArrayList;
import java.util.List;

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
	private static final int ID = 0;
	
	
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
		List<int[]> ids = new ArrayList();
		for(Voto voto: votos){
			int idTema = voto.getTema().getId();
			try{
				double[] votacion = votaciones.get(idTema);
				int[] datosAuxiliares = ids.get(idTema);
				votacion[NUMERO_VOTOS] = votacion[NUMERO_VOTOS] + 1;
				votacion[voto.getEstudios()] = (votacion[voto.getEstudios()] + voto.getPuntuacion());
				datosAuxiliares[voto.getEstudios()] = datosAuxiliares[voto.getEstudios()] + 1;
				votaciones.set(idTema, votacion);
				ids.set(idTema, datosAuxiliares);
			}
			catch (Exception e ){				
				int[] datosAuxiliares = new int[4];
				double[] votacion = new double[4];
				votacion[NUMERO_VOTOS] = 1;
				votacion[ESTUDIOS_BAJOS] = 0;
				votacion[ESTUDIOS_MEDIOS] = 0;
				votacion[ESTUDIOS_ALTOS] = 0;
				datosAuxiliares[ID]=idTema;
				datosAuxiliares[ESTUDIOS_BAJOS] = 0;
				datosAuxiliares[ESTUDIOS_MEDIOS] = 0;
				datosAuxiliares[ESTUDIOS_ALTOS] = 0;
				votacion[voto.getEstudios()] = voto.getPuntuacion();
				datosAuxiliares[voto.getEstudios()] = 1;
				votaciones.add(idTema, votacion);
				ids.add(idTema, datosAuxiliares);
			}
		}
		
		for(int[] id: ids){
				double[] votacion = votaciones.get(id[ID]);
				if (id[ESTUDIOS_BAJOS] != 0)
				votacion[ESTUDIOS_BAJOS] = votacion[ESTUDIOS_BAJOS] / id[ESTUDIOS_BAJOS];
				if (id[ESTUDIOS_MEDIOS] != 0)
				votacion[ESTUDIOS_MEDIOS] = votacion[ESTUDIOS_MEDIOS] / id[ESTUDIOS_MEDIOS];
				if (id[ESTUDIOS_ALTOS] != 0)
				votacion[ESTUDIOS_ALTOS] = votacion[ESTUDIOS_ALTOS] / id[ESTUDIOS_ALTOS];
				votaciones.set(id[ID], votacion);
		}
		return votaciones;
	}

}
