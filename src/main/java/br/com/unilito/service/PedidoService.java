package br.com.unilito.service;

import static br.com.unilito.utils.UtilsConstants.PAGAMENTO_EXCHANGE;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.unilito.dto.PedidoDTO;
import br.com.unilito.enums.StatusPedido;
import br.com.unilito.utils.Utils;

@Service
public class PedidoService {

	@Autowired
	private AmqpTemplate amqpTemplate;

	public PedidoDTO registrarPedido(PedidoDTO param) {

		amqpTemplate.convertAndSend(PAGAMENTO_EXCHANGE, param.getTipo().getRouteKey(), Utils.paraJson(param));

		param.setStatus(StatusPedido.ENVIADO_COBRANCA);

		return param;
	}

}
