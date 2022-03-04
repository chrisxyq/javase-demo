package entity;

import lombok.Data;

@Data
public class ComplexPerson {
    private int num;
    private Person person;

    public ComplexPerson(int num, Person person) {
        this.num = num;
        this.person = person;
    }
}
