package ua.spring.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.service.Customable;
import ua.spring.app.service.Orderable;

@Controller
public class RemoveController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoveController.class);

    private final Customable customerService;

    private final Orderable orderService;

    public RemoveController(Customable customerService, Orderable orderService) {
        this.customerService = customerService;
        this.orderService = orderService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/systems/removeCustomer/{customerId}")
    public ModelAndView delete(ModelAndView model, @PathVariable("customerId") int customerId) {
        LOGGER.info("Method to remove customer was called");
        customerService.removeCustomer(customerId);
        model.setViewName("remove-data");
        LOGGER.info("Successfully redirect to the jsp page");
        return model;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/systems/removeFlightTicket/{ticketId}")
    public ModelAndView deleteTicket(ModelAndView model, @PathVariable("ticketId") int ticketId) {
        LOGGER.info("Method to remove ticket was called");
        orderService.removeFlightTicket(ticketId);
        model.setViewName("remove-data");
        LOGGER.info("Successfully redirect to the jsp page");
        return model;
    }

}
