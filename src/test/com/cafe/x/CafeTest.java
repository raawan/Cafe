package com.cafe.x;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CafeTest {


    @Test
    public void Given_OneCola_Then_CustomerPay50p() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue("Cola");
        assert totalCost.equals(new BigDecimal("0.50"));
    }

    @Test
    public void Given_OneCoffee_Then_CustomerPay1pound() {
        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue("Coffee");
        assert totalCost.equals(new BigDecimal("1.00"));
    }
}
