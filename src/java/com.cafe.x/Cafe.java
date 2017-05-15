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
        COFFEE("Coffee",new BigDecimal("1.00")),
        STEAK_SANDWICH("Steak Sandwich",new BigDecimal("4.50"));

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

    public BigDecimal purchaseValue(List<MenuItem> menuItems) {

        return menuItems.stream().map(menuItem -> menuItem.getPrice()).
                reduce((price1, price2) -> price1.add(price2)).orElse(new BigDecimal("0.00"));
    }

    public BigDecimal getServiceCharge(List<MenuItem> menuItems) {
        BigDecimal serviceCharge = new BigDecimal("0.00") ;
        for(MenuItem menuItem : menuItems) {
            BigDecimal itemPriceInPennnies = menuItem.getPrice().multiply(BigDecimal.valueOf(100));
            if(menuItem.equals(MenuItem.CHEESE_SANDWICH)) {
                itemPriceInPennnies =  itemPriceInPennnies.multiply(new BigDecimal("0.1"));
            } else if(menuItem.equals(MenuItem.STEAK_SANDWICH))  {
                itemPriceInPennnies = itemPriceInPennnies.multiply(new BigDecimal("0.2"));
            }
            serviceCharge = serviceCharge.add(itemPriceInPennnies);
        }
        return serviceCharge.divide(BigDecimal.valueOf(100)).setScale(2);
    }
}
