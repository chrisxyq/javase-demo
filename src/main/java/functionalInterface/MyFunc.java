package functionalInterface;

@FunctionalInterface    //@FunctionalInterface标注该接口会被设计成一个函数式接口，否则会编译错误
public interface MyFunc<T> {
    T getValue(T t);
}
