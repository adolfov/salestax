package adolfov.salestax.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;
import java.util.List;

@JsonPropertyOrder({"products","totalTax","total"})
public class Receipt {

    private ShoppingBasket basket;

    public Receipt(ShoppingBasket basket) {
        this.basket = basket;
    }

    public BigDecimal getTotalTax() {
        BigDecimal total = new BigDecimal(0);
        for (Product product : this.getProducts()) {
            total = total.add(product.getPriceWithTax().subtract(product.getPrice()));
        }
        return total;
    }

    public BigDecimal getTotal() {
        BigDecimal total = new BigDecimal(0);
        for (Product product : this.getProducts()) {
            total = total.add(product.getPriceWithTax());
        }
        return total;
    }

    public List<Product> getProducts(){
        return this.basket.getProducts();
    }

}
