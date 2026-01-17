package de.dhlsuite.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DHLValueAddedService {
    private boolean goGreenPlus;
    private boolean bulkyGoods;
}
