package com.cafe.x;
import java.math.BigDecimal;

import static com.cafe.x.Cafe.MenuItem.CHEESE_SANDWICH;
import static com.cafe.x.Cafe.MenuItem.COFFEE;
import static com.cafe.x.Cafe.MenuItem.COLA;


public class Cafe {

    public enum MenuItem {
        COLA("cola"),
        CHEESE_SANDWICH("Cheese Sandwich"),
        COFFEE("Coffee");

        private String name;
        MenuItem(String name) {
            this.name=name;
        }
    };

    public BigDecimal purchaseValue(MenuItem menuItem) {
        switch(menuItem) {
            case CHEESE_SANDWICH:
                return new BigDecimal("2.00");
            case COFFEE:
                return new BigDecimal("1.00");
            case COLA:
                return new BigDecimal("0.50");
            default:
                return new BigDecimal("0.00");
        }
    }
}
