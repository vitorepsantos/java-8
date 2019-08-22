package br.code;

import java.util.UUID;

public class ProductBuilder {

    private ProductFactory productFactory;

    public ProductBuilder(ProductFactory productFactory) {
        this.productFactory = productFactory;
    }

    public Product build(UUID uuid, String name) {
        Product product = productFactory.create();
        product.uuid = uuid;
        product.name = name;
        return product;
    }

}
