package ua.spring.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.service.Customable;

@Controller
public class RemoveController {

    private static final Logger LOGGER = Logger.getLogger(RemoveController.class);

    @Autowired
    private Customable customerService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/systems/removeCustomer/{customerId}")
    public ModelAndView delete(ModelAndView model, @PathVariable("customerId") int customerId) {
        LOGGER.info("Method to remove customer was called");
        customerService.removeCustomer(customerId);
        model.setViewName("remove-data");
        LOGGER.info("Successfully redirect to the jsp page");
        return model;
    }

}
