package cafedamanha.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaException extends RuntimeException {
	
	public PessoaException() {
		super();
	}

	public PessoaException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaException(String message) {
		super(message);
	}

	public PessoaException(Throwable cause) {
		super(cause);
	}

}
