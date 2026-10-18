package com.base.faker;

import net.datafaker.Faker;

public class TestUserFactory {
    //используем статичные методы для фабрик. это класс-помощник, он не завязывается на состояние
    private final static Faker faker = new Faker();

    //заполняем данные экземпляра класса TestUser
    //фабрика возвращает готовый объект TestUser с рандомными полями и дальше для теста можно сбилдить этот объект, либо подкорректировать
    //это метод вернет НЕ сбилденный объект, т.к. нет вызова .build, это нужно будет сделать в тесте
    public static TestUser.TestUserBuilder newUser() {
        return TestUser.builder()
                .email(faker.internet().emailAddress())
                .password(faker.credentials().password(8, 16))
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName());
    }
}
