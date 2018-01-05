package adolfov.salestax.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

@JsonPropertyOrder({"name","price","exempt","imported"})
public class Product {

    public static final float BASE_SALES_TAX = .1f;

    public static final float IMPORTED_TAX = .05f;

    private String name;
    private BigDecimal price;
    private boolean exempt;
    private boolean imported;

    public Product() {
    }

    public float getTax() {
        float tax = 0f;
        if (!this.exempt) {
            tax += Product.BASE_SALES_TAX;
        }
        if (this.imported) {
            tax += Product.IMPORTED_TAX;
        }
        return tax;
    }

    public BigDecimal getPriceWithTax() {
        return this.round(this.getPrice().multiply(new BigDecimal(1 + this.getTax())));
    }

    private BigDecimal round(BigDecimal price) {
        return new BigDecimal(Math.round(price.doubleValue() * 20) / 20.0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isExempt() {
        return exempt;
    }

    public void setExempt(boolean exempt) {
        this.exempt = exempt;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    }

}
