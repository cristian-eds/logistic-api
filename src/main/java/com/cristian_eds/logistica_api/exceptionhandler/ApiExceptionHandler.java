package com.cristian_eds.logistica_api.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{
	
	@Autowired
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		List<Field> fields = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().stream().forEach(
			 err -> {
				 String fieldError = ((FieldError) err).getField();
				 String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
				 fields.add(new Field(fieldError,message));
			 }
		);
			
		Error error = new Error();
		error.setStatus(status.value());
		error.setDateTime(LocalDateTime.now());
		error.setTitle("One or more fields are invalids. Check and try again");
		error.setFields(fields);
		
		return super.handleExceptionInternal(ex, error,headers, status, request);
	}
}
