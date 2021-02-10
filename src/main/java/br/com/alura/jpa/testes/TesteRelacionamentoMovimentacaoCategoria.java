package br.com.alura.jpa.testes;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.alura.jpa.modelo.Categoria;
import br.com.alura.jpa.modelo.Conta;
import br.com.alura.jpa.modelo.Movimentacao;
import br.com.alura.jpa.modelo.TipoMovimentacao;

public class TesteRelacionamentoMovimentacaoCategoria {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas"); 
		EntityManager em = emf.createEntityManager();
		
		Categoria categoria = new Categoria("Viagem");
		Categoria categoria2 = new Categoria("Negócios");
		
		Conta conta = new Conta();
		conta.setId(1L);
		
		Movimentacao movimentacao = new Movimentacao(
				TipoMovimentacao.SAIDA, LocalDateTime.now(),
				"Viagem à SP", new BigDecimal(300.0), conta);
		movimentacao.setCategorias(Arrays.asList(categoria, categoria2));
		
		Movimentacao movimentacao2 = new Movimentacao(
				TipoMovimentacao.SAIDA, LocalDateTime.now(),
				"Viagem à RJ", new BigDecimal(500.0), conta);
		movimentacao2.setCategorias(Arrays.asList(categoria, categoria2));
		
		
		em.getTransaction().begin();
		em.persist(categoria);
		em.persist(categoria2);
		em.persist(movimentacao);
		em.persist(movimentacao2);
		em.getTransaction().commit();
		em.close();
	}
}