package com.cafe.x;


import org.junit.jupiter.api.Test;
import static com.cafe.x.Cafe.MenuItem.*;
import java.math.BigDecimal;

public class CafeTest {


    @Test
    public void Given_OneCola_Then_CustomerPay50p() {

        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue(COLA);
        assert totalCost.equals(new BigDecimal("0.50"));
    }

    @Test
    public void Given_OneCoffee_Then_CustomerPay1pound() {
        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue(COFFEE);
        assert totalCost.equals(new BigDecimal("1.00"));
    }

    @Test
    public void Given_OneCheeseSandwich_Then_CustomerPay2pounds() {
        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue(CHEESE_SANDWICH);
        assert totalCost.equals(new BigDecimal("2.00"));
    }

    @Test
    public void Given_OneColaOneCoffee_Then_CustomerPay1pound50pence(){
        Cafe cafe  = new Cafe();
        BigDecimal totalCost = cafe.purchaseValue(COFFEE,COLA);
        assert totalCost.equals(new BigDecimal("1.50"));
    }
}
