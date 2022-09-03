package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {

    @Column(table = "T_CONTACTS", name = "CONTACT_PHONE")
    private String phone;

    @Column(table = "T_CONTACTS", name = "CONTACT_EMAIL")
    private String eMail;
}