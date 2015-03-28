package views.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import controllers.EliminarTemaController;
import persistence.jpa.Tema;

@ManagedBean
@ViewScoped
public class EliminarTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private static String identificador = "666";
	private EliminarTemaController eliminarTemaController = this.getControllerFactory().getEliminarTemaController();
	
	private String errorText = "";
	private boolean showError = false;
	private String identificadorIntroducido;
	
	private List<Tema> temas;
	private int idTema;
	
	private boolean disabledTema = true;
	private boolean disabledDelete = true;
	
	public EliminarTemaBean() {
		super();
	}

	public String getErrorText() {
		return errorText;
	}

	public boolean isShowError() {
		return showError;
	}

	public String getIdentificadorIntroducido() {
		return identificadorIntroducido;
	}

	public void setIdentificadorIntroducido(String identificadorIntroducido) {
		this.identificadorIntroducido = identificadorIntroducido;
		if (!identificador.equals(identificadorIntroducido)){
			this.errorText = "Identificador inválido";
			disabledTema = true;
			disabledDelete = true;
		}else{
			this.errorText ="";
			disabledTema = false;
		}
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
		disabledDelete = idTema == -1;
	}

	public boolean isDisabledTema() {
		return disabledTema;
	}

	public boolean isDisabledDelete() {
		return disabledDelete;
	}

	@PostConstruct
    public void update() {
		this.temas = eliminarTemaController.getTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
        this.idTema = -1;
    }
	
	public String process(){
		eliminarTemaController.deleteTema(this.idTema);
		return "home";
	}
	
}
