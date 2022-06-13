import entity.ComplexPerson;
import entity.Manager;
import entity.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.setPersonList(new ArrayList<>());
        manager.getPersonList().add(new Person("chris"));
        manager.getPersonList().add(new Person("bobby"));
        System.out.println(manager.toString());
    }
    @Test
    public void test7() {
        Manager manager = new Manager();
        List<Person> personList = new ArrayList<>();
        manager.setPersonList(personList);
        personList.add(new Person("chris"));
        personList.add(new Person("bobby"));
        System.out.println(manager.toString());
    }
}
