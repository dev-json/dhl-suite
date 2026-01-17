package de.dhlsuite.controller;

import de.dhlsuite.data.DHLOrdersRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontendController {

    @GetMapping("/orders/new")

    public String newOrderForm(Model model) {
        model.addAttribute("order", new DHLOrdersRequest());
        return "order-form";
    }
}

