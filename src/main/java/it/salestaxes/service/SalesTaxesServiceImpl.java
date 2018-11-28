package it.salestaxes.service;

import it.salestaxes.Item;
import it.salestaxes.ItemType;
import it.salestaxes.decorators.BasicSalesTaxDecorator;
import it.salestaxes.decorators.ImportSalesTaxDecorator;

import java.util.ArrayList;
import java.util.List;

public class SalesTaxesServiceImpl implements SalesTaxesService {

    public List<Item> applySalesTaxesOnItem(List<Item> items) {
        List<Item> taxedItems = null;

        if (items != null) {
            taxedItems = new ArrayList<>();
            for (Item item : items) {
                if (item.isImported()) {
                    item = new ImportSalesTaxDecorator(item);
                }
                if (!isItemExempt(item)) {
                    item = new BasicSalesTaxDecorator(item);
                }
                taxedItems.add(item);
            }
        }
        return taxedItems;
    }

    private boolean isItemExempt(Item item) {
        return item.getType().equals(ItemType.BOOK) || item.getType().equals(ItemType.FOOD) || item.getType().equals(ItemType.MEDICAL);
    }

}
