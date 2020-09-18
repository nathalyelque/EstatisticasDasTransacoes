package br.com.praticando.estatisticasdastransacoes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.praticando.estatisticasdastransacoes.config.ErroDeValidacao;
import br.com.praticando.estatisticasdastransacoes.controller.form.TransacaoForm;
import br.com.praticando.estatisticasdastransacoes.model.Transacao;
import br.com.praticando.estatisticasdastransacoes.repository.TransacaoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/transacao")
@Api(tags = "TransacaoController", description = "Responsável por inserir e remover as transações.")
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository transacaoRepository;
	
	@ApiResponses(value = {
			@ApiResponse(code = 201, message = "Transação inserida", response = Object.class),
			@ApiResponse(code = 400, message = "Transação inválida", response = ErroDeValidacao.class, responseContainer = "List")
	})
	@ApiOperation(value = "Insere uma transação.")
	@ResponseStatus(value = HttpStatus.CREATED)
	@PostMapping(produces = "application/json")
	public ResponseEntity inserir(@ApiParam(value = "Uma transação deve conter valor e dataHora, onde o valor não pode ser null "
			+ "e deve ser maior ou igual a zero, e a dataHora não pode ser no futuro e também não pode ser null.")
			@Valid @RequestBody TransacaoForm form) {
		Transacao transacao = new Transacao(form.getValor(),form.getDataHora());
		transacaoRepository.inserir(transacao);
		return ResponseEntity.created(null).body(null);
	}
	
	@ApiOperation(value = "Remove todas as transações.")	
	@DeleteMapping(produces = "application/json")
	public void removerTodas(){
		transacaoRepository.removerTodas();
	}

}
