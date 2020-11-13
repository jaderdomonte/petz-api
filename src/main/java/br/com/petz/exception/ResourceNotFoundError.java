package br.com.petz.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceNotFoundError {

	private String title;
	private Integer status;
	private String details;
	private Long date;
	private String message;
}
