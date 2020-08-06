package br.com.unilito.config;

import static br.com.unilito.utils.UtilsConstants.BOLETO_RK;
import static br.com.unilito.utils.UtilsConstants.CREDITO_RK;
import static br.com.unilito.utils.UtilsConstants.DEBITO_RK;
import static br.com.unilito.utils.UtilsConstants.LOG_RK;
import static br.com.unilito.utils.UtilsConstants.PAGAMENTO_EXCHANGE;
import static br.com.unilito.utils.UtilsConstants.QUEUE_BOLETO;
import static br.com.unilito.utils.UtilsConstants.QUEUE_CREDITO;
import static br.com.unilito.utils.UtilsConstants.QUEUE_DEBITO;
import static br.com.unilito.utils.UtilsConstants.QUEUE_LOG;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

	@Bean
	public Queue creditoQueue() {
		return new Queue(QUEUE_CREDITO, false);
	}

	@Bean
	public Queue debitoQueue() {
		return new Queue(QUEUE_DEBITO, false);
	}

	@Bean
	public Queue boletoQueue() {
		return new Queue(QUEUE_BOLETO, false);
	}

	@Bean
	public Queue logQueue() {
		return new Queue(QUEUE_LOG, false);
	}

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(PAGAMENTO_EXCHANGE, false, false);
	}

	@Bean
	public Binding creditoBinding(final Queue creditoQueue, final TopicExchange topicExchange) {
		return BindingBuilder.bind(creditoQueue).to(topicExchange).with(CREDITO_RK);
	}

	@Bean
	public Binding debitoBinding(final Queue debitoQueue, final TopicExchange topicExchange) {
		return BindingBuilder.bind(debitoQueue).to(topicExchange).with(DEBITO_RK);
	}

	@Bean
	public Binding boletoBinding(final Queue boletoQueue, final TopicExchange topicExchange) {
		return BindingBuilder.bind(boletoQueue).to(topicExchange).with(BOLETO_RK);
	}

	@Bean
	public Binding logBinding(final Queue logQueue, final TopicExchange topicExchange) {
		return BindingBuilder.bind(logQueue).to(topicExchange).with(LOG_RK);
	}
}
