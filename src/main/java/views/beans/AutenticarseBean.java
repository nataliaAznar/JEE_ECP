package views.beans;

import java.io.Serializable;
import java.util.List;

import persistence.jpa.Tema;
import controllers.EliminarTemaController;

public class AutenticarseBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int identificador = 666;
	private EliminarTemaController eliminarTemaController = new EliminarTemaController();
	
	private String error = "";
	
	private int identificadorIntroducido;
	
	public AutenticarseBean() {
		super();
	}

	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController;
	}

	public void setEliminarTemaController(
			EliminarTemaController eliminarTemaController) {
		this.eliminarTemaController = eliminarTemaController;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getIdentificadorIntroducido() {
		return identificadorIntroducido;
	}

	public void setIdentificadorIntroducido(int identificadorIntroducido) {
		this.identificadorIntroducido = identificadorIntroducido;
	}
	
	public String process(){
		if(this.identificadorIntroducido == this.identificador){
			return "eliminarTema";
		}
		else{
			this.error = "Identificador inválido";
			return"autenticarse";
		}
	}

}
