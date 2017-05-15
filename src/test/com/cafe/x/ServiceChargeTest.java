package com.cafe.x;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.cafe.x.Cafe.MenuItem.CHEESE_SANDWICH;
import static com.cafe.x.Cafe.MenuItem.STEAK_SANDWICH;

public class ServiceChargeTest {

    @Test
    public void Given_CheeseSandwich_ServiceCharge20pence() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.getServiceCharge(purchasedItems(CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("0.20"));
    }

    @Test
    public void Given_CheeseSandwichAndSteakSandwich_ServiceCharge1pound10pence() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.getServiceCharge(purchasedItems(CHEESE_SANDWICH,STEAK_SANDWICH));
        assert totalCost.equals(new BigDecimal("1.10"));
    }

    public List<Cafe.MenuItem> purchasedItems(Cafe.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
