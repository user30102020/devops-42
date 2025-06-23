package com.example.bshop42.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID user_id;

    @Column(name = "user_firstname")
    private String firstname;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_passwordHash")
    private String passwordHash;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Registration> registrations;
}

