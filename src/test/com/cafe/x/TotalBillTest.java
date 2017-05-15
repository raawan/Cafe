package com.cafe.x;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import static com.cafe.x.Cafe.MenuItem.*;

public class TotalBillTest {

    @Test
    public void Given_ColaCoffeeSteakSandwich_then_CustomerPay6PoundsAnd90PenceAsServiceCharge(){
        Cafe bill = new Cafe();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COFFEE,STEAK_SANDWICH));
        assert totalCost.equals(new BigDecimal("6.90"));
    }

    @Test
    public void Given_ColaCoffeeCheeseSandwich_then_CustomerPay3Pounds50penceAnd20PenceAsServiceCharge(){
        Cafe bill = new Cafe();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COFFEE,CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("3.70"));
    }

    @Test
    public void Given_TwoCola_then_CustomerPay1pound() {
        Cafe bill = new Cafe();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COLA));
        assert totalCost.equals(new BigDecimal("1.00"));
    }

    @Test
    public void Given_OneColaOneCoffee_Then_CustomerPay1pound50pence(){
        Cafe bill = new Cafe();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COFFEE,COLA));
        assert totalCost.equals(new BigDecimal("1.50"));
    }

    @Test
    public void Given_OneCheeseSandwich_Then_CustomerPay2poundsAnd20PenceServiceCharge() {
        Cafe bill = new Cafe();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("2.20"));
    }

    public List<Cafe.MenuItem> purchasedItems(Cafe.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
