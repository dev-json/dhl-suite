package de.dhlsuite.data;

import lombok.Data;

@Data
public class DHLParty {
    private String name1;
    private String addressStreet;
    private String postalCode;
    private String city;
    private String country;
    private String email;
    private String phone;
}

