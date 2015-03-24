package views.beans.jsf;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import controllers.VotarController;
import persistence.jpa.Tema;
import utils.Estudios;
import views.beans.jsp.ViewBean;

@ManagedBean
@ViewScoped
public class VotarBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	VotarController votarController = this.getControllerFactory().getVotarController();
	
	private List<Tema> temas;
	private int idTema;
	
	private Estudios[] estudios = {Estudios.ESO, Estudios.BACHILLER, Estudios.UNIVERSITARIO};
	private int[] puntuacion = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	private int length = estudios.length;
	
	private String pregunta;
	private String estudio;
	private int puntos;
	private String ip;
	
	private boolean disabledVote;

	
	public VotarBean() {
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}
	
	public String getEstudio() {
		return this.estudio;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}

	public String[] getEstudios() {
		String[] estudiosString = new String[this.length];
		for( int i = 0; i < this.length; i++){
			estudiosString[i] = estudios.toString();
		}
		return estudiosString;
	}

	public int[] getPuntuacion() {
		return puntuacion;
	}

	public int getLength() {
		return length;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}
	
	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
		this.updateVote();
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}

	public boolean isDisabledVote() {
		return disabledVote;
	}

	@PostConstruct
    public void update() {
		this.temas = votarController.getTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
        this.idTema = -1;
        this.updateVote();
    }

	private void updateVote() {
        pregunta = temas.get((idTema+1)).getPregunta();
        puntos = puntuacion[0];
        disabledVote = idTema == -1;
    }
	
	public void process(){
		HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		this.ip = req.getHeader("X-FORWARDED-FOR");
		if( this.ip == null ) {
		    this.ip = req.getRemoteAddr();
		}
		String[] estudiosString = this.getEstudios();
		int nivelEstudios = -1;
		for(int i = 0; i < this.length; i++){
			if( estudiosString[i].equals(this.estudio))
				nivelEstudios = i;
		}
		this.votarController.addVoto(idTema, nivelEstudios, puntos, ip);
	}

}
