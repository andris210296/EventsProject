package br.com.events.model;

import javax.persistence.*;

public class GeraTabelas {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("events");

		factory.close();
	}
}
