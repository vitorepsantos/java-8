package br.code;

public class FactoryDefault<T> implements Factory<T> {

    private Class<T> clazz;

    public FactoryDefault(Class clazz) {
        this.clazz = clazz;
    }

    public T create() {
        try {
            T t = this.clazz.newInstance();
            return t;
        } catch (InstantiationException | IllegalAccessException exception) {
            throw new RuntimeException();
        }

    }

}
