package br.com.events.servlets;

import java.io.IOException;

import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.events.dao.EventoDao;
import br.com.events.dao.EventoDaoJpa;
import br.com.events.model.Evento;

/**
 * Servlet implementation class indexServlet
 */
@WebServlet("/indexServlet")
public class indexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public indexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		EventoDao edao = new EventoDaoJpa();
		List<Evento> eventos = edao.listarEvento();
	
		request.setAttribute("eventos", eventos);
		
		RequestDispatcher rd = request.getRequestDispatcher("index.xhtml");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 

	}

}
