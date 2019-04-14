package springrecipes.r0208;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import springrecipes.r0208.domain.Product;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class ShoppingCart {

    private List<Product> items = new ArrayList<>();

    public void addItem(Product item) {
        items.add(item);
    }

    public List<Product> getItems() {
        return items;
    }
}
