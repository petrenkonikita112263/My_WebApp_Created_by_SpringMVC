package ua.spring.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String showPublicPage() {
        return "public-page";
    }

    @GetMapping("/guests")
    public String showHome() {
        return "home";
    }

    @GetMapping("/customers")
    public String showCustomerPage() {
        return "customers";
    }

    @GetMapping("/systems")
    public String showAdminPage() {
        return "admins";
    }
}
