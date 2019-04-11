package springrecipes.i18n;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;
import java.util.Locale;

@Component
public class Cashier {

    @Autowired
    private MessageSource messageSource;

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String checkout(ShoppingCart cart) {
        try {
            String alert = messageSource.getMessage("alert.inventory.checkout",
                    new Object[] { cart.getItems(), new Date()}, Locale.US);
            return alert;
        } catch(Exception e) {
            return "Error : " + e.getMessage();
        }
    }
}
