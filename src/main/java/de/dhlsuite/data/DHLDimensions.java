package de.dhlsuite.data;

import lombok.Data;

@Data
public class DHLDimensions {
    private String uom;
    private int length;
    private int width;
    private int height;

    public void map()
    {
        this.uom = this.uom.toLowerCase();
    }
}

