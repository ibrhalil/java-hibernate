package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
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
    @CollectionTable(name = "T_PERSON_ADDRESS", joinColumns = @JoinColumn(name = "PERSON_ID"))
    private Set<Address> addresses = new HashSet<>();
}
