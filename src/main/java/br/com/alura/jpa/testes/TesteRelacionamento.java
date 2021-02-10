package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamento {
	public static void main(String[] args) {
	
		Conta conta = new Conta("Leonardo", 1231255, 85556, 300.0);	
		
		Movimentacao movimentacao = new Movimentacao(
				TipoMovimentacao.ENTRADA, LocalDateTime.now(), "Churrascaria", 
				new BigDecimal(200.0), conta);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.persist(movimentacao);
		em.getTransaction().commit();
		
		em.close();
	}
} 