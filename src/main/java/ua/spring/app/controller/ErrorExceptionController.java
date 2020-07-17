package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Error controller class processes HTTP requests:
 * go to error page when asked page wasn't found.
 */
@Controller
public class ErrorExceptionController {

    /**
     * In case of an exception, the method will be redirected to not found page.
     *
     * @return name of not found jsp page
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public String handleResourceNotFoundException() {
        return "notFound";
    }

    /**
     * This method listens / catches HTTP client requests and binds
     * the address to the handler method. Value - describes the URL that will be processed
     * in this controller method. Method - associates a controller method with processing requests
     * sent by a specific HTTP method or methods.
     *
     * @param name  user request @PathVariable - allows you to enter a path variable
     *              from the URL as a parameter
     * @param model object is passed to the handler method as a parameter,
     *              and the handler method returns the name of the "view"
     * @return name of error jsp page
     */
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public String viewEdit(@PathVariable("name") final String name, Model model) {
        if (name.equals("null")) throw new ResourceNotFoundException();
        model.addAttribute("msg", name);
        return "error";
    }

}
