package ua.spring.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.service.Customable;
import ua.spring.app.service.Orderable;
import ua.spring.app.service.Showable;

@Controller
public class UpdateController {

    private static final Logger LOGGER = Logger.getLogger(UpdateController.class);

    @Autowired
    private Customable customerService;

    @Autowired
    private Orderable orderService;

    @Autowired
    private Showable displayService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showCustomerEditForm/{customerId}")
    public ModelAndView getCustomerEditForm(@PathVariable("customerId") int customerId,
                                      ModelAndView modelAndView) {
        modelAndView.addObject("customer", customerService.findById(customerId));
        modelAndView.setViewName("edit-data");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/updateCustomer")
    public ModelAndView updateCustomer(ModelAndView modelAndView,
                                       @RequestParam(value = "customerId", required = false) Integer customerId,
                                       @RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "password", required = false) String password) {
        LOGGER.info("Method to create new customer was called");
        customerService.updateCustomerData(customerId, name, password);
        modelAndView.addObject("infoMessage", "new customer");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showFlightTicketEditForm/{ticketId}")
    public ModelAndView getFlightTicketEditForm(ModelAndView modelAndView, @PathVariable("ticketId") int ticketId) {
        modelAndView.setViewName("editFlightTicket");
        modelAndView.addObject("flights", displayService.getFlightInfo());
        modelAndView.addObject("ticket", customerService.getFlightTicketById(ticketId));
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/updateFlightTicket")
    public ModelAndView updateFlightTicket(ModelAndView modelAndView,
                                           @RequestParam(value = "ticketId", required = false) Integer ticketId,
                                           @RequestParam(value = "number", required = false) String number,
                                           @RequestParam(value = "flightId", required = false) int flightId,
                                           @RequestParam(value = "text", required = false) String text,
                                           @RequestParam(value = "startDate", required = false) String startDate,
                                           @RequestParam(value = "endDate", required = false) String endDate,
                                           @RequestParam(value = "price", required = false) Double price) {
        LOGGER.info("Method to edit existed ticket was called");
        orderService.editFlightTicket(ticketId, number, flightId, text, startDate, endDate, price);
        modelAndView.addObject("infoMessage", "new ticket");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

}
