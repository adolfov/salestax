package adolfov.salestax.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = BaseProduct.class),
        @JsonSubTypes.Type(value = ExemptProduct.class, name = "exempt"),
        @JsonSubTypes.Type(value = ImportedProduct.class, name = "imported"),
})
public class BaseProduct implements Product {

    private String name;
    private BigDecimal price;

    public static final float BASE_SALES_TAX = .1f;

    public BaseProduct() {
    }

    public BaseProduct(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public BigDecimal getPriceWithTax() {
        return this.getPrice().multiply(new BigDecimal(1 + this.getTax()));
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public float getTax() {
        return BaseProduct.BASE_SALES_TAX;
    }


}
