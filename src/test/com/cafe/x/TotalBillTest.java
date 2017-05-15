package com.cafe.x;


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.cafe.x.Bill.MenuItem.*;

public class TotalBillTest {

    @Test
    public void Given_ColaCoffeeSteakSandwich_then_CustomerPay6PoundsAnd90PenceAsServiceCharge(){
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COFFEE,STEAK_SANDWICH));
        assert totalCost.equals(new BigDecimal("6.90"));
    }

    @Test
    public void Given_ColaCoffeeCheeseSandwich_then_CustomerPay3Pounds50penceAnd20PenceAsServiceCharge(){
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COFFEE,CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("3.70"));
    }

    @Test
    public void Given_TwoCola_then_CustomerPay1pound() {
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COLA,COLA));
        assert totalCost.equals(new BigDecimal("1.00"));
    }

    @Test
    public void Given_OneColaOneCoffee_Then_CustomerPay1pound50pence(){
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(COFFEE,COLA));
        assert totalCost.equals(new BigDecimal("1.50"));
    }

    @Test
    public void Given_OneCheeseSandwich_Then_CustomerPay2poundsAnd20PenceServiceCharge() {
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchasedItems(CHEESE_SANDWICH));
        assert totalCost.equals(new BigDecimal("2.20"));
    }

    @Test
    public void Given_23SteakSandwiches_Then_CustomerPay_123poundsAnd50Pence() {
        Bill bill = new Bill();
        BigDecimal totalCost = bill.calculateBill(purchased23HotSandwichesItems(STEAK_SANDWICH));
        assert totalCost.equals(new BigDecimal("123.50"));
    }

    private List<Bill.MenuItem> purchased23HotSandwichesItems(Bill.MenuItem steakSandwich) {
        List<Bill.MenuItem> steakSandwiches = new ArrayList<>();
        for (int i =0;i<23;i++) {
            steakSandwiches.add(Bill.MenuItem.STEAK_SANDWICH);
        }
        return steakSandwiches;
    }

    private List<Bill.MenuItem> purchasedItems(Bill.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
