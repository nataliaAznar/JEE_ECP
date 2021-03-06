package web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import views.beans.AņadirTemaBean;
import views.beans.ElegirTemaBean;
import views.beans.AutenticarseBean;
import views.beans.EliminarTemaBean;
import views.beans.VotacionesBean;
import views.beans.VotarBean;


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
			case "elegirTema":
				ElegirTemaBean elegirTemaBean = new ElegirTemaBean();
				elegirTemaBean.update();
				request.setAttribute(action, elegirTemaBean);
				view = action;
				break;
			case "votar":
				VotarBean votarBean = new VotarBean();
				request.setAttribute(action, votarBean);
				votarBean.update();
				view = action;
				break;
			case "aņadirTema":
				AņadirTemaBean aņadirTemaBean= new AņadirTemaBean();
				request.setAttribute(action, aņadirTemaBean);
				view = action;
				break;
			case "autenticarse":
				AutenticarseBean autenticarseBean = new AutenticarseBean();
				request.setAttribute(action, autenticarseBean);
				view = action;
				break;
			case "eliminarTema":
				EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
				request.setAttribute(action, eliminarTemaBean);
				eliminarTemaBean.update();
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
        String id;
        int idTema;
        VotarBean votarBean = new VotarBean();
        switch (action) {
	        case "elegirTema":
	        	id = request.getParameter("idTema");
	        	idTema = Integer.valueOf(id);
				request.setAttribute("votar", votarBean);
				votarBean.update();
				votarBean.setIdTema(idTema);
				view = "votar";
	        	break;
	        case "votar":
	        	votarBean.update();
	        	id = request.getParameter("id");
	        	votarBean.setIdTema(Integer.valueOf(id));
	        	votarBean.setEstudio(request.getParameter("estudio"));
	        	String puntos = request.getParameter("puntos");
	        	votarBean.setPuntos(Integer.valueOf(puntos));
	        	votarBean.setIp(request.getRemoteAddr());
	        	votarBean.process();
	        	break;
	        case "aņadirTema":
	        	AņadirTemaBean aņadirTemaBean= new AņadirTemaBean();
	        	aņadirTemaBean.setNombre(request.getParameter("nombre"));
	        	aņadirTemaBean.setPregunta(request.getParameter("pregunta"));
	        	aņadirTemaBean.process();
	        	break;
	        case "autenticarse":
	        	AutenticarseBean autenticarseBean = new AutenticarseBean();
	        	autenticarseBean.setIdentificadorIntroducido(request.getParameter("identificadorIntroducido"));
	        	view = autenticarseBean.process();
	        	if( view.equals("autenticarse")){
	        		request.setAttribute(view, autenticarseBean);
	        	}
	        	else{
	        		EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
	        		request.setAttribute(view, eliminarTemaBean);
	        		eliminarTemaBean.update(); 
	        	}
	        	break;
	        case "eliminarTema":
	        	EliminarTemaBean eliminarTemaBean = new EliminarTemaBean();
	        	String idTemaEliminar = request.getParameter("idTema");
	        	eliminarTemaBean.setIdTema(Integer.valueOf(idTemaEliminar));
	        	eliminarTemaBean.process();
	        	break;
        }
        this.getServletContext().getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
        .forward(request, response);
	}
}
