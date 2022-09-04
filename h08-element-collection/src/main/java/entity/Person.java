package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String lastName;

    @ElementCollection
    private List<String> phoneNumbers;

    @ElementCollection
    private Set<String> emails;
}
