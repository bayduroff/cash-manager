package org.example;

public class Main {
    public static void main(String[] args) {
        CashManager cashManager = new CashManager();

        //добавление 5 элементов
        cashManager.addToCash("w1");
        cashManager.addToCash("w2");
        cashManager.addToCash("w3");
        cashManager.addToCash("w4");
        cashManager.addToCash("w5");
        var cash = cashManager.getCash();

        //добавление 6-го
        cashManager.addToCash("w6");
        cash = cashManager.getCash();

        //добавление 7-го
        cashManager.addToCash("w7");
        cash = cashManager.getCash();
    }
}