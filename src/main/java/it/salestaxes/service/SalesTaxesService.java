package it.salestaxes.service;

import it.salestaxes.Item;

import java.util.List;

public interface SalesTaxesService {

    List<Item> applySalesTaxesOnItem(List<Item> items);
}
