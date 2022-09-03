package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "T_PERSONS")
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, updatable = false)
    private Long personId;

    @Column(name = "NAME", nullable = false, length = 50)
    private String name;

    @Column(name = "LAST_NAME", updatable = false)
    private String lastName;

    @Column(name = "AGE")
    private Integer age;

    @Column(name = "SEX")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Temporal(TemporalType.DATE)
    private Date birthday;

    @Column(name = "CREATE_DATE", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate = new Date();

    @Lob
    private String about;

    @Transient
    private Long salary;

    public Person() {

    }

    public Person(Long personId, String name, String lastName, Integer age, Gender gender, Date birthday, Date createDate, String about, Long salary) {
        this.personId = personId;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.birthday = birthday;
        this.createDate = createDate;
        this.about = about;
        this.salary = salary;
    }

    public Long getId() {
        return personId;
    }

    public void setId(Long id) {
        this.personId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(personId, person.personId) && Objects.equals(name, person.name) && Objects.equals(lastName, person.lastName) && Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personId, name, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", birthday=" + birthday +
                ", createDate=" + createDate +
                ", about='" + about + '\'' +
                ", salary=" + salary +
                '}';
    }
}
