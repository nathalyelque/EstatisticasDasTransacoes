package br.com.praticando.estatisticasdastransacoes.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.praticando.estatisticasdastransacoes.model.Transacao;

@Repository
public class TransacaoRepository {

	private List<Transacao> transacoes = new ArrayList<>();
	
	public synchronized void inserir(Transacao transacao) {
		transacoes.add(transacao);
	}
	
	public synchronized List<Transacao> obterTodasDosUltimos60Segundos() {
		List<Transacao> transacoesDosUltimos60Segundos = new ArrayList<>();
		LocalDateTime ultimoMinuto = LocalDateTime.now().minusMinutes(1);
		
		for (Transacao transacao : transacoes) {
			if(transacao.getDataHora().isAfter(ultimoMinuto)) {
				transacoesDosUltimos60Segundos.add(transacao);
			}
		}
		
		return transacoesDosUltimos60Segundos;
	}

	public synchronized void removerTodas() {
		transacoes = new ArrayList<>();
	}
	
	public synchronized List<Transacao> obterTodas(){
		return transacoes;
	}
}
