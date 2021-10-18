

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@FunctionalInterface
interface Poo {
    int add(int x, int y);

    default int mull(int x, int y) {
        return x * y;
    }

    static int div(int x, int y) {
        return x / y;
    }
}

/**
 * @author yuanqixu
 */
public class LambdaExpressTest {
    @Test
    public void test() {
        Poo poo1 = (int x, int y) -> {
            System.out.println("add");
            return x + y;
        };
        System.out.println(poo1.add(2, 3));

        System.out.println(poo1.mull(3, 4));

        System.out.println(Poo.div(8, 4));
    }
    @Test
    public void test2(){
        //函数型接口
        Function<String,Integer> function = s -> {return s.length();};
        System.out.println(function.apply("abc"));
        //断定型接口
        Predicate<String> predicate = s -> {return s.isEmpty();};
        System.out.println(predicate.test("张三"));
        //消费型接口
        Consumer<String> consumer = s -> { System.out.println(s);};
        consumer.accept("李四");
        //供给型接口
        Supplier<String> supplier = () -> {return "王五";};
        System.out.println(supplier.get());
    }
}
