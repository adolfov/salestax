package adolfov.salestax.model;

import java.math.BigDecimal;

public class ImportedProduct extends BaseProduct {

    public static final float IMPORT_TAX = .05f;

    public ImportedProduct(String name, BigDecimal price) {
        super(name, price);
    }

    @Override
    public float getTax() {
        return this.getTax() + ImportedProduct.IMPORT_TAX;
    }
}
