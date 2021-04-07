package com.digitalinnovationone.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.digitalinnovationone.jpa.model.Cliente;

public class CadastroCliente {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Cliente cliente = entityManager.find(Cliente.class, 1);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
		System.out.println(cliente.getCarros().get(0).getMarca());


	}
}
