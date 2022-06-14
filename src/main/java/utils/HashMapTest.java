package utils;

import entity.ComplexPerson;
import entity.Person;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Long, ComplexPerson> map = new HashMap<>();
        map.put(1L, new ComplexPerson(1, new Person("jack")));
        String serialize = JsonUtils.serialize(map);
        System.out.println(serialize);
        HashMap<Long, ComplexPerson> hashMap = JsonUtils.getMap(serialize, (Class<HashMap<Long, ComplexPerson>>) (Object)HashMap.class);
        ComplexPerson complexPerson = hashMap.get("key");
        //System.out.println(complexPerson);
    }
}
