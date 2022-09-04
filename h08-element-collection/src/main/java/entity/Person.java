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
    @CollectionTable(name = "T_PERSON_PHONE_NUM", joinColumns = @JoinColumn(name = "PERSON_ID"))
    @Column(name = "P_NUMBER", length = 11)
    private List<String> phoneNumbers = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "T_PERSON_EMAIL", joinColumns = @JoinColumn(name = "PERSON_ID"))
    @Column(name = "EMAIL", unique = true)
    private Set<String> emails = new HashSet<>();
}
