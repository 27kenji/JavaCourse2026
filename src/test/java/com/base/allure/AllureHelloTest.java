package com.base.allure;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AllureHelloTest {

    @Test
    public void test1() {
        loginAs("test@test.ru");
        int i = placeOrder(4, 2);
        assertThat(i).isGreaterThan(100);

    }

    //@Step указываем только для методов с дефствиями, НЕ для шагов внутри теста
    //указываем название переменной или индекс в {}
    @Step("Авторизация под {0}")
    public void loginAs(String email) {
        //
    }

    @Step("Создаем заказ с рецептом {0} и количестом {1}")
    public int placeOrder(int recieptId, int quantity) {
        return 10;
    }

    //открыть отчет в бразуере можно через папку build -> reports -> allureReport -> index.html
    //Команда allure serve используется для быстрого просмотра отчета о тестировании Allure. Она генерирует HTML-отчет во временной директории,
    // запускает локальный веб-сервер и автоматически открывает страницу отчета в браузере по умолчанию

    //скопировать стектрейс ошибки из allure, в idea открыть вклдаку Code -> Analyze Stack Trace, в консоли пояится информация об ошибке со ссылками на строки кода

    //перед генерацией нового отчета нужно УДАЛИТЬ папку reports
    //генерировать отчет можно через задачи gradle -> verification -> allureReport
}
