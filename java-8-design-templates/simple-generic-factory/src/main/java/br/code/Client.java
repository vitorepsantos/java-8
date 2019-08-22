package br.code;

import java.util.UUID;

public class Client {

    public static void main(String[] args) {
        ProductFactory productFactory = new ProductFactoryDefault();
        ProductBuilder productBuilder = new ProductBuilder(productFactory);
        Product product = productBuilder.build(UUID.randomUUID(), "Joe Dell");
        System.out.println(product.uuid);
        System.out.println(product.name);
    }

}
