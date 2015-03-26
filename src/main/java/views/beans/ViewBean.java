package views.beans;

import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import controllers.ControllerFactory;

@ManagedBean
public abstract class ViewBean {
	private Locale locale;

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public ViewBean() {
    	this.locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
    	if(controllerFactory == null)
    		controllerFactory = new ControllerFactory();
        return controllerFactory;
    }
    
    public String change(String language) {
        this.locale = new Locale(language);
        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
        return null;
    }

}
