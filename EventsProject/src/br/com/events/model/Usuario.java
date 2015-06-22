package br.com.events.model;

import java.util.List;

import javax.persistence.*;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String login;
	private String senha;
	private String email;
	private String dtNascimento;
	
	@OneToMany
	private List<Evento> eventos;
	
	
	
	public Long getId(){
		return id;
	}
	public void setId(Long id){
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

}
