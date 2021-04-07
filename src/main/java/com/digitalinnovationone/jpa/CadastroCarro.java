package com.digitalinnovationone.jpa;

import com.digitalinnovationone.jpa.model.Carro;
import com.digitalinnovationone.jpa.model.Cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CadastroCarro {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Cliente cliente = new Cliente();
		cliente.setId(1);
		Carro carro = new Carro();
		carro.setCliente(cliente);
		carro.setMarca("Ford");
		carro.setModelo("Fusion");
		entityManager.persist(carro);
		System.out.println(carro);
		entityManager.getTransaction().commit();
		entityManager.close();
		entityManagerFactory.close();
	}
}
