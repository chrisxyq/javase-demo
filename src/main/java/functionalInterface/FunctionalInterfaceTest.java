package functionalInterface;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import utils.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuanqixu
 */
@Slf4j
public class FunctionalInterfaceTest {
    public static String toUpperString(MyFunc<String> myFunc, String str) {
        return myFunc.getValue(str);
    }

    public static void main(String[] args) {
        String newStr = toUpperString((str) -> str.toUpperCase(), "abc");
        System.out.println(newStr);
    }

    @Test
    public void test() {
        String newStr = ExternalCatchCalling.execute("abc", (str) -> str.toUpperCase());
        System.out.println(newStr);
    }

}
