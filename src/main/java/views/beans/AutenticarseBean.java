package views.beans;

import java.io.Serializable;

import controllers.EliminarTemaController;

public class AutenticarseBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static String identificador = "666";
	private EliminarTemaController eliminarTemaController = new EliminarTemaController();
	
	private String error = "";
	
	private String identificadorIntroducido;
	
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

	public String getIdentificadorIntroducido() {
		return identificadorIntroducido;
	}

	public void setIdentificadorIntroducido(String identificadorIntroducido) {
		this.identificadorIntroducido = identificadorIntroducido;
	}
	
	public String process(){
		if(this.identificadorIntroducido.equals(AutenticarseBean.identificador)){
			return "eliminarTema";
		}
		else{
			this.error = "Identificador inválido";
			return"autenticarse";
		}
	}

}
