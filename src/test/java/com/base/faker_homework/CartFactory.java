package com.base.faker_homework;
import io.qameta.allure.Step;
import net.datafaker.Faker;

public class CartFactory {
    private static final Faker FAKER = new Faker();

    @Step("Создаем корзину с количеством {size}")
    static Cart newCart(int size) {
        Cart cart = Cart.builder()
                .userId(FAKER.random().nextLong(0,50))
                .build();

        for (int i = 0; i < size; i++) {
            cart.addItem(randomItem());
        }
        return cart;
    }

    private static Cart.Item randomItem() {
        return Cart.Item.builder()
                .dish(FAKER.food().dish())
                .quantity(FAKER.number().numberBetween(1, 5))
                .price(FAKER.number().randomDouble(2, 100, 1000))
                .build();
    }
}
