package br.com.unilito.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.enums.StatusPedido;
import br.com.unilito.enums.TipoPagamento;
import br.com.unilito.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public ResponseEntity<PedidoDTO> registrarPedido(@RequestBody PedidoDTO param) {
		return ResponseEntity.ok(pedidoService.registrarPedido(param));
	}

	@GetMapping
	public ResponseEntity<PedidoDTO> buscarPedido() {
		return ResponseEntity.ok(PedidoDTO.builder().id(1L).dtPedido(LocalDate.now()).email("batatinha@gmail.com")
				.tipo(TipoPagamento.BOLETO).status(StatusPedido.ENVIADO_COBRANCA).valor(BigDecimal.ONE).build());
	}
}
