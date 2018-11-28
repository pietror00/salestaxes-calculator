package it.salestaxes.decorators;

import it.salestaxes.Item;
import it.salestaxes.ItemType;

import java.math.BigDecimal;

public class ImportSalesTaxDecorator extends SalesTaxDecorator {

    private Item itemToDecorate;

    private final BigDecimal IMPORT_SALES_TAX_RATE = BigDecimal.valueOf(0.05);

    public ImportSalesTaxDecorator(Item item) {
        super(item);
        this.itemToDecorate = item;
    }

    @Override
    BigDecimal getTaxRate() {
        return this.IMPORT_SALES_TAX_RATE;
    }

    public String getName() {
        return itemToDecorate.getName();
    }

    public BigDecimal getShelfPrice() {
        return itemToDecorate.getShelfPrice();
    }

    public boolean isImported() {
        return itemToDecorate.isImported();
    }

    public ItemType getType() {
        return itemToDecorate.getType();
    }

}
