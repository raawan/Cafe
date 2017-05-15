package com.cafe.x;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.cafe.x.Cafe.MenuItem.CHEESE_SANDWICH;
import static com.cafe.x.Cafe.MenuItem.COFFEE;
import static com.cafe.x.Cafe.MenuItem.COLA;


public class Cafe {


    public enum MenuItem {
        COLA("cola",new BigDecimal("0.50")),
        CHEESE_SANDWICH("Cheese Sandwich",new BigDecimal("2.00")),
        COFFEE("Coffee",new BigDecimal("1.00"));

        private String name;

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        private BigDecimal price;
        MenuItem(String name,BigDecimal price) {
            this.name=name;
            this.price=price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    };

    public BigDecimal purchaseValue(MenuItem... menuItems) {

        return Arrays.stream(menuItems).map(menuItem -> menuItem.getPrice()).
                reduce((price1, price2) -> price1.add(price2)).orElse(new BigDecimal("0.00"));
    }
}
