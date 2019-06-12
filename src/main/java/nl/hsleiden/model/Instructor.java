package nl.hsleiden.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonView;
import nl.hsleiden.View;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "instructor")
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "instructorid", columnDefinition = "serial")
    @JsonView(View.Public.class)
    @JsonProperty("instructor_id")
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JsonProperty("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    @JsonView(View.Public.class)
    private User user;

    @NotNull
    @Length(max = 100)
    @Column(name = "first_name")
    @JsonProperty("first_name")
    @JsonView(View.Public.class)
    private String firstName;

    @Length(max = 20)
    @Column(name = "infix")
    @JsonProperty("infix")
    @JsonView(View.Public.class)
    private String infix;

    @NotNull
    @Length(max = 100)
    @Column(name = "last_name")
    @JsonProperty("last_name")
    @JsonView(View.Public.class)
    private String lastName;

    @NotNull
    @Length(min = 10, max = 20)
    @Column(name = "phone_number")
    @JsonProperty("phone_number")
    @JsonView(View.Public.class)
    private String phoneNumber;

    @NotNull
    @Email
    @Length(max = 150)
    @Column(name = "email")
    @JsonProperty("email_address")
    @JsonView(View.Public.class)
    private String email;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getInfix() {
        return infix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
