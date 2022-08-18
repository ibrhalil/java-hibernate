package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_PERSONS")
@SecondaryTable(name = "T_CONTACTS", pkJoinColumns = @PrimaryKeyJoinColumn(name = "PERSON_ID"))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String lastName;

    @Embedded
    private Contact contact;
}