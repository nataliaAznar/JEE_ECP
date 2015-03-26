package views.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;

@ManagedBean
public abstract class ViewBean {
    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public ViewBean() {
	}

	public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
    	if(controllerFactory == null)
    		controllerFactory = new ControllerFactory();
        return controllerFactory;
    }

}
