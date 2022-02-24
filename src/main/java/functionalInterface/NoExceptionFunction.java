package functionalInterface;

/**
 * @author yuanqixu
 */
@FunctionalInterface
public interface NoExceptionFunction<T, R, E extends Exception>  {
    R apply(T t) throws E;
}
