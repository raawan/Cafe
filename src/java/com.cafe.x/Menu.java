package com.cafe.x;

import java.math.BigDecimal;

public final class Menu {

    public enum MenuItem {
        COLA("cola",new BigDecimal("0.50")),
        CHEESE_SANDWICH("Cheese Sandwich",new BigDecimal("2.00")),
        COFFEE("Coffee",new BigDecimal("1.00")),
        STEAK_SANDWICH("Steak Sandwich",new BigDecimal("4.50"));

        private String name;
        private BigDecimal price;

        MenuItem(String name,BigDecimal price) {
            this.name=name;
            this.price=price;
        }

        public BigDecimal getPrice() {
            return price;
        }

    };
}
