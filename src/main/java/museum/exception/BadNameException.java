package museum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception for bad request name for worker.
 *
 * @author Rostyslav Khasanov
 * @version 1.0
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No such Worker")
public class BadNameException extends RuntimeException {
  public BadNameException(String message) {
    super(message);
  }
}
