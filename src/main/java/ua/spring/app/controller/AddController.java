package ua.spring.app.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.util.DateManager;
import ua.spring.app.service.Customable;
import ua.spring.app.service.Orderable;
import ua.spring.app.service.Showable;

import java.security.Principal;

@Controller
public class AddController {

    private static final Logger LOGGER = Logger.getLogger(AddController.class);

    @Autowired
    private Customable customerService;

    @Autowired
    private Showable displayService;

    @Autowired
    private Orderable orderService;

    private DateManager dateManager;

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

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showFlightTicketForm")
    public ModelAndView getTicketForm(ModelAndView modelAndView) {
        modelAndView.setViewName("addFlightTicket");
        modelAndView.addObject("flights", displayService.getFlightInfo());
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/systems/addFlightTicket")
    public ModelAndView createFlightTicket(ModelAndView modelAndView,
                                           @RequestParam(value = "number", required = false) String number,
                                           @RequestParam(value = "flightId", required = false) int id,
                                           @RequestParam(value = "text", required = false) String text,
                                           @RequestParam(value = "startDate", required = false) String startDate,
                                           @RequestParam(value = "endDate", required = false) String endDate,
                                           @RequestParam(value = "price", required = false) Double price) {
        LOGGER.info("Method to create new flight ticket was called");
        orderService.addFlightTicket(number, id, text, startDate, endDate, price);
        modelAndView.addObject("infoMessage", "new ticket");
        modelAndView.setViewName("admins");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping(value = "/customers/showTicketBuyForm")
    public String getTicketBuyForm() {
        return "buyTicket";
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @PostMapping(value = "/customers/buyTicket")
    public ModelAndView addBuyTicketToBasket(ModelAndView modelAndView,
                                             Principal principal,
                                             @RequestParam(value = "ticketPrice", required = false) String ticketPrice,
                                             @RequestParam(value = "discount", required = false) String discount,
                                             @RequestParam(value = "finalPrice", required = false) String finalPrice
                                             ) {
        LOGGER.info("Method to save, already bought flight ticket was called");
        String customerName = principal.getName();
        orderService.buyTicket(customerName, new DateManager().getCurrentDate(), ticketPrice, discount, finalPrice);
        modelAndView.setViewName("customers");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }
}
