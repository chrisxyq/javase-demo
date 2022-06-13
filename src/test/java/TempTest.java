import entity.ComplexPerson;
import entity.MemberCard;
import entity.Person;
import enums.OfferTypeEnum;
import javafx.util.Pair;
import org.junit.Test;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TempTest {
    @Test
    public void test1() {
        System.out.println(String.format("%s,%s", "1", "2"));
        System.out.println(String.format("%s", "1"));
        System.out.println(String.format("'%s',%s", "1", "2"));
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

    @Test
    public void test4() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(OfferTypeEnum.getEnum(2).getValue());
        buffer.append(OfferTypeEnum.getEnum(3).getValue());
        System.out.println(buffer.toString());
    }

    /**
     * 不可以对null进行for循环
     */
    @Test
    public void test5() {
        MemberCard card = new MemberCard("levelName", null);
        for (Integer integer : card.getApplyLevelList()) {
            System.out.println(integer);
        }
    }

    @Test
    public void test6() {
        System.out.println(String.format("%s(%s)", "a", "b"));
        System.out.printf("%s(%s)%n", "a", "b");
        System.out.printf("%s(%s)%n", "1", "2");
    }

    public void encrypt(String encrypted) {
        encrypted = "encrypted";
    }

    /**
     * 在方法内调用更改string的值
     * 需要传出后，才生效
     */
    @Test
    public void test7() {
        String encrypted = null;
        encrypt(encrypted);
        System.out.println(encrypted);
    }
    @Test
    public void test8() {
        System.out.println(OfferTypeEnum.AdvanceRebate.toString());
        System.out.println(OfferTypeEnum.valueOf("AdvanceRebate"));
        System.out.println(OfferTypeEnum.valueOf("AdvanceRebatte"));
    }
}
