package br.com.events.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.events.dao.EventoDao;
import br.com.events.dao.EventoDaoJpa;
import br.com.events.dao.UsuarioDao;
import br.com.events.dao.UsuarioDaoJpa;
import br.com.events.model.Evento;
import br.com.events.model.Usuario;


@WebServlet("/cadastrarEvento")
public class cadastrarEvento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public cadastrarEvento() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String idString = request.getParameter("id");
		
		Long id = Long.parseLong(idString);
		
		UsuarioDao udao =  new UsuarioDaoJpa();
		Usuario usuario = udao.usuario(id);
		
		
		String nome = request.getParameter("nomeEvento");		
		String descricao = request.getParameter("descricaoEvento");
		String data= request.getParameter("dataEvento");
		String horario = request.getParameter("horarioEvento");
		
		
		EventoDao edao = new EventoDaoJpa();
		
		
		
		Evento evento = new Evento();
		evento.setNome(nome);
		evento.setDescricao(descricao);
		evento.setData(data);
		evento.setHorario(horario);
		
		evento.setUsuario(usuario);
		
		edao.cadastrarEvento(evento);
		
		List<Evento> eventos = new ArrayList<Evento>();
		for (Evento e : edao.listarEvento()) {
			
			
			if(e.getUsuario().getId() == usuario.getId()){
				
				eventos.add(e);
			}
			
		} 
		
		request.setAttribute("eventos", eventos);
		
		RequestDispatcher rd = request.getRequestDispatcher("login.xhtml");
		rd.forward(request, response);
		
		
		
	}

}
