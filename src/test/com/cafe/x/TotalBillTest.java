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

    public List<Cafe.MenuItem> purchasedItems(Cafe.MenuItem... menuItems) {
        return Arrays.asList(menuItems);
    }
}
