package spitter.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Spittle is not found")
public class SpittleNotFoundException extends RuntimeException {
}
