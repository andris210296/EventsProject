package br.com.events.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.events.model.Evento;

public class EventoDaoJpa implements EventoDao {
	private EntityManagerFactory factory;
	private EntityManager manager;
	
	public EventoDaoJpa() {
		factory = Persistence.createEntityManagerFactory("events");
		manager = factory.createEntityManager();
	}
	
	
	@Override
	public void cadastrarEvento(Evento evento) {
		
		System.out.println(evento);
		
		manager.getTransaction().begin();
		manager.persist(evento);
		manager.getTransaction().commit();
		
	}

	@Override
	public List<Evento> listarEvento() {
		
		List<Evento> lista = manager.createQuery("SELECT e FROM Evento e").getResultList();

				
		
		
		return lista;
	}

}
