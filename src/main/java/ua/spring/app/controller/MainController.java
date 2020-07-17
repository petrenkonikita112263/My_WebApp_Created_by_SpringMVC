package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Main controller class processes HTTP requests:
 * go to start page, home page, customer and admin pages.
 */
@Controller
public class MainController {

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/" path.
     *
     * @return name of start jsp page
     */
    @GetMapping("/")
    public String showPublicPage() {
        return "public-page";
    }

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/guests" path.
     *
     * @return name of home jsp page
     */
    @GetMapping("/guests")
    public String showHome() {
        return "home";
    }

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/customers" path.
     *
     * @return name of customer jsp page
     */
    @GetMapping("/customers")
    public String showCustomerPage() {
        return "customers";
    }

    /**
     * Method with @GetMapping annotation says this method should be called,
     * when someone calls the GET method on the "/systems" path.
     *
     * @return name of admin jsp page
     */
    @GetMapping("/systems")
    public String showAdminPage() {
        return "admins";
    }
}
