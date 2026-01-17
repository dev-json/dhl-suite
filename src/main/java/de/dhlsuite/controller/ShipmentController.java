package de.dhlsuite.controller;

import de.dhlsuite.data.DHLValueAddedService;
import de.dhlsuite.data.response.DHLOrderResponse;
import de.dhlsuite.data.DHLOrdersRequest;
import de.dhlsuite.service.DHLOrderService;
import de.dhlsuite.service.DHLServiceMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class ShipmentController {

    private final DHLOrderService orderService;
    private final DHLServiceMapper serviceMapper;

    public ShipmentController(
            DHLOrderService orderService,
            DHLServiceMapper serviceMapper
    ) {
        this.orderService = orderService;
        this.serviceMapper = serviceMapper;
    }

    @PostMapping
    public DHLOrderResponse createOrder(@RequestBody DHLOrdersRequest request) {
        request.getShipments().forEach(dhlShipment -> {
            dhlShipment.setProduct(serviceMapper.mapProductType(dhlShipment.getProduct()));
            dhlShipment.getDetails().getDim().map();
            dhlShipment.getDetails().getWeight().map();
        });
        return orderService.createOrder(request);
    }
}
