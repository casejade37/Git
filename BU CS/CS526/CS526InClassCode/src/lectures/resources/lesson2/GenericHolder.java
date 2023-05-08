package lectures.resources.lesson2;

/**
 * Example that holds both a Generic and an Object
 * @param <T>
 */
public class GenericHolder<T> {
    private Object anyObject;
    private T genericVar;

    public void setObject(Object someObject) {
        anyObject = someObject;
    }

    public Object getObject() {
        return anyObject;
    }

    public void setGeneric(T t) {
        genericVar = t;
    }

    public T getGeneric() {
        return genericVar;
    }
}
