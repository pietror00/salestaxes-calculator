package it.salestaxes;

import freemarker.template.TemplateException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.math.BigDecimal;

public class OrderManagerTest {

    private OrderManager orderManager;

    @Before
    public void init() {
        orderManager = new OrderManager();
    }

    @Test
    public void placeOrderCase1() throws IOException, TemplateException {

        BigDecimal expTotalAmount = BigDecimal.valueOf(29.83);
        BigDecimal expSalesTaxes = BigDecimal.valueOf(1.50);

        Cart cart = new Cart();
        cart.addItem(new OrderItem("1 book", ItemType.BOOK, false, BigDecimal.valueOf((12.49))));
        cart.addItem(new OrderItem("1 music CD", ItemType.OTHER, false, BigDecimal.valueOf((14.99))));
        cart.addItem(new OrderItem("1 chocolate bar", ItemType.FOOD, false, BigDecimal.valueOf((0.85))));

        Order order = orderManager.placeOrderAndPrintReceipt(cart);

        assertEqualsOrderTotals(expTotalAmount, expSalesTaxes, order);
    }

    @Test
    public void placeOrderCase2() throws IOException, TemplateException {

        BigDecimal expTotalAmount = BigDecimal.valueOf(65.15);
        BigDecimal expSalesTaxes = BigDecimal.valueOf(7.65);

        Cart cart = new Cart();
        cart.addItem(new OrderItem("1 imported box of chocolates", ItemType.FOOD, true, new BigDecimal(10.00)));
        cart.addItem(new OrderItem("1 imported bottle of perfume", ItemType.OTHER, true, new BigDecimal(47.50)));

        Order order = orderManager.placeOrderAndPrintReceipt(cart);

        assertEqualsOrderTotals(expTotalAmount, expSalesTaxes, order);
    }

    @Test
    public void placeOrderCase3() throws IOException, TemplateException {

        BigDecimal expTotalAmount = BigDecimal.valueOf(74.68);
        BigDecimal expSalesTaxes = BigDecimal.valueOf(6.70);

        Cart cart = new Cart();
        cart.addItem(new OrderItem("1 imported bottle of perfume", ItemType.OTHER, true, new BigDecimal(27.99)));
        cart.addItem(new OrderItem("1 bottle of perfume", ItemType.OTHER, false, new BigDecimal(18.99)));
        cart.addItem(new OrderItem("1 packet of headache pills", ItemType.MEDICAL, false, new BigDecimal(9.75)));
        cart.addItem(new OrderItem("1 box of imported chocolates", ItemType.FOOD, true, new BigDecimal(11.25)));

        Order order = orderManager.placeOrderAndPrintReceipt(cart);

        assertEqualsOrderTotals(expTotalAmount, expSalesTaxes, order);
    }

    private void assertEqualsOrderTotals(BigDecimal expTotalAmount, BigDecimal expSalesTaxes, Order order) {
        Assert.assertEquals(0, expTotalAmount.compareTo(order.getTotalAmount()));
        Assert.assertEquals(0, expSalesTaxes.compareTo(order.getSalesTaxes()));
    }
}