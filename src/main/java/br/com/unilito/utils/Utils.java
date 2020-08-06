package br.com.unilito.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import lombok.extern.java.Log;

@Log
public class Utils {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		mapper.registerModule(new JavaTimeModule());
	}

	public static String paraJson(final Object obj) {
		String jsonFormatado = null;
		try {
			jsonFormatado = mapper.writeValueAsString(obj);
		} catch (final JsonProcessingException e) {
			log.info("Erro ao converter o DTO para Json.");
//			throw new Exception("Erro ao converter o DTO para Json.");
		}
		return jsonFormatado;
	}

}
