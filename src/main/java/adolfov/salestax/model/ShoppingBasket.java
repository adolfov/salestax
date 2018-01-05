package adolfov.salestax.model;

import java.util.List;

public class ShoppingBasket {

    private List<Product> products;

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public List<Product> getProducts() {
        return this.products;
    }

}
