package de.dhlsuite.data;

import lombok.Data;

import java.util.List;

@Data
public class DHLOrdersRequest {
    //private String profile = "STANDARD_GRUPPENPROFIL";
    private List<DHLShipment> shipments;
}

