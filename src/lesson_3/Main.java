package lesson_3;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String[] words = {"игрушка","играть","машинка","играть","робот","машинка","кукла","игрушка","мальчик","робот","девочка","кукла","играть","машинка"};
        HashMap<String, Integer> word = new HashMap<>();
        for(String x : words){
            word.put(x, word.getOrDefault(x,0)+1);
        }
        System.out.println("\n"+word);
        System.out.println("\n");

        Phonebook book = new Phonebook();
        book.addContact("Пупкин","525251");
        book.addContact("Иванов", "134584");
        book.addContact("Петров", "784513");
        book.addContact("Васьков", "154864");
        book.addContact("Иванов", "135489");
        book.addContact("Петров", "684153");
        book.addContact("Кукушкин", "846841");
        book.addContact("Избушкина", "446541");
        book.addContact("Пупкин", "213546");
        book.addContact("Иванов", "864135");
        book.addContact("Кукушкина", "153564");

        book.getContact("Пупкин");
        book.getContact("Иванов");
        book.getContact("Петров");
        book.getContact("Кукушкин");

    }
}
