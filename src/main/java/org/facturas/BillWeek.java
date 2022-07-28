package org.facturas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BillWeek {
    private String company;
    private Double value;
}
