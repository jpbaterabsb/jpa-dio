package com.digitalinnovationone.jpa;

import com.digitalinnovationone.jpa.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClienteLazyInitializerException {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cliente cliente = entityManager.find(Cliente.class, 1);
		entityManager.close();
		System.out.println(cliente.getCarros().get(0).getMultas());
		entityManagerFactory.close();

	}
}
