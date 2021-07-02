package fr.afcepf.al35.serverRest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT) 
public class MyAlreadyExistingEntityException extends RuntimeException {

	public MyAlreadyExistingEntityException() {
	}

	public MyAlreadyExistingEntityException(String message) {
		super(message);
	}

	public MyAlreadyExistingEntityException(Throwable cause) {
		super(cause);
	}

	public MyAlreadyExistingEntityException(String message, Throwable cause) {
		super(message, cause);
	}

	public MyAlreadyExistingEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
