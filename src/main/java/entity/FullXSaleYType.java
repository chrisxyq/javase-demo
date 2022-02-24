package entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FullXSaleYType {
    BigDecimal X;
    BigDecimal Y;

    public FullXSaleYType(BigDecimal x, BigDecimal y) {
        X = x;
        Y = y;
    }

    public FullXSaleYType() {
    }
}
