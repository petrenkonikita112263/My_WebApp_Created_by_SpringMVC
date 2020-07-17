package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Login controller class processes HTTP requests:
 * go to log in page and 503 page - forbidden.
 */
@Controller
public class LoginController {

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/showLoginPage" path.
     *
     * @return name of log in jsp page
     */
    @GetMapping("/showLoginPage")
    public String showLoginPage() {
        return "main-login";
    }

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/access-denied" path.
     *
     * @return name of forbidden jsp page
     */
    @GetMapping("/access-denied")
    public String showErrorAccessPage() {
        return "access-denied";
    }

}
