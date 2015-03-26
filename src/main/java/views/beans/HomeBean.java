package views.beans;

import java.io.Serializable;
import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class HomeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private Locale locale;
	
	public HomeBean() {
		this.locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}



	public String change(String language) {
        this.locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }

}
