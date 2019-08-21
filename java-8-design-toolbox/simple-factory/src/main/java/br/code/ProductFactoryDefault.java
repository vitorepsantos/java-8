package br.code;

public class ProductFactoryDefault extends FactoryDefault<Product> implements ProductFactory {

    public ProductFactoryDefault() {
        super(Product.class);
    }

}
