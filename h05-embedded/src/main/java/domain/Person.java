package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "T_PERSONS")
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
    @AttributeOverrides({
            @AttributeOverride( name = "phone", column = @Column(name = "CONTACT_PHONE")),
            @AttributeOverride( name = "eMail", column = @Column(name = "CONTACT_EMAIL")),
    })
    private Contact contact;
}