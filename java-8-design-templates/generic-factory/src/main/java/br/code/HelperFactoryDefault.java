package br.code;

public class HelperFactoryDefault<T> implements HelperFactory<T> {

    private Class<T> type;

    public HelperFactoryDefault(Class<T> type) {
        this.type = type;
    }

    @Override
    public T create() {
        try {
            return this.type.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException();
        }
    }
}
