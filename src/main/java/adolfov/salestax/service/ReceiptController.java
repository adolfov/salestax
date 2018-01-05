package adolfov.salestax.service;

import adolfov.salestax.model.Receipt;
import adolfov.salestax.model.ShoppingBasket;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiptController {

    @RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public Receipt getReceipt(@RequestBody ShoppingBasket basket) {
        Receipt receipt = new Receipt(basket);
        return receipt;
    }

}
