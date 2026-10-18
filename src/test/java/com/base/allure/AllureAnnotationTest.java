package com.base.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@Epic("Заказы")
@Feature("Создание заказа")
public class AllureAnnotationTest {

    @Test
    @Story("Покупатель создает заказ из меню")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Создание валидного заказа возвращает 201") //аннотация из JUnit
    @Description("""
            Гость выбирает рецепт, отправляет запрос
            бэкенд вощвращает 201 и id нового заказа
            """
    )
    public void test1() {
        int code = 201;
        assertThat(code).isEqualTo(201);

    }

}
