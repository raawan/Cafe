package com.cafe.x;

import java.math.BigDecimal;
import java.util.List;


public class Bill {

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

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    };

    public BigDecimal calculateBill(List<MenuItem> menuItems) {

        BigDecimal totalCost = purchaseValue(menuItems);
        return totalCost.add(getServiceCharge(menuItems));
    }

    public BigDecimal purchaseValue(List<MenuItem> menuItems) {

        return menuItems.stream().
                map(menuItem -> menuItem.getPrice()).
                reduce((price1, price2) -> price1.add(price2)).
                orElse(new BigDecimal("0.00"));
    }

    public BigDecimal getServiceCharge(List<MenuItem> menuItems) {
        BigDecimal serviceCharge = new BigDecimal("0.00") ;
        for(MenuItem menuItem : menuItems) {
            serviceCharge = serviceCharge.add(foodItemServiceCharge(menuItem));
        }
        return finalServiceCharge(serviceCharge);
    }

    private BigDecimal finalServiceCharge(BigDecimal serviceCharge) {
        /*
        Max 20 pound tip
         */
        if(serviceCharge.compareTo(new BigDecimal("2000"))>0) {
            return new BigDecimal("20.00");
        }
        return convertInPoundAndPenceFormat(serviceCharge);
    }

    private BigDecimal foodItemServiceCharge(MenuItem menuItem) {
        /*
        For given data no need to distinguish between hot and cold food
         */
        BigDecimal itemPriceInPennies = convertInPennies(menuItem.getPrice());
        if(menuItem.equals(MenuItem.CHEESE_SANDWICH)) {
            return  itemPriceInPennies.multiply(new BigDecimal("0.1"));
        } else if(menuItem.equals(MenuItem.STEAK_SANDWICH)) {
            return itemPriceInPennies.multiply(new BigDecimal("0.2"));
        }
        return new BigDecimal("0.00");
    }

    private BigDecimal convertInPennies(BigDecimal valueInPoundsAndPennyFormat) {
        return valueInPoundsAndPennyFormat.multiply(BigDecimal.valueOf(100));
    }

    private BigDecimal convertInPoundAndPenceFormat(BigDecimal valueInPennies) {
        return valueInPennies.divide(BigDecimal.valueOf(100)).setScale(2);
    }
}
