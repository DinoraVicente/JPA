package br.com.alura.jpa.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;

public class TesteEstados {
	public static void main(String[] args) {
		// Transient (objeto desvinculado)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		
		Conta conta = new Conta();
		conta.setTitular("Almiro");
		conta.setAgencia(123123);
		conta.setNumero(12387128);
		
		em.getTransaction().begin();
		
		// Transient -> Managed
		em.persist(conta);
		
		// Managed -> Removed
		em.remove(conta);
		em.getTransaction().commit();
	}
}