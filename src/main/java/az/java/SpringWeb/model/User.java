package az.java.SpringWeb.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "email", nullable = false, unique = true, length = 45)
    private String email;

    @Column(name = "password", length = 15, nullable = false)
    private String password;

    @Column(name = "first_name", length = 45, nullable = false)
    private String firstname;

    @Column(name = "last_name", length = 45, nullable = false)
    private String lastname;

    private boolean enabled;
}
