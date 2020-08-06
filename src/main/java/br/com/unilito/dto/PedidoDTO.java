package br.com.unilito.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.unilito.enums.StatusPedido;
import br.com.unilito.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties
@Builder
public class PedidoDTO implements Serializable  {
	private static final long serialVersionUID = 1L;
	
	
	private Long id;
	private LocalDate dtPedido;
	private BigDecimal valor;
	private String email;
	private TipoPagamento tipo;
	private StatusPedido status;
}
