package com.cafe.x;

import java.math.BigDecimal;
import java.util.List;


public class Bill {

    private static final String TWENTY_PERCENT = "0.2";
    private static final String TEN_PERCENT = "0.1";
    private static final String TWENTY_POUNDS = "2000";
    private static final int TWO_DECIMAL_POINTS = 2;
    private static int MONEY_CONV_FACTOR = 100;

    public BigDecimal calculateBill(List<Menu.MenuItem> menuItems) {

        BigDecimal totalCost = purchaseValue(menuItems);
        return totalCost.add(getServiceCharge(menuItems));
    }

    private BigDecimal purchaseValue(List<Menu.MenuItem> menuItems) {

        return menuItems.stream().
                map(menuItem -> menuItem.getPrice()).
                reduce((price1, price2) -> price1.add(price2)).
                orElse(new BigDecimal("0.00"));
    }

    private BigDecimal getServiceCharge(List<Menu.MenuItem> menuItems) {
        BigDecimal serviceCharge = new BigDecimal("0.00");
        for (Menu.MenuItem menuItem : menuItems) {
            serviceCharge = serviceCharge.add(foodItemServiceCharge(menuItem));
        }
        return finalServiceCharge(serviceCharge);
    }

    private BigDecimal finalServiceCharge(BigDecimal serviceCharge) {
        /*
        Max 20 pound tip
         */
        if (serviceCharge.compareTo(new BigDecimal(TWENTY_POUNDS)) > 0) {
            return new BigDecimal("20.00");
        }
        return convertInPoundAndPenceFormat(serviceCharge);
    }

    private BigDecimal foodItemServiceCharge(Menu.MenuItem menuItem) {
        /*
        For given data no need to distinguish between hot and cold food
         */
        BigDecimal itemPriceInPennies = convertInPennies(menuItem.getPrice());
        if (menuItem.equals(Menu.MenuItem.CHEESE_SANDWICH)) {
            return itemPriceInPennies.multiply(new BigDecimal(TEN_PERCENT));
        } else if (menuItem.equals(Menu.MenuItem.STEAK_SANDWICH)) {
            return itemPriceInPennies.multiply(new BigDecimal(TWENTY_PERCENT));
        }
        return new BigDecimal("0.00");
    }

    private BigDecimal convertInPennies(BigDecimal valueInPoundsAndPennyFormat) {
        return valueInPoundsAndPennyFormat.multiply(BigDecimal.valueOf(MONEY_CONV_FACTOR));
    }

    private BigDecimal convertInPoundAndPenceFormat(BigDecimal valueInPennies) {
        return valueInPennies.divide(BigDecimal.valueOf(MONEY_CONV_FACTOR)).setScale(TWO_DECIMAL_POINTS);
    }
}
