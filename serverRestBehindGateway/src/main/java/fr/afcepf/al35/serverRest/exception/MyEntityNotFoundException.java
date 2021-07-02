package fr.afcepf.al35.serverRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND) //404
public class MyEntityNotFoundException extends RuntimeException {

	public MyEntityNotFoundException() {
	}

	public MyEntityNotFoundException(String message) {
		super(message);
	}

	public MyEntityNotFoundException(Throwable cause) {
		super(cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyEntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
