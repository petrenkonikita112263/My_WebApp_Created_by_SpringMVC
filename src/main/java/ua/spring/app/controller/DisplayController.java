package ua.spring.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.spring.app.entity.Customer;
import ua.spring.app.service.Customable;
import ua.spring.app.service.Showable;

import java.security.Principal;

@Controller
public class DisplayController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisplayController.class);

    @Autowired
    private Showable displayService;

    @Autowired
    private Customable customerService;

    @GetMapping(value = "/showFlights")
    public ModelAndView getFlight(ModelAndView modelAndView) {
        LOGGER.info("Method to get flight's info was called");
        modelAndView.addObject("listOfFlight", displayService.getFlightInfo());
        modelAndView.setViewName("flight");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @GetMapping(value = "/showPlanes")
    public ModelAndView getPlane(ModelAndView modelAndView) {
        LOGGER.info("Method to get plane's name was called");
        modelAndView.addObject("listOfPlane", displayService.getPlaneInfo());
        modelAndView.setViewName("plane");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @GetMapping(value = "/showAirports")
    public ModelAndView getAirport(ModelAndView modelAndView) {
        LOGGER.info("Method to get airport's name was called");
        modelAndView.addObject("listOfAirport", displayService.getAirportInfo());
        modelAndView.setViewName("airport");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'CUSTOMER')")
    @GetMapping(value = "/showTicket")
    public ModelAndView getTickets(ModelAndView modelAndView) {
        LOGGER.info("Method to get tickets was called");
        modelAndView.addObject("listOfTicket", customerService.listTicket());
        modelAndView.setViewName("ticket");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping(value = "/customers/showCustomerOrder")
    public ModelAndView getCustomerOrder(ModelAndView modelAndView, Principal principal) {
        LOGGER.info("Method to get customer's orders was called");
        String username = principal.getName();
        modelAndView.addObject("customersOrders", customerService.getOwnOrderHistory(username));
        modelAndView.addObject("history", "customerOrder");
        modelAndView.setViewName("order");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('CUSTOMER')")
    @GetMapping(value = "/customers/showOrderTicket")
    public ModelAndView getOrderTicket(ModelAndView modelAndView, Principal principal) {
        LOGGER.info("Method to get ordered ticket was called");
        String username = principal.getName();
        modelAndView.addObject("orderedTickets", customerService.getOwnOrderTicketHistory(username));
        modelAndView.addObject("history", "customerOrderTicket");
        modelAndView.setViewName("order");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/systems/showCustomers")
    public ModelAndView getCustomers(ModelAndView modelAndView) {
        LOGGER.info("Method to get customers was called");
        modelAndView.addObject("customers", customerService.getCustomers());
        modelAndView.setViewName("customer-list");
        LOGGER.info("Successfully redirect to the jsp page");
        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/systems/customer/{id}", method = RequestMethod.GET)
    public String showCustomer(@PathVariable("id") int id, Model model) {
        LOGGER.info("showCustomer() id: " + id);
        Customer customer = customerService.findById(id);
        if (customer == null) {
            model.addAttribute("css", "danger");
            model.addAttribute("msg", "Customer not found");
        }
        model.addAttribute("customer", customer);
        return "customer-by-id";
    }

}
