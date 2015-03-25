package views.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import persistence.jpa.Tema;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static int identificador = 666;
	
	private String errorText = "";
	private boolean showError = false;
	private int identificadorIntroducido;
	
	private List<Tema> temas;
	private int idTema;
	
	private boolean disabledTema;
	private boolean disableDelete;
	
	public EliminarTemaBean() {
	}

	public String getErrorText() {
		return errorText;
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
		if (!checkIdentificador())
			this.errorText = "Identificador inválido";
		else
			this.errorText ="";
	}
	
	public boolean checkIdentificador(){
		return (identificador == identificadorIntroducido);
	}
	
	public String process(){
		return "home";	
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public boolean isDisabledTema() {
		return disabledTema;
	}

	public void setDisabledTema(boolean disabledTema) {
		this.disabledTema = disabledTema;
	}

	public boolean isDisableDelete() {
		return disableDelete;
	}

	public void setDisableDelete(boolean disableDelete) {
		this.disableDelete = disableDelete;
	}

	
}
