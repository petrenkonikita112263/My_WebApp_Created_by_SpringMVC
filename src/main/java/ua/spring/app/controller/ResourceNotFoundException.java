package ua.spring.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class extends runtime exception, @ResponseStatus -
 * pass the status of the result of the operation in the header
 * of the HTTP response to the web page. Triggered on not found - 404 page.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
}
