package net.nerddash.simpleauctionapi.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ApiResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FormErrorDTO> errors = createHandledErrorList(ex.getBindingResult());

		return handleExceptionInternal(ex, errors, headers, status, request);
	}

	private List<FormErrorDTO> createHandledErrorList(BindingResult bindingResult) {
		List<FormErrorDTO> errors = new ArrayList<>();

		bindingResult.getFieldErrors().forEach(fieldError -> {

			String error = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
			String field = fieldError.getField();
			errors.add(new FormErrorDTO(field, error));
		});

		return errors;
	}

	public class FormErrorDTO {

		private String field;
		private String error;

		public FormErrorDTO(String field, String error) {
			super();
			this.field = field;
			this.error = error;
		}

		public String getField() {
			return field;
		}

		public String getError() {
			return error;
		}

	}

}
