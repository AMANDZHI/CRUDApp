package crudApp.model;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "Email")
    private String email;
    @Column(name = "Login")
    private String login;
    @Column(name = "Password")
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "Role")
    private Role role;

    public User(String email, String login, String password, Role role) {
        this.email = email;
        this.login = login;
        this.password = password;
        this.role = role;
    }
}
