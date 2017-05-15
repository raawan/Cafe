package com.cafe.x;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class CafeTest {


    @Test
    public void Given_OneCola_Then_CustomerPay50p() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue("Cola");
        assert totalCost == new BigDecimal("0.50");
    }
}
