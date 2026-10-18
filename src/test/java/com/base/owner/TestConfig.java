package com.base.owner;
import org.aeonbits.owner.Config;

//с помощью библиотеки owner можно представить конфиг проекта в виде интерфейса, реализовать 1 раз и дальше с помощью статичных методов обращаться к типизированным значениям

//класс наследуется от интерфейса Config из библиотеки Owner
//через аннотацию перечисляем, откуда нужно читать значения
@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:test.properties"
})

//эта аннотация для того, чтобы значение конфига искалось по всем источникам
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface TestConfig extends Config {
    //релизуем методы интерфейса. Каждый метод — один параметр
    @Key("baseUrl")
    String baseUrl();

    @Key("isDocker")
    boolean isDocker();

    @Key("threadCount")
    int threadCount();

    @Key("browser")
    String browser();


}
