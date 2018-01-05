package adolfov.salestax.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({"basketItems","totalTax","total"})
public class Receipt {

    private ShoppingBasket basket;

    public Receipt(ShoppingBasket basket) {
        this.basket = basket;
    }

    public BigDecimal getTotalTax() {
        BigDecimal total = new BigDecimal(0);
        for (BasketItem item : this.getBasketItems()) {
            if (item.getQuantity() <= 0) {
                continue;
            }
            BigDecimal itemsTotal = item.getProduct().getCalculatedTax();
            itemsTotal = itemsTotal.multiply(new BigDecimal(item.getQuantity()));
            total = total.add(itemsTotal);
        }
        return this.round(total);
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (BasketItem item : this.getBasketItems()) {
            if (item.getQuantity() <= 0) {
                continue;
            }
            BigDecimal itemsTotal = item.getProduct().getPriceWithTax();
            itemsTotal = itemsTotal.multiply(new BigDecimal(item.getQuantity()));
            total = total.add(itemsTotal);
        }
        return this.round(total);
    }

    private BigDecimal round(BigDecimal price) {
        return new BigDecimal(Math.round(price.doubleValue() * 20) / 20.0);
    }

    public List<BasketItem> getBasketItems(){
        return this.basket.getItems();
    }

}
