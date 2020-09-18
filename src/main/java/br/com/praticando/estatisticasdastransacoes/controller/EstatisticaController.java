package br.com.praticando.estatisticasdastransacoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.praticando.estatisticasdastransacoes.model.EstatisticasDasTransacoes;
import br.com.praticando.estatisticasdastransacoes.model.Transacao;
import br.com.praticando.estatisticasdastransacoes.repository.TransacaoRepository;
import br.com.praticando.estatisticasdastransacoes.service.CalculadoraDeEstatisticasDasTransacoes;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/estatistica")
@Api(tags = "EstatisticaController",description = "Responsável por calcular as estatísticas das transações.")
public class EstatisticaController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@Autowired
	private CalculadoraDeEstatisticasDasTransacoes calculadoraDeEstatisticasDasTransacoes;
	
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Retorna um objeto contendo as estatísticas das transações, com as seguintes informações:"
					+ " total de transações realizadas, somatória, média, valor mínimo, e valor máximo.")
	})
	@ApiOperation(value = "Obtém as estatísticas das transações realizadas nos últimos 60 segundos.")
	@GetMapping(produces = "application/json")
	public EstatisticasDasTransacoes obter() {
		List<Transacao> listaDeTransacoesDosUltimos60Segundos = transacaoRepository.obterTodasDosUltimos60Segundos();
		
		EstatisticasDasTransacoes estatisticasDasTransacoes = calculadoraDeEstatisticasDasTransacoes.calcular(listaDeTransacoesDosUltimos60Segundos);
		
		return estatisticasDasTransacoes;
	}

}
