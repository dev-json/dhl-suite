package de.dhlsuite.data;

import lombok.Data;

@Data
public class DHLWeight {

    private String uom;
    private int value;

    public void map()
    {
        this.uom = this.uom.toLowerCase();
    }
}
