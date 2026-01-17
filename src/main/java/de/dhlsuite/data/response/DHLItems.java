package de.dhlsuite.data.response;

import lombok.Data;

@Data
public class DHLItems {

    private String shipmentNo;
    private String shipmentRefNo;
    private String routingCode;

    private DHLLabel label;

}
