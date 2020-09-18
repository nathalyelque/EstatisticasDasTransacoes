package br.com.praticando.estatisticasdastransacoes.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.praticando.estatisticasdastransacoes.model.EstatisticasDasTransacoes;
import br.com.praticando.estatisticasdastransacoes.model.Transacao;


public class CalculadoraDeEstatisticasDasTransacoesTeste {

	@Test
	public void deveCalcularQuandoAListaDeTransacaoEhVazia() {
		CalculadoraDeEstatisticasDasTransacoes calculadoraDeEstatisticasDasTransacoes = new CalculadoraDeEstatisticasDasTransacoes();
		
		EstatisticasDasTransacoes estatisticasDasTransacoes = calculadoraDeEstatisticasDasTransacoes.calcular(new ArrayList<>());
		
		assertEquals(0, estatisticasDasTransacoes.getCount());
		assertEquals(BigDecimal.ZERO, estatisticasDasTransacoes.getSum());
		assertEquals(null, estatisticasDasTransacoes.getAvg());
		assertEquals(null, estatisticasDasTransacoes.getMin());
		assertEquals(null, estatisticasDasTransacoes.getMax());
	}
	
	@Test
	public void deveCalcularQuandoAListaDeTransacaoPossuirValor() {
		CalculadoraDeEstatisticasDasTransacoes calculadoraDeEstatisticasDasTransacoes = new CalculadoraDeEstatisticasDasTransacoes();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now());
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(5.5), LocalDateTime.now());
		
		List<Transacao> transacoes = new ArrayList<>();
		transacoes.add(transacao1);
		transacoes.add(transacao2);
		
		EstatisticasDasTransacoes estatisticasDasTransacoes = calculadoraDeEstatisticasDasTransacoes.calcular(transacoes);
		
		assertEquals(2, estatisticasDasTransacoes.getCount());
		assertEquals(BigDecimal.valueOf(15.5), estatisticasDasTransacoes.getSum());
		assertEquals(BigDecimal.valueOf(7.75), estatisticasDasTransacoes.getAvg());
		assertEquals(BigDecimal.valueOf(5.5), estatisticasDasTransacoes.getMin());
		assertEquals(BigDecimal.TEN, estatisticasDasTransacoes.getMax());
	}
	
	@Test
	public void deveCalcularMediaLimitandoAsCasasDecimaisAposAVirgula() {
		CalculadoraDeEstatisticasDasTransacoes calculadoraDeEstatisticasDasTransacoes = new CalculadoraDeEstatisticasDasTransacoes();
		Transacao transacao1 = new Transacao(BigDecimal.TEN, LocalDateTime.now());
		Transacao transacao2 = new Transacao(BigDecimal.valueOf(8), LocalDateTime.now());
		Transacao transacao3 = new Transacao(BigDecimal.valueOf(2), LocalDateTime.now());
		
		List<Transacao> transacoes = new ArrayList<>();
		transacoes.add(transacao1);
		transacoes.add(transacao2);
		transacoes.add(transacao3);
		
		EstatisticasDasTransacoes estatisticasDasTransacoes = calculadoraDeEstatisticasDasTransacoes.calcular(transacoes);
		
		assertEquals(3, estatisticasDasTransacoes.getCount());
		assertEquals(BigDecimal.valueOf(20), estatisticasDasTransacoes.getSum());
		assertEquals(BigDecimal.valueOf(6.67), estatisticasDasTransacoes.getAvg());
		assertEquals(BigDecimal.valueOf(2), estatisticasDasTransacoes.getMin());
		assertEquals(BigDecimal.TEN, estatisticasDasTransacoes.getMax());
	}
}
