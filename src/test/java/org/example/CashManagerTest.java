package org.example;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedHashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CashManagerTest {

    @Test
    void getCashTest() {
        CashManager cashManager = new CashManager(null);
        assertNull(cashManager.getCash());

        LinkedHashSet<String> wordSet = new LinkedHashSet<>(Arrays.asList("w1", "w2", "w3", "w4", "w5", "w6"));
        cashManager = new CashManager(wordSet);
        var cash = cashManager.getCash();
        assertEquals(6, cash.size());
    }

    @Test
    void addToCashWhenLessThenFiveElements() throws Exception {
        LinkedHashSet<String> wordSet = new LinkedHashSet<>(Arrays.asList("w1", "w2", "w3", "w4"));
        CashManager cashManager = new CashManager(wordSet);

        var cash = cashManager.getCash();
        assertEquals(4, cash.size());

        cashManager.addToCash("w5");
        cash = cashManager.getCash();
        assertEquals(5, cash.size());
        assertTrue(cash.contains("w5"));
    }

    @Test
    void addToCashWhenFiveElements() throws Exception {
        LinkedHashSet<String> wordSet = new LinkedHashSet<>(Arrays.asList("w1", "w2", "w3", "w4", "w5"));
        CashManager cashManager = new CashManager(wordSet);

        var cash = cashManager.getCash();
        assertEquals(5, cash.size());

        cashManager.addToCash("w6");
        cash = cashManager.getCash();
        assertEquals(5, cash.size());
        assertTrue(cash.contains("w2"));
        assertTrue(cash.contains("w3"));
        assertTrue(cash.contains("w4"));
        assertTrue(cash.contains("w5"));
        assertTrue(cash.contains("w6"));
    }

    @Test
    void addToCashWhenMoreThenFiveElements() {
        LinkedHashSet<String> wordSet = new LinkedHashSet<>(Arrays.asList("w1", "w2", "w3", "w4", "w5", "w6"));
        CashManager cashManager = new CashManager(wordSet);

        var cash = cashManager.getCash();
        assertEquals(6, cash.size());

        assertThrows(Exception.class, () -> cashManager.addToCash("w7"));
        assertFalse(cash.contains("w7"));
    }

    @Test
    void addToCashWhenNull() throws Exception {
        CashManager cashManager = new CashManager(null);

        var cash = cashManager.getCash();
        assertNull(cash);

        cashManager.addToCash("w1");
        cash = cashManager.getCash();
        assertEquals(1, cash.size());
        assertTrue(cash.contains("w1"));
    }
}