package com.base.faker_homework;
import lombok.Builder;
import lombok.Data;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Cart {
    private final long userId;
    @Builder.Default
    private final List<Item> items = new ArrayList<>();

    void addItem(Item item) {
        items.add(item);
    }

    @Data
    @Builder
    static class Item {
        private String dish;
        private int quantity;
        private double price;
    }
}
