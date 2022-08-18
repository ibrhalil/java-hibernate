package domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverrides({
        @AttributeOverride( name = "phone", column = @Column(name = "CONTACT_PHONE")),
        @AttributeOverride( name = "eMail", column = @Column(name = "CONTACT_EMAIL")),
})
public class Contact {
    private String phone;
    private String eMail;
}