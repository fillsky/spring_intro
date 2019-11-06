package pl.honestit.spring.demo.model.domain;

import lombok.*;

import javax.persistence.*;

@Getter @Setter @ToString(exclude = "password")
@Builder @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String password;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column
    private boolean active;
}
