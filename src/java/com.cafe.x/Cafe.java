package com.cafe.x;
import java.math.BigDecimal;


public class Cafe {

    public BigDecimal purchaseValue(String menuItem) {
        if(menuItem.equalsIgnoreCase("cola")) {
            return new BigDecimal("0.50");
        } else if (menuItem.equalsIgnoreCase("Cheese Sandwich")) {
            return new BigDecimal("2.00");
        } else {
            return new BigDecimal("1.00");
        }
    }
}
