package com.digitalinnovationone.jpa;

import com.digitalinnovationone.jpa.model.Carro;
import com.digitalinnovationone.jpa.model.Cliente;
import com.digitalinnovationone.jpa.model.Multa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;

public class CadastroCascade {

	public static void main(String... string) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();



		Cliente cliente = new Cliente();
		cliente.setNome("Rei dos Tecidos");
		Multa multa = new Multa();
		multa.setData(LocalDateTime.now());
		multa.setValor(50.00);
		Carro carro = new Carro();
		carro.setCliente(cliente);
		carro.setModelo("Fusca");
		carro.setMarca("Ford");
		carro.setMultas(Collections.singletonList(multa));
		multa.setCarro(carro);
		cliente.setCarros(Collections.singletonList(carro));
		entityManager.persist(cliente);
		System.out.println(cliente);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();

	}
}
