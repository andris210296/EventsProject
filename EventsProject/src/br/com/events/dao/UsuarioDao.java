package br.com.events.dao;
import java.util.List;

import br.com.events.model.*;

public interface UsuarioDao {
	
	public void cadastrarUsuario(Usuario usuario);
	public List<Usuario> pesquisarUsuario(String nome);
	public boolean encontrar(Usuario usuario);
	public Usuario logar(String login,String senha);
	public Usuario usuario(Long id);
	void editar(Usuario usuario);
	

}
