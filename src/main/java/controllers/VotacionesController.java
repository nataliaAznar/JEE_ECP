package controllers;

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
	private static final int NUMERO_PARAMETROS_MOSTRADOS = 4;
	
	
	public VotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoJpaFactory.getFactory().getTemaDao();
		daoVoto = DaoJpaFactory.getFactory().getVotoDao();
	}

	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public double[] getVotacion(int id){
		List<Voto> votos = daoVoto.findAll();
		double[] votacion = inicializarVotacion();
		int[] datosAuxiliares = inicializarDatosAuxiliares(id);
		
		for(Voto voto: votos){
			int idTema = voto.getTema().getId();
			if(idTema == id){
				votacion[NUMERO_VOTOS] = votacion[NUMERO_VOTOS] + 1;
				votacion[voto.getEstudios()+1] = (votacion[voto.getEstudios()+1] + voto.getPuntuacion());
				datosAuxiliares[voto.getEstudios()+1] = datosAuxiliares[voto.getEstudios()+1] + 1;
			}
		}
		votacion = calcularMedias(votacion, datosAuxiliares);
		if(votacion.length == 0){
			double [] empty= {0,0,0,0};
			return empty;
		}
		else
			return votacion;
	}
	
	private double[] inicializarVotacion(){
		double[] votacion = new double[NUMERO_PARAMETROS_MOSTRADOS];
		votacion[NUMERO_VOTOS] = 0;
		votacion[ESTUDIOS_BAJOS] = 0;
		votacion[ESTUDIOS_MEDIOS] = 0;
		votacion[ESTUDIOS_ALTOS] = 0;
		return votacion;
	}
	
	private int[] inicializarDatosAuxiliares(int idTema){
		int[] datosAuxiliares = new int[NUMERO_PARAMETROS_MOSTRADOS];
		datosAuxiliares[ID]=idTema;
		datosAuxiliares[ESTUDIOS_BAJOS] = 0;
		datosAuxiliares[ESTUDIOS_MEDIOS] = 0;
		datosAuxiliares[ESTUDIOS_ALTOS] = 0;
		return datosAuxiliares;
	}
	
	private double[] calcularMedias(double[] votacion, int[]datosAuxiliares){
		if (datosAuxiliares[ESTUDIOS_BAJOS] != 0)
		votacion[ESTUDIOS_BAJOS] = votacion[ESTUDIOS_BAJOS] / datosAuxiliares[ESTUDIOS_BAJOS];
		if (datosAuxiliares[ESTUDIOS_MEDIOS] != 0)
		votacion[ESTUDIOS_MEDIOS] = votacion[ESTUDIOS_MEDIOS] / datosAuxiliares[ESTUDIOS_MEDIOS];
		if (datosAuxiliares[ESTUDIOS_ALTOS] != 0)
		votacion[ESTUDIOS_ALTOS] = votacion[ESTUDIOS_ALTOS] / datosAuxiliares[ESTUDIOS_ALTOS];
		return votacion;
	}

}
