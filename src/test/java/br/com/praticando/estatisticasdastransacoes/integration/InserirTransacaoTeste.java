package br.com.praticando.estatisticasdastransacoes.integration;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest()
@AutoConfigureMockMvc
public class InserirTransacaoTeste {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void naoDeveInserirTransacaoQuandoReceberValorNulo() throws Exception {
		String endereco = "/transacao";
		String json = "{\"valor\": null,\"dataHora\": \"2020-09-13T17:26:12.000Z\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(endereco)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isBadRequest());
	}

	@Test
	public void naoDeveInserirTransacaoQuandoReceberDataHoraNula() throws Exception {
		String endereco = "/transacao";
		String json = "{\"valor\": 12,\"dataHora\": null}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(endereco)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isBadRequest());
	}
	
	@Test
	public void naoDeveInserirTransacaoQuandoReceberValorNegativo() throws Exception {
		String endereco = "/transacao";
		String json = "{\"valor\": -2,\"dataHora\": \"2020-09-13T17:26:12.000Z\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(endereco)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isBadRequest());
	}

	@Test
	public void naoDeveInserirTransacaoQuandoReceberDataHoraNoFuturo() throws Exception {
		String endereco = "/transacao";
		LocalDateTime dataNoFuturo = LocalDateTime.now().plusMinutes(3);
		String json = "{\"valor\": 2,\"dataHora\": \"" + dataNoFuturo + "\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(endereco)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isBadRequest());
	}

	@Test
	public void deveInserirTransacaoQuandoReceberTransacaoValida() throws Exception {
		String endereco = "/transacao";
		String json = "{\"valor\": 12.9,\"dataHora\": \"2020-09-13T17:26:12.000Z\"}";
		
		mockMvc.perform(MockMvcRequestBuilders.post(endereco)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isCreated());
	}
}
