package com.cafe.x;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.cafe.x.Bill.MenuItem.*;

public class ServiceChargeTest {

    @Test
    public void Given_CheeseSandwich_ServiceCharge20pence() {

        Bill bill = new Bill();
        BigDecimal totalCost = bill.getServiceCharge(purchasedItems(CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("0.20"));
    }

    @Test
    public void Given_CheeseSandwichAndSteakSandwich_ServiceCharge1pound10pence() {

        Bill bill = new Bill();
        BigDecimal totalCost = bill.getServiceCharge(purchasedItems(CHEESE_SANDWICH,STEAK_SANDWICH));
        assert totalCost.equals(new BigDecimal("1.10"));
    }

    @Test
    public void Given_CoffeeAndCola_ServiceCharge0pence() {

        Bill bill = new Bill();
        BigDecimal totalCost = bill.purchaseValue(purchasedItems(COFFEE,COLA));
        assert totalCost.equals(new BigDecimal("1.50"));
    }

    public List<Bill.MenuItem> purchasedItems(Bill.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
