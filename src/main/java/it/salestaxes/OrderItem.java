package it.salestaxes;

import java.math.BigDecimal;

public class OrderItem implements Item {

    private String name;

    private ItemType type;

    private boolean isImported;

    private BigDecimal shelfPrice;

    public OrderItem(String name, ItemType type, boolean isImported, BigDecimal shelfPrice) {
        this.name = name;
        this.type = type;
        this.isImported = isImported;
        this.shelfPrice = shelfPrice;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getShelfPrice() {
        return this.shelfPrice;
    }

    public boolean isImported() {
        return this.isImported;
    }

    public ItemType getType() {
        return this.type;
    }

    public BigDecimal getTotalAmount() {
        return shelfPrice;
    }

}