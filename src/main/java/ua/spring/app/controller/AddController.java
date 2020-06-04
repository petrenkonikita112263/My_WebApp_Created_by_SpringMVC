package ua.spring.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.service.Customable;

@Controller
public class AddController {

    private static final Logger LOGGER = Logger.getLogger(AddController.class);

    @Autowired
    private Customable customerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showCustomerForm")
    public String getCustomerForm() {
        return "add-data";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/addCustomer")
    public ModelAndView createCustomer(ModelAndView modelAndView,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "password", required = false) String password) {
        LOGGER.info("Method to create new customer was called");
            customerService.addCustomer(name, password);
        modelAndView.addObject("infoMessage", "new customer");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

}
