package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author yuanqixu
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    public List<Person> personList;
}
