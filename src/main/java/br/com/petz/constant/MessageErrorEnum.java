package br.com.petz.constant;

public enum MessageErrorEnum {

	CLIENT_NOT_FOUND_BY_ID("Cliente não encontrado para o id: ");
	
	private MessageErrorEnum(String message) {
		this.message = message;
	}
	
	private String message;

	public String getMessage() {
		return message;
	}
}
