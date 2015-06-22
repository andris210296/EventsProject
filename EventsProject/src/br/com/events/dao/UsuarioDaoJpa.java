package br.com.events.dao;

import java.util.List;

import javax.persistence.*;

import br.com.events.model.Usuario;

public class UsuarioDaoJpa implements UsuarioDao {

	private EntityManagerFactory factory;
	private EntityManager manager;

	public UsuarioDaoJpa() {
		factory = Persistence.createEntityManagerFactory("events");
		manager = factory.createEntityManager();
	}

	@Override
	public void cadastrarUsuario(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();

	}

	@Override
	public List<Usuario> pesquisarUsuario(String nome) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean encontrar(Usuario usuario) {		
		
		

		Query query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.login = :plogin");
		query.setParameter("plogin", usuario.getLogin());
		return true;
		
		
		

	}

	@Override
	public void editar(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();

	}

	@Override
	public Usuario logar(String login, String senha) {
		
		try{
		Query query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.login = :plogin AND u.senha = :psenha");
		query.setParameter("plogin", login);
		query.setParameter("psenha", senha);

		Usuario usuario =  (Usuario) query.getSingleResult();
		
		return usuario;
		}
		catch(Exception e){
			
			Usuario vaziousuario = new Usuario();
			return vaziousuario;
			
		}

		

	}

	@Override
	public Usuario usuario(Long id) {
		Query query = manager
				.createQuery("SELECT u FROM Usuario u WHERE u.id = :pid");
		query.setParameter("pid", id);
		

		Usuario usuario =  (Usuario) query.getSingleResult();
		

		return usuario;

	}

}
