package com.base.faker_homework;

import org.aeonbits.owner.Config;

@Config.Sources({
        "system:properties",
        "system:env",
        "classpath:test.properties"
})
@Config.LoadPolicy(Config.LoadType.MERGE)
public interface CartConfig extends Config {

    @Key("cart.default.size")
    @DefaultValue("3")
    int defaultSize();

    @Key("cart.max.size")
    @DefaultValue("20")
    int maxSize();

}
