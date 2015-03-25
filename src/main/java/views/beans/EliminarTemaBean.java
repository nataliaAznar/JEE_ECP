package views.beans;

import java.io.Serializable;

public class EliminarTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int identificador = 666;
	
	private String error = "Identificador inválido";
	private boolean showError = false;
	private int identificadorIntroducido;
	
	public EliminarTemaBean() {
	}

	public String getError() {
		return error;
	}

	public boolean isShowError() {
		return showError;
	}

	public void setShowError(boolean showError) {
		this.showError = showError;
	}

	public int getIdentificadorIntroducido() {
		return identificadorIntroducido;
	}

	public void setIdentificadorIntroducido(int identificadorIntroducido) {
		this.identificadorIntroducido = identificadorIntroducido;
	}
	
	

}
