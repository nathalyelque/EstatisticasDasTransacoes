package br.com.praticando.estatisticasdastransacoes.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.praticando.estatisticasdastransacoes.model.Transacao;

public class TransacaoRepositoryTeste {
	
	@Test
	public void deveRetornarUmaListaVaziaQuandoNaoHaTransacoes() {
		TransacaoRepository transacaoRepository = new TransacaoRepository();
		
		List<Transacao> transacoes = transacaoRepository.obterTodasDosUltimos60Segundos();
		
		assertEquals(0, transacoes.size());
	}
	
	@Test
	public void deveRetornarUmaListaComValorQuandoHouverTransacoes() {
		TransacaoRepository transacaoRepository = new TransacaoRepository();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now());
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(5.5), LocalDateTime.now());
		
		transacaoRepository.inserir(transacao1);
		transacaoRepository.inserir(transacao2);
		
		List<Transacao> transacoes = transacaoRepository.obterTodasDosUltimos60Segundos();
		
		
		assertEquals(2, transacoes.size());
	}
	
	@Test
	public void deveRetornarUmaListaComValorQuandoHouverTransacoesDentroDosUltimos60Segundos() {
		TransacaoRepository transacaoRepository = new TransacaoRepository();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now());
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(5.5), LocalDateTime.now().minusMinutes(2));
		
		transacaoRepository.inserir(transacao1);
		transacaoRepository.inserir(transacao2);
		
		List<Transacao> transacoes = transacaoRepository.obterTodasDosUltimos60Segundos();
		
		
		assertEquals(1, transacoes.size());
	}
	
	@Test
	public void deveRetornarUmaListaVaziaQuandoHouverSomenteTransacoesForaDosUltimos60Segundos() {
		TransacaoRepository transacaoRepository = new TransacaoRepository();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now().minusMinutes(3));
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(5.5), LocalDateTime.now().minusMinutes(2));
		
		transacaoRepository.inserir(transacao1);
		transacaoRepository.inserir(transacao2);
		
		List<Transacao> transacoes = transacaoRepository.obterTodasDosUltimos60Segundos();
		
		
		assertEquals(0, transacoes.size());
	}
	
	@Test
	public void deveDeletarTodasAsTransacoes() {
		TransacaoRepository transacaoRepository = new TransacaoRepository();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now());
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(5.5), LocalDateTime.now().minusMinutes(2));
		
		transacaoRepository.inserir(transacao1);
		transacaoRepository.inserir(transacao2);
		
		transacaoRepository.removerTodas();
		List<Transacao> transacoes = transacaoRepository.obterTodas();
		
		assertEquals(0, transacoes.size());		
		
	}

}
