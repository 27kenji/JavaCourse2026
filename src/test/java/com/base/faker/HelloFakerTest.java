package com.base.faker;

import net.datafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class HelloFakerTest {
    //делаем переменную статичной для того, чтобы тест каждый раз не инициализировал ее повторно
    //указываем локализацию
    static final Faker faker = new Faker(new Locale("ru"));

    @Test
    public void test1() {
        //используем готовые категории, их много разных
        faker.address().cityName();
        //генерация рандомных чисел
        faker.random().nextInt(50, 142);
        faker.number().numberBetween(1, 5);
    }

    @Test
    //при билде меняем пароль
    public void test2() {
        TestUser build = TestUserFactory.newUser().password("1234").build();

    }

}
