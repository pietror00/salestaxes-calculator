package it.salestaxes;

import java.math.BigDecimal;


public interface Item {

    String getName();

    ItemType getType();

    boolean isImported();

    BigDecimal getShelfPrice();

    BigDecimal getTotalAmount();
}
