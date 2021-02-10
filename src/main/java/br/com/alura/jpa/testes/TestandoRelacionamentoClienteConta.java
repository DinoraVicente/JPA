package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Cliente;
import br.com.alura.jpa.modelo.Conta;

public class TestandoRelacionamentoClienteConta {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Cliente cliente = new Cliente();
		cliente.setNome("Joaquim"); 
		cliente.setProfissao("Carpinteiro"); 
		cliente.setEndereco("Rua fulaninho, 123"); 
		cliente.setConta(conta);
		
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		
		em.close();
	}
}