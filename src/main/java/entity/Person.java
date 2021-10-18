package entity;

import lombok.Data;

/**
 * @author yuanqixu
 */
@Data
public class Person {

    private String name;
    private int salary;
    private int age;
    private String sex;
    private String area;

    // 构造方法
    public Person(String name, int salary, int age,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    public Person(String name, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }

}
