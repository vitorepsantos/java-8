package br.code;

public class ProductFactoryDefault implements ProductFactory {

    private HelperFactory<Product> productHelperFactory;

    public ProductFactoryDefault(HelperFactory helperFactory) {
        productHelperFactory = helperFactory;
    }

    @Override
    public Product create() {
        return productHelperFactory.create();
    }
}
