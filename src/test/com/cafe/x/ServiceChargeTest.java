package com.cafe.x;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.cafe.x.Cafe.MenuItem.CHEESE_SANDWICH;

/**
 * Created by minal on 5/15/17.
 */
public class ServiceChargeTest {

    @Test
    public void Given_CheeseSandwich_ServiceCharge20pence() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.getServiceCharge(purchasedItems(CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("0.20"));
    }

    public List<Cafe.MenuItem> purchasedItems(Cafe.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
