package br.com.events.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import br.com.events.dao.UsuarioDao;
import br.com.events.dao.UsuarioDaoJpa;
import br.com.events.model.Usuario;


@WebServlet("/cadastrarUsuario")
public class cadastrarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public cadastrarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");		
		String senha = request.getParameter("senha");
		String email = request.getParameter("email");
		String dtNascimento = request.getParameter("dtnascimento");
		
		
		UsuarioDao udao =  new UsuarioDaoJpa();
		
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setLogin(login);		
		usuario.setSenha(senha);
		usuario.setDtNascimento(dtNascimento);
		
		
		String mensagem = "";
		
		
			mensagem = "Salvo com Sucesso";
			udao.cadastrarUsuario(usuario);	
		
		
		
		
		
		
		request.setAttribute("mensagem", mensagem);
		
		RequestDispatcher rd = request.getRequestDispatcher("cadastro.xhtml");
		rd.forward(request, response);
		
		
	}
}
