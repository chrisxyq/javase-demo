package stream;

import entity.MemberCard;
import entity.Person;
import lombok.val;
import org.junit.Test;
import utils.LevelSortUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yuanqixu
 */
public class StreamSort {
    /**
     * 根据可申请的会员等级返回商户会员卡排序
     */
    @Test
    public void sortTest2() {
        List<MemberCard> memberCardList = new ArrayList<MemberCard>();
        memberCardList.add(new MemberCard("白银商户会员", Arrays.asList(7, 2)));
        memberCardList.add(new MemberCard("普通商户会员", Arrays.asList(1, 7)));
        memberCardList.add(new MemberCard("普通商户会员", Arrays.asList(1, 7, 2)));

        System.out.println(memberCardList);
        val sortedList = memberCardList.stream()
                .sorted(Comparator.comparing(memberCard -> LevelSortUtils.getLevelSortWeightByList(memberCard.getApplyLevelList())))
                .collect(Collectors.toList());
        System.out.println(sortedList);
    }

    /**
     * sorted，中间操作。有两种排序：
     * sorted()：自然排序，流中元素需实现Comparable接口
     * sorted(Comparator com)：Comparator排序器自定义排序
     * 将员工按工资由高到低（工资一样则按年龄由大到小）排序
     * *
     */
    @Test
    public void sortTest() {
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Sherry", 9000, 24, "female", "New York"));
        personList.add(new Person("Tom", 8900, 22, "male", "Washington"));
        personList.add(new Person("Jack", 9000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 8800, 26, "male", "New York"));
        personList.add(new Person("Alisa", 9000, 26, "female", "New York"));

        // 按工资升序排序（自然排序）
        List<String> newList = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName)
                .collect(Collectors.toList());
        // 按工资倒序排序
        List<String> newList2 = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed())
                .map(Person::getName).collect(Collectors.toList());
        // 先按工资再按年龄升序排序
        List<String> newList3 = personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).thenComparing(Person::getAge)).map(Person::getName)
                .collect(Collectors.toList());
        // 先按工资再按年龄自定义排序（降序）
        List<String> newList4 = personList.stream().sorted((p1, p2) -> {
            if (p1.getSalary() == p2.getSalary()) {
                return p2.getAge() - p1.getAge();
            } else {
                return p2.getSalary() - p1.getSalary();
            }
        }).map(Person::getName).collect(Collectors.toList());

        System.out.println("按工资升序排序：" + newList);
        System.out.println("按工资降序排序：" + newList2);
        System.out.println("先按工资再按年龄升序排序：" + newList3);
        System.out.println("先按工资再按年龄自定义降序排序：" + newList4);
    }
}
