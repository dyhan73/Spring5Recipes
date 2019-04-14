package springrecipes.r0210;

import springrecipes.r0210.domain.Battery;
import springrecipes.r0210.domain.Disc;
import springrecipes.r0210.domain.Product;

public class ProductCreator {
    public static Product createProduct(String productId) {
        if ("aaa".equals(productId)) {
            return new Battery("AAA", 2.5);
        } else if ("cdrw".equals(productId)) {
            return new Disc("CD-RW", 1.5);
        } else if ("dvdrw".equals(productId)) {
            return new Disc("DVD-RW", 3.0);
        }
        throw new IllegalArgumentException("Unknown product");
    }
}
