package br.com.unilito.enums;

import static br.com.unilito.utils.UtilsConstants.BOLETO_RK;
import static br.com.unilito.utils.UtilsConstants.CREDITO_RK;
import static br.com.unilito.utils.UtilsConstants.DEBITO_RK;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter; 

@AllArgsConstructor
@Getter
public enum TipoPagamento {

	CREDITO(0, CREDITO_RK), 
	DEBITO(1, DEBITO_RK), 
	BOLETO(2, BOLETO_RK);
	
	@JsonValue
	private Integer id;
	private String routeKey;

	public TipoPagamento parse(Integer id) {
		return Arrays.stream(values()).filter(tipo -> tipo.id.equals(id)).findFirst().orElse(null);
	}
}
