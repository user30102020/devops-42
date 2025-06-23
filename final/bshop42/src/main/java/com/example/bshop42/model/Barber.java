package com.example.bshop42.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "barbers")
public class Barber {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "barber_name")
    private String name;

    @Column(name = "barber_experience")
    private Integer experience;

    @ManyToOne
    @JoinColumn(name = "workplace_id")
    private Workplace workplace;

    @OneToMany(mappedBy = "barber", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Registration> registrations;
}
