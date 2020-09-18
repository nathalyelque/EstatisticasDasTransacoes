package br.com.praticando.estatisticasdastransacoes.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroDeValidacao> tratar(MethodArgumentNotValidException excecao) {
		List<ErroDeValidacao> erros = new ArrayList<>();
		
		List<FieldError> listaDeCampoDeErro = excecao.getBindingResult().getFieldErrors();
		
		for (FieldError campoDeErro : listaDeCampoDeErro) {
			erros.add(new ErroDeValidacao(campoDeErro.getField(), campoDeErro.getDefaultMessage()));
		}
		
		return erros;
	}

}
