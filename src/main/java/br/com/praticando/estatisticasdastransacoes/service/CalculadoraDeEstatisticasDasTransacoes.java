package br.com.praticando.estatisticasdastransacoes.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.praticando.estatisticasdastransacoes.model.EstatisticasDasTransacoes;
import br.com.praticando.estatisticasdastransacoes.model.Transacao;

@Service
public class CalculadoraDeEstatisticasDasTransacoes {
		
	public EstatisticasDasTransacoes calcular(List<Transacao> transacoes) {
		int contador = 0;
		BigDecimal somatoria = BigDecimal.ZERO;
		BigDecimal minimo = null;
		BigDecimal maximo = null;
		BigDecimal media = null;
		
		for (Transacao transacao : transacoes) {
			contador = contador + 1;
			somatoria = somatoria.add(transacao.getValor());
			
			if (minimo == null) {
				minimo = transacao.getValor();
			}
			else {
				if(transacao.getValor().compareTo(minimo) < 0) {
					minimo = transacao.getValor();
				}
			}
			
			if (maximo == null) {
				maximo = transacao.getValor();
			}
			else {
				if(transacao.getValor().compareTo(maximo) > 0) {
					maximo = transacao.getValor();
				}
			}
		}
		
		if (contador > 0) {
			media = somatoria.divide(BigDecimal.valueOf(contador), 2, RoundingMode.HALF_UP);
		}
				
		return new EstatisticasDasTransacoes(contador, somatoria, media, minimo, maximo);
	}

}
