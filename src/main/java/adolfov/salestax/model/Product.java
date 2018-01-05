package adolfov.salestax.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.math.BigDecimal;

@JsonDeserialize(as = BaseProduct.class)
public interface Product {

    public String getName();

    public BigDecimal getPrice();

    public float getTax();

    public BigDecimal getPriceWithTax();

}
