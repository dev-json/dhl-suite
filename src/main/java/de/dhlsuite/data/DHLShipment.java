package de.dhlsuite.data;

import lombok.Data;

import java.util.List;

@Data
public class DHLShipment {
    private String refNo;
    private String billingNumber;
    private String product;
    private DHLParty shipper;
    private DHLParty consignee;
    private DHLDetails details;

    //private DHLValueAddedService services;
}

