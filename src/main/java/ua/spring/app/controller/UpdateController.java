package ua.spring.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.service.Customable;

@Controller
public class UpdateController {

    private static final Logger LOGGER = Logger.getLogger(UpdateController.class);

    @Autowired
    private Customable customerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showCustomerEditForm/{customerId}")
    public String getCustomerEditForm(@PathVariable("customerId") int customerId) {
        return "edit-data";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/updateCustomer")
    public ModelAndView updateCustomer(ModelAndView modelAndView,
                                       @RequestParam(value = "id", required = false) String id,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "password") String password) {
        LOGGER.info("Method to create new customer was called");
        customerService.updateCustomerData(id, name, password);
        modelAndView.addObject("infoMessage", "new customer");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

}
