package com.lambdas_streams;

import com.exceptions.OrderNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class Theory {
    public static void main(String[] args) {
        /*
        Лямбда — функция «на лету»,короткая функция в одну строку. Stream применяет ее к каждому элементу. Collect в конце собирает в список.
        Форма метода внутри интерфейса = форма твоей лямбды.

Как понять, что можно использовать лямбду:
Есть метод allMatch.
IDE (IntelliJ/Eclipse) подсвечивает параметр и подсказывает: «здесь можно поставить лямбду».
Ты наводишь курсор на allMatch → видишь Predicate<? super ELEMENT>.
Вспоминаешь: Predicate — функциональный интерфейс. Значит, лямбда подходит.
То есть не ты решаешь, где применить лямбду. Ты смотришь на сигнатуру метода и видишь, что автор API её там предусмотрел.

        Синтаксис: (аргументы) -> результат.
        Стрелка -> читается как «превращается в».
        Method reference — ещё короче: names.forEach(System.out::println), .map(Order::getTotal).
        Лямбда — это реализация функционального интерфейса. В основном используется в стримах.

        Есть 4 функциональных интерфейса, где может использоваться лямбда:
        Supplier<T>	() → T	ничего не берёт, отдаёт
        Consumer<T>	T → void	берёт, ничего не возвращает
        Predicate<T>	T → boolean	отвечает да/нет
        Function<T,R>	T → R	берёт одно, возвращает другое

        Stream — конвейер из трёх фаз:
        SOURCE — list.stream() — превращаем коллекцию в stream.
        ШАГИ — .filter() .map() .sorted() .distinct() .limit() — промежуточные, ленивые.
        ТЕРМИНАЛ — .toList() .count() .findFirst() .collect() — запуск.

        Восемь операций (методов) на старт (90% работы):
        filter - оставить только подходящие
        map - превратить каждый в новое значение
        sorted - отсортировать
        distinct - убрать дубли
        limit - оставить первые n
        count - сколько элементов (терминал)
        toList - собрать в List (терминал)
        findFirst - первый (терминал)

        Методы collect для финальной сборки в коллекцию: toList, Collectors.toMap, Collectors.joining (в строку)
         */

        //функциональный интерфейс Predicate - в реальной практике использоваться не будет
        //x здесь - это входящее значение с типом данных <String>
        //x.length() > 5 - это реализация метода test из интерфейса Predicate
        Predicate<String> isLong = x -> x.length() > 5;

        System.out.println(isLong.test("Hi"));
        System.out.println(isLong.test("Arigato"));

        //Функциональный интерфейс Function
        //строку преобразовали в число
        Function<String, Integer> length = x -> x.length();
        System.out.println(length.apply("Hello"));

        //создаем список для работы со стримом
        List<String> pizzas = List.of("Margarita", "Pepperoni", "Hawaii", "Carbonara");

        //работа со стримами
        //сначала обращаемся к коллекции pizzas, затем вызываем промежуточный метод стрима - filter (он в итоге вернет тоже стрим, и можно будет использовать
        // промежуточные методы стрима дальше до тех пор, пока не вызовем терминальный метод). На вход методу filter нужно передать Predicate - лямбду,
        // результатом которой будет true или false
        //после этого вызываем теминальный метод toList, который выведет отфильтрованный список,
        // результат работы стрима сохраняем в переменную moreThan7 (чтобы собрать новый список)
        List<String> moreThan7 = pizzas.stream()
                .filter(x -> x.length() > 7)
                .toList();
        System.out.println(moreThan7);

        //метод map исходный тип данных String превратит в int
        List<Integer> list = pizzas.stream()
                .map(x -> x.length())
                .toList();
        System.out.println(list);

        //Optional - это безопасное хранение ответа
        Optional<String> h = pizzas.stream()
                .filter(x -> x.startsWith("H"))
                .findFirst();
        System.out.println(h);
        //если в результате работы стрима не нашлось нужного значения, можно сохранить новое значение через orElseGet
        if (h.isEmpty()) {
            String s = h.orElseGet(() -> "Other pizza");
            System.out.println(s);
            h.orElseThrow(() -> new OrderNotFoundException(1));
            System.out.println(s);
        }

        //в качестве элементов списка созданы различные экземляры класса Order

        List<Order> orders = List.of(
                new Order(1L, "CREATED", 150.0, "Alice"),
                new Order(2L, "PAID", 320.99, "Bob"),
                new Order(3L, "CANCELLED", 89.76, "Alice"),
                new Order(4L, "PAID", 210.00, "Charlie"),
                new Order(5L, "PAID", 540.90, "Bob")
        );

        List<Order> paid = orders.stream()
                .filter(x -> x.getStatus().equals("PAID"))
                .toList();

        System.out.println(paid);

        //когда нужно вывести только имена, а не элемент списка полностью
        List<String> cancelled = orders.stream()
                .filter(x -> x.getStatus().equals("CANCELLED"))
                //преобразуем один тип данных в другой - список в строку, далее значение будет сохранено в переменную cancelled с типом <String>
                .map(x -> x.getCustomer())
                .toList();
        System.out.println(cancelled);

    }
}
