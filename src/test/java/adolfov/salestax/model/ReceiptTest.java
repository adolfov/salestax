package adolfov.salestax.model;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReceiptTest {

    private ShoppingBasket basket;
    private BasketItem singleImportedExemptItem;
    private BasketItem multipleExemptItems;
    private BasketItem singleItem;
    private BasketItem multipleImportedItems;

    @Before
    public void setup() {
        this.basket = new ShoppingBasket();

        Product product1 = new Product();
        product1.setName("Ecuatorian Chocolate Bar");
        product1.setPrice(new BigDecimal(4.99));
        product1.setExempt(true);
        product1.setImported(true);
        this.singleImportedExemptItem = new BasketItem();
        this.singleImportedExemptItem.setProduct(product1);
        this.singleImportedExemptItem.setQuantity(1);

        Product product2 = new Product();
        product2.setName("Ghirardelli Chocolate Bar");
        product2.setPrice(new BigDecimal(8.99));
        product2.setExempt(true);
        this.multipleExemptItems = new BasketItem();
        this.multipleExemptItems.setProduct(product2);
        this.multipleExemptItems.setQuantity(4);

        Product product3 = new Product();
        product3.setName("Cuphead for Xbox One");
        product3.setPrice(new BigDecimal(29.99));
        this.singleItem = new BasketItem();
        this.singleItem.setProduct(product3);
        this.singleItem.setQuantity(1);

        Product product4 = new Product();
        product4.setName("Tequila Shot glasses");
        product4.setPrice(new BigDecimal(1));
        product4.setImported(true);
        this.multipleImportedItems = new BasketItem();
        this.multipleImportedItems.setProduct(product4);
        this.multipleImportedItems.setQuantity(20);
    }

    @Test
    public void testGetTotalSingleItem() {
        this.basket.addItem(this.singleItem);
        Receipt receipt = new Receipt(this.basket);
        assertEquals(receipt.getBasketItems().size(), 1);
        assertEquals(receipt.getTotal().toString(), "33");
    }

    @Test
    public void testGetTotals0QuantityItem() {
        this.singleItem.setQuantity(0);
        this.basket.addItem(this.singleItem);
        Receipt receipt = new Receipt(this.basket);
        assertEquals(receipt.getTotal().toString(), "0");
        assertEquals(receipt.getTotalTax().toString(), "0");
    }

    @Test
    public void testGetTotalsExemptItems() {
        this.basket.addItem(this.multipleExemptItems);
        Receipt receipt = new Receipt(this.basket);
        assertEquals(receipt.getTotal().toString(), "36");
        assertEquals(receipt.getTotalTax().toString(), "0");
    }

    @Test
    public void testGetTotalMultipleImportedItems() {
        this.basket.addItem(this.multipleImportedItems);
        Receipt receipt = new Receipt(this.basket);
        assertEquals(receipt.getTotal().toString(), "23");
        assertEquals(receipt.getTotalTax().toString(), "0");
    }
}