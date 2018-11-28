package it.salestaxes.decorators;

import it.salestaxes.Item;
import it.salestaxes.utils.NumberUtils;

import java.math.BigDecimal;

public abstract class SalesTaxDecorator implements Item {

    private Item item;

    abstract BigDecimal getTaxRate();

    SalesTaxDecorator(Item item) {
        this.item = item;
    }

    public BigDecimal getTotalAmount() {

        BigDecimal taxValue = getTaxRate().multiply(this.item.getShelfPrice());

        taxValue = NumberUtils.roundToNearest5Cent(taxValue);

        return this.item.getTotalAmount().add(taxValue);
    }
}
