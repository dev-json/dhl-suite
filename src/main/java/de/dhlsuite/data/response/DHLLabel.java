package de.dhlsuite.data.response;

import lombok.Data;

@Data
public class DHLLabel {

    private String b64;
    private String fileFormat;
    private String printFormat;

}
