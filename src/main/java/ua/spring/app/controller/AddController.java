package ua.spring.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.util.DateManager;
import ua.spring.app.service.Customable;
import ua.spring.app.service.Orderable;
import ua.spring.app.service.Showable;

import java.security.Principal;

@Controller
public class AddController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddController.class);

    private final Customable customerService;

    private final Showable displayService;

    private final Orderable orderService;

    public AddController(Customable customerService, Showable displayService, Orderable orderService) {
        this.customerService = customerService;
        this.displayService = displayService;
        this.orderService = orderService;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showCustomerForm")
    public ModelAndView getCustomerForm(ModelAndView modelAndView) {
        modelAndView.addObject("operation", "add");
        modelAndView.setViewName("addEditCustomer");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/addCustomer")
    public ModelAndView createCustomer(ModelAndView modelAndView,
                                       @RequestParam(value = "firstName", required = false) String firstName,
                                       @RequestParam(value = "surname", required = false) String surname,
                                       @RequestParam(value = "password", required = false) String password) {
        LOGGER.info("Method to create new customer was called");
        customerService.addCustomer(firstName + " " + surname, "{noop}" + password);
        modelAndView.addObject("infoMessage", "new customer");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showFlightTicketForm")
    public ModelAndView getTicketForm(ModelAndView modelAndView) {
        modelAndView.setViewName("addEditFlightTicket");
        modelAndView.addObject("flights", displayService.getFlightInfo());
        modelAndView.addObject("operation", "add");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/addFlightTicket")
    public ModelAndView createFlightTicket(ModelAndView modelAndView,
                                           @RequestParam(value = "number", required = false) String number,
                                           @RequestParam(value = "flightId", required = false) int flightId,
                                           @RequestParam(value = "text", required = false) String text,
                                           @RequestParam(value = "startDate", required = false) String startDate,
                                           @RequestParam(value = "endDate", required = false) String endDate,
                                           @RequestParam(value = "price", required = false) String price) {
        LOGGER.info("Method to create new flight ticket was called");
        orderService.addFlightTicket(number, flightId, text, startDate, endDate, price);
        modelAndView.addObject("infoMessage", "new ticket");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping(value = "/customers/showTicketBuyForm")
    public ModelAndView getTicketBuyForm(ModelAndView modelAndView) {
        modelAndView.addObject("tickets", customerService.listTicket());
        modelAndView.setViewName("buyTicket");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping(value = "/customers/buyTicket")
    public ModelAndView addBuyTicketToBasket(ModelAndView modelAndView,
                                             Principal principal,
                                             @RequestParam(value = "ticketPrice", required = false) String ticketPrice,
                                             @RequestParam(value = "discount", required = false) String discount,
                                             @RequestParam(value = "finalPrice", required = false) String finalPrice,
                                             @RequestParam(value = "id", required = false) Integer id) {
        LOGGER.info("Method to save, already bought flight ticket was called");
        String customerName = principal.getName();
        orderService.buyTicket(customerName, DateManager.getCurrentDate(), ticketPrice, discount, finalPrice, id);
        modelAndView.setViewName("customers");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }
}
