package br.com.events.servlets;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.dbcp.pool2.UsageTracking;

import br.com.events.dao.EventoDao;
import br.com.events.dao.EventoDaoJpa;
import br.com.events.dao.UsuarioDao;
import br.com.events.dao.UsuarioDaoJpa;
import br.com.events.model.Evento;
import br.com.events.model.Usuario;

/**
 * Servlet implementation class logarUsuario
 */
@WebServlet("/logarUsuario")
public class logarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public logarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String login = request.getParameter("login");
		
		String senha = request.getParameter("senha");
		
		
		UsuarioDao udao = new UsuarioDaoJpa();
		
		EventoDao edao = new EventoDaoJpa();
		
		Usuario usuario = udao.logar(login,senha);
			
		if(usuario.getId() != null){
			
			request.setAttribute("id", usuario.getId());
			request.setAttribute("login", usuario.getLogin());
			request.setAttribute("senha", usuario.getSenha());
			request.setAttribute("email", usuario.getEmail());
			request.setAttribute("dtnascimento", usuario.getDtNascimento());
			
			List<Evento> eventos = new ArrayList<Evento>();
			
			
			
			for (Evento e : edao.listarEvento()) {
				
				
				if(e.getUsuario().getId() == usuario.getId()){
					
					eventos.add(e);
				}
				
			} 
			
			request.setAttribute("eventos", eventos);
			
			RequestDispatcher rd = request.getRequestDispatcher("login.xhtml");
			rd.forward(request, response);
			
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("login.xhtml");
			rd.forward(request, response);
		}
		
		
	}

}
