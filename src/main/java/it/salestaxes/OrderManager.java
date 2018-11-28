package it.salestaxes;

import freemarker.template.TemplateException;
import it.salestaxes.service.SalesTaxesService;
import it.salestaxes.service.SalesTaxesServiceImpl;
import it.salestaxes.utils.NumberUtils;
import it.salestaxes.utils.TemplateProcessor;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public class OrderManager {

    public Order placeOrderAndPrintReceipt(Cart cart) throws IOException, TemplateException {

        SalesTaxesService salesTaxesService = new SalesTaxesServiceImpl();
        List<Item> taxedItems = salesTaxesService.applySalesTaxesOnItem(cart.getItems());

        Order order = new Order();
        order.setItems(taxedItems);

        setTotalValuesOnOrder(taxedItems, order);

        printReceipt(order);

        return order;

    }

    private void setTotalValuesOnOrder(List<Item> taxedItems, Order order) {

        BigDecimal totalAmount = taxedItems.stream().map(Item::getTotalAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal totalShelfPrice = taxedItems.stream().map(Item::getShelfPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
        BigDecimal salesTaxes = totalAmount.subtract(totalShelfPrice);

        totalAmount = NumberUtils.roundTwoDecimalPlaces(totalAmount);
        salesTaxes = NumberUtils.roundTwoDecimalPlaces(salesTaxes);

        order.setTotalAmount(totalAmount);
        order.setSalesTaxes(salesTaxes);
    }

    private void printReceipt(Order order) throws IOException, TemplateException {
        System.out.println(TemplateProcessor.processReceiptTemplate(order));
    }

}
