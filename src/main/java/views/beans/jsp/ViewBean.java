package views.beans.jsp;

import javax.faces.bean.ManagedProperty;

import controllers.ControllerFactory;

public abstract class ViewBean {

    @ManagedProperty(value = "#{controllerFactory}")
    private ControllerFactory controllerFactory;

    public void setControllerFactory(ControllerFactory controllerFactory) {
        this.controllerFactory = controllerFactory;
    }

    protected ControllerFactory getControllerFactory() {
    	if(controllerFactory == null)
    		controllerFactory = new ControllerFactory();
        return controllerFactory;
    }

}
