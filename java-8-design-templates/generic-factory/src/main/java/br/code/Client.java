package br.code;

import java.util.UUID;

public class Client {

    public static void main(String[] args) {

        HelperFactory<Product> productHelperFactory = new HelperFactoryDefault<>(Product.class);

        ProductFactory productFactory = new ProductFactoryDefault(productHelperFactory);

        Product product = productFactory.create();

        product.setUuid(UUID.randomUUID());
        product.setName("Joe Dell");

        System.out.println(product.getUuid());
        System.out.println(product.getName());

    }

}
