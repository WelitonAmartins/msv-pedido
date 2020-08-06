package br.com.unilito.utils;

public class UtilsConstants {

	// Queues
	public static final String QUEUE_CREDITO = "Q_CREDITO";
	public static final String QUEUE_DEBITO = "Q_DEBITO";
	public static final String QUEUE_BOLETO = "Q_BOLETO";
	public static final String QUEUE_LOG = "Q_LOG";

	// Exchange
	public static final String PAGAMENTO_EXCHANGE = "TOPIC_PAGAMENTO";

	// Route Key
	public static final String CREDITO_RK = "FP.CREDITO";
	public static final String BOLETO_RK = "FP.BOLETO";
	public static final String DEBITO_RK = "FP.DEBITO";
	public static final String LOG_RK = "FP.*";

}
