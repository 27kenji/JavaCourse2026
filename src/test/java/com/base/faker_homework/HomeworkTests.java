package com.base.faker_homework;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeworkTests {
    CartConfig config = ConfigFactory.create(CartConfig.class);

    @Test
    void configReturnsDefaults() {
        assertThat(config.defaultSize()).isEqualTo(3);
        assertThat(config.maxSize()).isEqualTo(20);
    }

    @Test
    void factoryCreatesCartOfDefaultSize() {
        Cart cart = CartFactory.newCart(config.defaultSize());

        assertThat(cart.getUserId()).isGreaterThanOrEqualTo(0);
        assertThat(cart.getItems()).hasSize(config.defaultSize());
        assertThat(cart.getItems()).allSatisfy(x -> {
            assertThat(x.getDish()).isNotBlank();
            assertThat(x.getQuantity()).isBetween(1,4);
            assertThat(x.getPrice()).isBetween(100.00, 1000.00);
        });
    }

    @Test
    void factoryRespectsExplicitSize() {
        Cart cart = CartFactory.newCart(7);
        assertThat(cart.getItems()).hasSize(7);
    }
}

