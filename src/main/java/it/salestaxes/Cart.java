package it.salestaxes;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        items.add(item);
    }
}
