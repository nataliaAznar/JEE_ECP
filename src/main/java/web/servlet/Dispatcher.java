package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.VotacionesBean;
import views.beans.VotarBean;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	private static String PATH_ROOT_VIEW = "/JEE_ECP/jspView/";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);
		
		String view;
		
		switch (action) {
		case "votaciones":
			VotacionesBean votacionesBean = new VotacionesBean();  
			request.setAttribute(action, votacionesBean);
			view = action;
			break;
		default:
            view = "home";
		}
		this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
	}
}
