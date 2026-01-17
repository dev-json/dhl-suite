package de.dhlsuite.data.response;

import lombok.Data;

import java.util.List;

@Data
public class DHLOrderResponse {

    private List<DHLItems> items;
}
