package org.example;

import java.util.LinkedHashSet;
import java.util.logging.Logger;

// кэширование в оперативной памяти
// ёмкость кэша 5 объектов
// если больше 5, будет перезаписывать кэш

// если есть, то возвращаем объект, если нет - то сохраняешь новую версию
public class CashManager {
    private final LinkedHashSet<String> cash = new LinkedHashSet<>();

    public void addToCash(String word) {
        if (cash.size() == 5) {
            var first = cash.stream().findFirst().orElseThrow();
            cash.remove(first);
            System.out.println(first + " removed from cash");
            cash.add(word);
            System.out.println(word + " added to cash");
        } else {
            cash.add(word);
            System.out.println(word + " added to cash");
        }
        //аналог логгера для наглядности
        System.out.println("cash size: " + cash.size());
    }

    public LinkedHashSet<String> getCash(){
        if (cash.isEmpty()){
            System.out.println("cash is empty");
        } else {
            System.out.println("cash elements: " + cash);
        }
        return cash;
    }

}
