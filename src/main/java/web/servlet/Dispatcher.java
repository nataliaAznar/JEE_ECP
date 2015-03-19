package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.VotarBean;


@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String action = request.getPathInfo().substring(1);
		
		String view;
		
		switch (action) {
		case "votaciones":
			
			break;
		}

        VotarBean votarBean = new VotarBean();
        request.setAttribute("votarBeanV0", votarBean);

        String nombre = request.getParameter("nombre");
        if (nombre != null) {
            personaBean.setNombre(nombre);
        }

        String[] roles = request.getParameterValues("roles");
        if (roles != null) {
            personaBean.setRoles(roles);
        }

        personaBean.process();

        this.getServletContext().getRequestDispatcher("/personaViewsV0/" + "personaJSP" + ".jsp")
                .forward(request, response);
    }

}
