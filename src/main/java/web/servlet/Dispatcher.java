package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.jsf.VotarBean;
import views.beans.jsp.VotacionesBean;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String PATH_ROOT_VIEW = "/jspView/";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);
		
		String view;
		
		switch (action) {
			case "votaciones":
				VotacionesBean votacionesBean = new VotacionesBean(); 
				votacionesBean.update();
				request.setAttribute(action, votacionesBean);
				view = action;
				break;
			case "votar":
				int id = Integer.parseInt(request.getParameter("id"));
				VotarBean votarBean = new VotarBean();
				request.setAttribute(action, votarBean);
				view = action;
				break;
			default:
	            view = "home";
		} 
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
	}
	
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		String action = request.getPathInfo().substring(1);
        String view = "home";
        switch (action) {
	        case "votar":
	        	VotarBean votarBean = new VotarBean();
	        	
	        	break;
        
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
	}
}
