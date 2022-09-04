package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

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
    @CollectionTable(name = "T_PERSON_EMAIL", joinColumns = @JoinColumn(name = "PERSON_ID"))
    @MapKeyColumn(name = "EMAIL_TYPE")
    @Column(name = "EMAIL")
    private Map<String,String> emails = new HashMap<>();

    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @MapKeyColumn(name = "ADDRESS_TYPE")
    private Map<AddressType, Address> addresses = new HashMap<>();
}
