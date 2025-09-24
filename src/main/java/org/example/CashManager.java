package org.example;

import java.util.LinkedHashSet;

// кэширование в оперативной памяти
// ёмкость кэша 5 объектов
// если больше 5, будет перезаписывать кэш

// если есть, то возвращаем объект, если нет - то сохраняешь новую версию
// если кэша нет - создаётся новый и добавляется в него
public class CashManager {
    private LinkedHashSet<String> cash;

    public CashManager() {
    }

    public CashManager(LinkedHashSet<String> wordSet) {
        this.cash = wordSet;
    }

    public void addToCash(String word) throws Exception {
        if (cash == null) {
            cash = new LinkedHashSet<>();
        }
        //доп. условие на случай мониторинга существования в кэше
        //Но метод add сам проверяет существование элемента, работает без этого условия
        if (cash.contains(word)) {
            System.out.println("Element " + word + " already exists. Nothing changed");
            return;
        }
        var size = cash.size();
        if (size == 5) {
            var first = cash.stream().findFirst().orElseThrow();
            cash.remove(first);
            System.out.println(first + " removed from cash");
            cash.add(word);
            System.out.println(word + " added to cash");
        } else if (size > 5) {
            throw new Exception("Error: cash overflow: must be 5, actual - " + size);
        } else {
            cash.add(word);
            System.out.println(word + " added to cash");
        }
        System.out.println("cash size: " + cash.size());
    }

    public LinkedHashSet<String> getCash() {
        if (cash == null || cash.isEmpty()) {
            System.out.println("cash is empty");
        } else {
            System.out.println("cash elements: " + cash);
        }
        return cash;
    }

}
