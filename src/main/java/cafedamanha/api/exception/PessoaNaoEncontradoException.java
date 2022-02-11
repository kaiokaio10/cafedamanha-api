package cafedamanha.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontradoException extends RuntimeException {
	
	public PessoaNaoEncontradoException() {
		super();
	}

	public PessoaNaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public PessoaNaoEncontradoException(String message) {
		super(message);
	}

	public PessoaNaoEncontradoException(Throwable cause) {
		super(cause);
	}

}
