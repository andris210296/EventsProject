package br.com.events.dao;

import java.util.List;

import br.com.events.model.Evento;

public interface EventoDao {
	
	public void cadastrarEvento(Evento evento);
	public List<Evento> listarEvento();
	

}
