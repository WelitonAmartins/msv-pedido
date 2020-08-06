package br.com.unilito.enums;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum StatusPedido {
	
	ENVIADO_COBRANCA(1, "Enviado para cobraça");

	private Integer id;
	
	@JsonValue
	private String descricao;
	
	
	public StatusPedido parse(final Integer id) {
		return Arrays.stream(values()).filter(status -> status.id.equals(id)).findFirst().orElse(null);
	}
	
}
