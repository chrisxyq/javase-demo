import entity.ComplexPerson;
import entity.Person;
import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempTest {
    @Test
    public void test1() {
        System.out.println(String.format("%s,%s","1","2"));
        System.out.println(String.format("%s","1"));
        System.out.println(String.format("'%s',%s","1","2"));
    }
    @Test
    public void test2() {
        System.out.println(StringUtils.trimFirstAndLastChar(",,%s,%s,", ",").split(","));
        System.out.println("a".compareTo("b"));
        System.out.println("b".compareTo("b"));
        System.out.println("b".compareTo("a"));
    }
    @Test
    public void test3() {
        List<ComplexPerson> complexPersonList = new ArrayList<>(Arrays.asList(new ComplexPerson(1, new Person("zhangsan"))));
        complexPersonList.get(0).getPerson().setName("zhangsanchanged");
        System.out.println(complexPersonList.get(0).getPerson().getName());
    }
}
