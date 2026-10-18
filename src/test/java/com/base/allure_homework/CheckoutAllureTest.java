package com.base.allure_homework;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Заказы")
@Feature("Оформление заказа")
public class CheckoutAllureTest {
    @Test
    @Story("Процесс обработки статусов заказов")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Успешное оформление заказа")
    @Description("Авторизация, создание и оплата заказа, проверка статуса заказа")
    void successfulCheckoutFlow() {
        loginAs("test@test.com", "12345");
        createOrder(2, 1);
        payByCard(123, 5678900);
        fetchStatus(123);
        assertStatus("NEW", "NEW");
    }

    @Step("Логинимся как {0}")
    void loginAs(String email, String password) {
        // TODO (заглушка)
    }

    @Step("Создаем заказ по рецепту {0} с количеством {1}")
    void createOrder(int recipeId, int qty) {
        // TODO (заглушка)
    }

    @Step("Вызываем метод оплаты картой, номер заказа {0}")
    void payByCard(int orderId, int cardNumber) {
        // TODO (заглушка)
    }

    @Step("Получаем статус заказа {0}")
    void fetchStatus(int orderId) {
        // TODO (заглушка)
    }

    @Step("Сравниваем актуальный статус {0} с ожидаемым {1}")
    void assertStatus(String actual, String expected) {
        // TODO (заглушка)
    }
}




