package adolfov.salestax.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingBasket {

    private List<BasketItem> items;

    public ShoppingBasket() {
        this.items = new ArrayList<BasketItem>();
    }

    public void addItem(BasketItem item) {
        this.items.add(item);
    }

    public List<BasketItem> getItems() {
        return this.items;
    }

}
