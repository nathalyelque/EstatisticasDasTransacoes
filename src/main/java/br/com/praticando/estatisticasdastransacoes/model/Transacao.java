package br.com.praticando.estatisticasdastransacoes.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {
	
    private BigDecimal valor;
	private LocalDateTime dataHora;
		
	public Transacao(BigDecimal valor, LocalDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora;
	}
	
	public BigDecimal getValor() {
		return valor;
	}
	
	public LocalDateTime getDataHora() {
		return dataHora;
	}

}
