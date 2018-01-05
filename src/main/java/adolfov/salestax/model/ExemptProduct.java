package adolfov.salestax.model;

import java.math.BigDecimal;

public class ExemptProduct extends BaseProduct {

    public ExemptProduct(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public float getTax() {
        return 0f;
    }

}
