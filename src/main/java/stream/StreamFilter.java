package stream;

import entity.Manager;
import entity.Person;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
    /**
     */
    @Test
    public void filterTest0() {
        List<Person> personList1 = new ArrayList<Person>();
        List<Person> personList2 = new ArrayList<Person>();
        List<Manager> managerList = new ArrayList<Manager>();
        personList1.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList1.add(new Person("Jack", 7000, 25, "male", "Washington"));
        Manager manager1 = new Manager(personList1);

        personList2.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList2.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList2.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList2.add(new Person("Alisa", 7900, 26, "female", "New York"));
        Manager manager2 = new Manager(personList2);
        managerList.add(manager1);
        managerList.add(manager2);
        List<String> nameList = new ArrayList<>();
        //managerList.stream().collect(Collectors.toMap(p -> p.getPersonList().get(), p -> p))
        //managerList.forEach(manager -> {
        //    List<Person> persons = manager.personList;
        //    persons = persons.stream().filter(person -> person.getAge()>24).collect(Collectors.toList());
        //    List<String> collect = persons.stream().map(Person::getName).collect(Collectors.toList());
        //    manager.setPersonList(persons);
        //    nameList.addAll(collect);
        //});
        managerList.forEach(System.out::println);
        nameList.forEach(System.out::println);
    }
    /**
     * 年龄为偶数，工资大于7000的最后一名员工大写的年龄
     */
    @Test
    public void filterTest1() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        personList.stream().filter(u -> u.getAge() % 2 == 0)
                .filter(u -> u.getSalary() > 7000).collect(Collectors.toList());
        //Stream<String> stringStream = personList.stream().filter(u -> u.getAge() % 2 == 0)
        //        .filter(u -> u.getSalary() > 7000)
        //        .map(m -> m.getName().toUpperCase())
        //        .sorted((Comparator.reverseOrder()))
        //        .limit(1);
        //stringStream.forEach(System.out::println);
        personList.forEach(System.out::println);
    }


    /**
     * 只是Stream中的元素是以Optional类型存在的。
     * Stream的遍历、匹配非常简单。
     */
    @Test
    public void findTest() {
        List<Integer> list = Arrays.asList(7, 6, 9, 3, 8, 2, 1);

        // 遍历输出符合条件的元素
        list.stream().filter(x -> x > 6).forEach(System.out::println);
        // 匹配第一个
        Optional<Integer> findFirst = list.stream().filter(x -> x > 6).findFirst();
        // 匹配任意（适用于并行流）
        Optional<Integer> findAny = list.parallelStream().filter(x -> x > 6).findAny();
        // 是否包含符合特定条件的元素
        boolean anyMatch = list.stream().anyMatch(x -> x < 6);
        System.out.println("匹配第一个值：" + findFirst.get());
        System.out.println("匹配任意一个值：" + findAny.get());
        System.out.println("是否存在大于6的值：" + anyMatch);
    }

    /**
     * 筛选出Integer集合中大于7的元素，并打印出来
     */
    @Test
    public void filterTest() {
        List<Integer> list = Arrays.asList(6, 7, 3, 8, 1, 2, 9);
        Stream<Integer> stream = list.stream();
        stream.filter(x -> x > 7).forEach(System.out::println);
    }

    /**
     * 筛选员工中工资高于8000的人，并形成新的集合。形成新集合依赖collect（收集），后文有详细介绍。
     */
    @Test
    public void filterTest2() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        List<String> fiterList = personList.stream()
                .filter(x -> x.getSalary() > 8000)
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.print("高于8000的员工姓名：" + fiterList);
    }

    /**
     * 获取String集合中最长的元素。
     */
    @Test
    public void filterTest3() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的字符串：" + max.get());
    }

    /**
     * 获取Integer集合中的最大值。
     */
    @Test
    public void filterTest4() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        // 自定义排序
        Optional<Integer> max2 = list.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自然排序的最大值：" + max.get());
        System.out.println("自定义排序的最大值：" + max2.get());
    }

    /**
     * 获取员工工资最高的人。
     */
    @Test
    public void filterTest5() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("员工工资最大值：" + max.get().getSalary());
    }

    /**
     * 计算Integer集合中大于6的元素的个数。
     */
    @Test
    public void filterTest6() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);

        long count = list.stream().filter(x -> x > 6).count();
        System.out.println("list中大于6的元素个数：" + count);
    }
}
