package com.teamtreehouse.vending;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kimmiekim on 2016-12-28.
 */
public class VendingMachineTest {
    private VendingMachine machine;

    public class NotifierSub implements Notifier{

        @Override
        public void onSale(Item item) {
            return;
        }
    }

    @Before
    public void setUp() throws Exception {
        Notifier notifier = new NotifierSub();
        machine = new VendingMachine(notifier, 10, 10, 10);
        machine.restock("A1", "twinkies", 10, 30, 75);
    }

    @Test
    public void vendingWhenStockedReturnsItem() throws Exception {
        machine.addMoney(75);
        Item item = machine.vend("A1");

        assertEquals("twinkies", item.getName());
    }

    @Test
    public void whenVendingSuccessfulIncrementsSales() throws Exception {
        machine.addMoney(75);
        Item item = machine.vend("A1");

        assertEquals(75, machine.getRunningSalesTotal());
    }
}