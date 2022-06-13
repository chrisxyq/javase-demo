package entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComplexPerson {
    private int num;
    private Person person;

    public ComplexPerson(int num, Person person) {
        this.num = num;
        this.person = person;
    }
}
