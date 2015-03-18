package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.art83.web.design.viws.beans.persona.v0.PersonaBean;

@WebServlet("/jsp/Votar")
public class VotarServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PersonaBean personaBean = new PersonaBean();
        request.setAttribute("personaBeanV0", personaBean);

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
